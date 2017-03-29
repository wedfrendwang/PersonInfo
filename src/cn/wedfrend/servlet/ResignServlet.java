package cn.wedfrend.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wedfrend.dao.UserDAO;
@WebServlet("/resign")
public class ResignServlet extends HttpServlet{
	private UserDAO userDAO = new UserDAO();
	//注册界面，那么应该进行数据库的插入操作
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		String op = req.getParameter("op");
		System.out.println("op ====="+op);
		//注册
		if("1".equals(op)||op == null){
			
			resignNewUser(req,resp);
			
		}else if("2".equals(op)){//验证用户名是否已经存在
			
			checkUserName(req,resp);
		}
		
		
		
		
		
		
		
		
		
		
	}
	
	private void checkUserName(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("UserName");
		System.out.println("name ====="+name);
			switch (userDAO.getAjaxUserByname(name)) {
			case 0://可以注册
				System.out.println("0 ====="+0);
				resp.getWriter().print("0");
				break;

			case 1://用户名已经存在
				System.out.println("1 ====="+1);
				resp.getWriter().print("该用户名已经被注册");
				break;
			default:
				break;
			}
	}

	private void resignNewUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		//在注册之前，必须判断是否有名称已经被注册过了。
			String name = req.getParameter("UserName");
			String psw = req.getParameter("psw");
				switch (userDAO.resignUser(name, psw)) {
				case 0://注册成功
					resp.sendRedirect("index.jsp");
					break;

				case 1:
					resp.getWriter().print("注册失败");
//					resp.getWriter().print("<a href='resign.html'>点击注册</a>");
//					resp.getWriter().print("<br/><a href='load.jsp'>点击登陆</a>");
					break;
				case 2:
					resp.getWriter().print("用户名已存在，请重新注册<br/>");
//					resp.getWriter().print("<a href='resign.html'>点击注册</a>");
//					resp.getWriter().print("<br/><a href='load.jsp'>点击登陆</a>");
					break;
				default:
					break;
				}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
