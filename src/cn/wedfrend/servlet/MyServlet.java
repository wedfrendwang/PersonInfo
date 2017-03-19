package cn.wedfrend.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//解决post提交的乱码
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		//使用这种方式可以解决Get提交的乱码问题
		name = new String(name.getBytes("iso-8859-1"), "utf-8");
		//还有一种方式解决乱码：
		/**
		 * 在tomcat的配置文件中找到server.xml
		 * connector:
		 * URIEncoding="utg-8" useBodyEncodingForURI="true"属性
		 */
		//接着说：Request的其他属性，，几个常用的属性：
		System.out.println("ContentPath"+request.getContextPath());
		System.out.println("URI"+request.getRequestURI());
		System.out.println("URL"+request.getRequestURL());
		System.out.println("ip"+request.getRemoteAddr());
		System.out.println("Host"+request.getRemoteHost());
		
		
		
		
		String sex = request.getParameter("sex");
		String xueli = request.getParameter("xueli");
		String[] hobbys = request.getParameterValues("hobbies");
		String[] books = request.getParameterValues("books");
		String introduce = request.getParameter("introduce");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.print("name-->"+name+"<br/>");
		out.print("sex-->"+sex+"<br/>");
		out.print("xueli-->"+xueli+"<br/>");
		out.print("hb--><br/>");
		for (String hb : hobbys) {
			out.print(hb+",");
		}
		out.print("<br/>");
		out.print("hb--><br/>");
		for (String book : books) {
			out.print(book+",");
		}
		out.print("<br/>");
		out.print("introduce-->"+introduce+"<br/>");
		
		
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
