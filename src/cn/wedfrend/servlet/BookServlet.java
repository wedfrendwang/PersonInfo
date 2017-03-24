package cn.wedfrend.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wedfrend.category.Book;
import cn.wedfrend.category.Category;
import cn.wedfrend.dao.BookDAO;
import cn.wedfrend.dao.CategoryDAO;
import cn.wedfrend.util.PageUtil;
@WebServlet({"/book","/books"})
public class BookServlet extends HttpServlet{
	private BookDAO bookDAO = new BookDAO();
	private CategoryDAO categoryDAO = new CategoryDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//该参数指明即将请求的操作方法
		/*
		 * action = list :查询所有
		 * 
		 * action = update:更新
		 * 
		 * action = del:删除
		 * action = toadd：进入添加页面
		 * action = add:添加
		 * 
		 * action = select:查询单个
		 */
		String action = req.getParameter("op");
		if(action == null || "list".equals(action)){
			//走方法
			list(req,resp);
		}else if("toadd".equals(action)){//添加之前的显示
			toAdd(req,resp);
		}else if("add".equals(action)){//请求添加，需要操作数据库的
			add(req,resp);
		}
		else if("selectid".equals(action)){//查询单个数据，根据id
			//任务，与添加试着共用一个界面
		}else if("update".equals(action)){
			
		}else if("del".equals(action)){
			del(req,resp);
		}
		
		
		
	}
	
	/**
	 * 删除
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void del(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		if(bookDAO.del(Integer.parseInt(req.getParameter("id")))>0){
			resp.sendRedirect("book");
		}else{
			resp.sendRedirect("error.jsp");
		}
			
	}

	/**添加书籍内容至数据库中
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
		//前提，要确保价格就是数字类型，但是jsp中对价格这一块
		int categoryId = Integer.parseInt(req.getParameter("categoryId"));//数据库中的是int类型
		String author = req.getParameter("author");
		double price = Double.parseDouble(req.getParameter("price"));//数据库中的是double类型
		Date date = null;//数据库中的是date类型
		try {
			date =  new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("date"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Book book = new Book(name, author, price, date, categoryId);
		if(bookDAO.addBook(book)>0){
			//添加数据成功
			resp.sendRedirect("book");
		}else{
			//添加数据失败
			resp.sendRedirect("error.jsp");//可以专门写一个JSP的错误界面，很漂亮的一个界面
		}
		
	}

	/**
	 * 进入添加的界面
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Category> listCategory = categoryDAO.getAllCategory();
		req.setAttribute("category", listCategory);
		req.getRequestDispatcher("addbook.jsp").forward(req, resp);
	}

	/**
	 * 查询所有
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//既然做了分页处理，那么你的当前页数需要传入进来
		PageUtil pg = new PageUtil();
		//设置总共记录数
		pg.setTotalCount(bookDAO.getAllCount());
		//这个每个界面显示的个数
		pg.setPageSize(3);
		//默认的页数1
		int currentpage = 1;
		if(req.getParameter("current")!=null){//从请求中获取当前页数，是不是
			currentpage = Integer.parseInt(req.getParameter("current"));
		}
		pg.setCurrentPage(currentpage);
		List<Book> list = bookDAO.getAllBook(pg);
		List<Category> listCategory = categoryDAO.getAllCategory();
		if(listCategory != null){
			req.setAttribute("list", list);
			req.setAttribute("category", listCategory);
			//将该类传出
			req.setAttribute("page", pg);
			req.getRequestDispatcher("book.jsp").forward(req, resp);
		}else{
			resp.sendRedirect("error.jsp");//可以专门写一个JSP的错误界面，很漂亮的一个界面
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
