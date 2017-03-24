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
		//�ò���ָ����������Ĳ�������
		/*
		 * action = list :��ѯ����
		 * 
		 * action = update:����
		 * 
		 * action = del:ɾ��
		 * action = toadd���������ҳ��
		 * action = add:���
		 * 
		 * action = select:��ѯ����
		 */
		String action = req.getParameter("op");
		if(action == null || "list".equals(action)){
			//�߷���
			list(req,resp);
		}else if("toadd".equals(action)){//���֮ǰ����ʾ
			toAdd(req,resp);
		}else if("add".equals(action)){//������ӣ���Ҫ�������ݿ��
			add(req,resp);
		}
		else if("selectid".equals(action)){//��ѯ�������ݣ�����id
			//������������Ź���һ������
		}else if("update".equals(action)){
			
		}else if("del".equals(action)){
			del(req,resp);
		}
		
		
		
	}
	
	/**
	 * ɾ��
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

	/**����鼮���������ݿ���
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
		//ǰ�ᣬҪȷ���۸�����������ͣ�����jsp�жԼ۸���һ��
		int categoryId = Integer.parseInt(req.getParameter("categoryId"));//���ݿ��е���int����
		String author = req.getParameter("author");
		double price = Double.parseDouble(req.getParameter("price"));//���ݿ��е���double����
		Date date = null;//���ݿ��е���date����
		try {
			date =  new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("date"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Book book = new Book(name, author, price, date, categoryId);
		if(bookDAO.addBook(book)>0){
			//������ݳɹ�
			resp.sendRedirect("book");
		}else{
			//�������ʧ��
			resp.sendRedirect("error.jsp");//����ר��дһ��JSP�Ĵ�����棬��Ư����һ������
		}
		
	}

	/**
	 * ������ӵĽ���
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
	 * ��ѯ����
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��Ȼ���˷�ҳ������ô��ĵ�ǰҳ����Ҫ�������
		PageUtil pg = new PageUtil();
		//�����ܹ���¼��
		pg.setTotalCount(bookDAO.getAllCount());
		//���ÿ��������ʾ�ĸ���
		pg.setPageSize(3);
		//Ĭ�ϵ�ҳ��1
		int currentpage = 1;
		if(req.getParameter("current")!=null){//�������л�ȡ��ǰҳ�����ǲ���
			currentpage = Integer.parseInt(req.getParameter("current"));
		}
		pg.setCurrentPage(currentpage);
		List<Book> list = bookDAO.getAllBook(pg);
		List<Category> listCategory = categoryDAO.getAllCategory();
		if(listCategory != null){
			req.setAttribute("list", list);
			req.setAttribute("category", listCategory);
			//�����ഫ��
			req.setAttribute("page", pg);
			req.getRequestDispatcher("book.jsp").forward(req, resp);
		}else{
			resp.sendRedirect("error.jsp");//����ר��дһ��JSP�Ĵ�����棬��Ư����һ������
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
