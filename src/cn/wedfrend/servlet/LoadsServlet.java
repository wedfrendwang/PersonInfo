package cn.wedfrend.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
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
			ServletContext sc = this.getServletContext();
			if(sc.getAttribute("count") == null){
				sc.setAttribute("count",1);
			}else{
				int count = (Integer) sc.getAttribute("count");
				sc.setAttribute("count",++count);
			}
			//向session中存储区值
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("name", us.getName());//我们该用户的名字存入session
			httpSession.setMaxInactiveInterval(10*60);//10分钟之后失效
			
			//设置session超时的时间：在DD文件中也可以
			/**
			 * <!-- 这里设置的直接是时间  以分钟为单位-->
				  <session-config>
				  	<session-timeout>13</session-timeout>
				  </session-config>
			 */
			
			//写一些数据至cookie
			
			/**
			 * 说说cookie
			 * 
			 * cookie 原先设计出来是为了帮助支持回话状态
			 * 
			 * 但是也可以使用cookie来进行其他的操作
			 * 
			 * 
			 * 关于会话的迁移：：：：
			 * 应用的各个部分可以复制在网络中的多个节点上
			 * 
			 * 在一个集群环境中，容器可能会完成负载平衡，取得客户的请求，把请求发送到多个JVM上
			 * 
			 * 这些JVM可能在同一个物理主机上，可能在不同的物理主机上
			 * 
			 */
			
			
			
			Cookie cookie = new Cookie("name",us.getName());
			cookie.setMaxAge(10*60);
			resp.addCookie(cookie);
			Cookie cookie2 = new Cookie("psw", us.getPws());
			cookie2.setMaxAge(10*60);
			resp.addCookie(cookie2);
			//这些存储完成之后，那么我们现在应该做跳转,这里有一个session的name
			resp.sendRedirect(resp.encodeRedirectURL("load"));
			
			
//			PrintWriter out = resp.getWriter();
//			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
//			out.println("<HTML>");
//			out.println("  <HEAD><TITLE>wedfrend introduction</TITLE></HEAD>");
//			out.println("  <BODY>");
//			out.print("</p>");
//			out.print("<hr/>");
//			out.print("<a href="+resp.encodeURL("load") +"><h5>"+name+" CSDN link</h5></a>");
//			
//			out.println("  </BODY>");
//			out.println("</HTML>");
//			out.flush();
//			out.close();
			
			
			
			System.out.println("-------------------------------");
			
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
