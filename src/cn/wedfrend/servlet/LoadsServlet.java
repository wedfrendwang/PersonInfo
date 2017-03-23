package cn.wedfrend.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.wedfrend.category.user;
import cn.wedfrend.dao.UserDAO;


@WebServlet("/loads")
public class LoadsServlet extends HttpServlet{
	private UserDAO userDAO = new UserDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * MVC模式来进行处理事件
		 * 
		 * 1.获取数据
		 * 
		 * 2.进行判断
		 * 
		 * 3.做出流转
		 * 
		 */
		
		//1.先处理编码问题
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		//2.获取浏览器传出的数据(后台的判断这些参数，前端必须控制不为空，有时候的转码问题)
		String name = req.getParameter("name");
		String pass = req.getParameter("psw");
		//3.进行数据库的匹配，逻辑处理
		user us = new user(name, pass);
		us = userDAO.getUser(us);
		if(us!=null){//说明登陆成功，并返回数据库中该用户的信息数据
			
			//向session中存储区值
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("name", us.getName());//我们该用户的名字存入session
			httpSession.setMaxInactiveInterval(10*60);//10分钟之后失效
			//写一些数据至cookie
			Cookie cookie = new Cookie("name",us.getName());
			cookie.setMaxAge(10*60);
			resp.addCookie(cookie);
			Cookie cookie2 = new Cookie("psw", us.getPws());
			cookie2.setMaxAge(10*60);
			resp.addCookie(cookie2);
			//这些存储完成之后，那么我们现在应该做跳转
			resp.sendRedirect("indexs.jsp");
			
		}else{
			//说明查询数据库失败，那么有可能没有该用户的信息，或者登录名或密码错误
			req.setAttribute("msg", "用户名或密码错误");
			req.getRequestDispatcher("load.jsp").forward(req, resp);
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
