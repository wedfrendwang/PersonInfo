package cn.wedfrend.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoadServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoadServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

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

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html charset='utf-8'");
		response.setCharacterEncoding("utf-8");
		//判断用户是否是登陆的状态
		if(request.getSession().getAttribute("name")==null){
			response.sendRedirect("index.jsp");
			return;
		}
		
//		request.getRequestDispatcher("example.jsp").forward(request, response);

		//查看cook值
		Cookie[] cookies = request.getCookies();
		if(cookies!= null){
			for (int i = 0; i < cookies.length; i++) {
				System.out.println("cookies[i].getName()-------"+cookies[i].getName());
				System.out.println("cookies[i].getValue()------"+cookies[i].getValue());
			}
		}
		//从session中取值
		HttpSession session = request.getSession();
		
		System.out.println(session.isNew());
		
		String name = (String)session.getAttribute("name");
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>wedfrend introduction</TITLE></HEAD>");
		out.println("  <BODY>");
		out.println("您是第<span>"+this.getServletContext().getAttribute("count")+"</span>位访问该网站");
		out.print("<h1 width='80%' align='center'>welcome to <b>"+name+"</b> webpage!</h1><hr/> ");
		out.print("<p width='80%' align='right'>");
		out.print("<b>所有人的坚强，都是柔软生的茧</b><br/>");
		out.print("<big>总有几分钟，其中的每一秒，你都愿意拿一年去换取</big><br/>");
		out.print("总有<em>几句话</em>，其中的每个字眼，你都愿意拿所有的<i>夜晚</i>去复习<br/>");
		out.print("<small>总有几段场景</small>，其中的每幅画面，你都愿意拿全部的力量去铭记<br/>");
		out.print("<strong>总有几<sub>颗泪</sub>，其中的每一次<sup>抽泣</sup>，你都愿意拿满手的承诺去代替</strong><br/>");
		out.print("</p>");
		out.print("<hr/>");
		
		
		
		out.print("<a href="+response.encodeURL("my.html")+"><h5>"+name+" CSDN link</h5></a>");
		out.print("<a href='context'><h5>进入聊天室</h5></a>");
		out.print("<a href='relation'><h5>爱好列表</h5></a>");
		out.print("<a href='mylist.jsp'><h5>爱好列表jsp</h5></a>");
		out.print("<a href='books'><h5>书籍列表</h5></a>");
		out.print("<a href='upload1.jsp'><h5>上传图片资源</h5></a>");
		out.print("<a href='download.jsp'><h5>下载资源</h5></a>");
		out.print("<a href='example.jsp'><h5>EL表达式自定义taglib</h5></a>");
		out.print("<a href='hobby.jsp'><h5>个人爱好列表</h5></a>");
//		author(out);
		out.print("<hr/>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the   "+request.getMethod()+"   method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
		
	}
	
	
	/**
	 * 定义锚
	 * @param out
	 */
	private void author(PrintWriter out){

		
		out.print("<tr>");
		out.print("<a href='#first'>我的介绍</a>");
		out.print("</tr><br/>");
		
		out.print("<tr>");
		out.print("<a href='#second'>我的简历</a>");
		out.print("</tr><br/>");
		
		out.print("<tr>");
		out.print("<a href='#thrid'>技术特长</a>");
		out.print("</tr><br/>");
		for (int i = 0; i < 50; i++) {
			out.print(i+"<br/>");
		}
		out.print("<tr>");
		out.print("<a name='first'>我的介绍</a>");
		out.print("</tr><br/>");
		for (int i = 0; i < 50; i++) {
			out.print(i+"<br/>");
		}
		out.print("<tr>");
		out.print("<a name='second'>我的简历</a>");
		out.print("</tr><br/>");
		for (int i = 0; i < 50; i++) {
			out.print(i+"<br/>");
		}
		out.print("<tr>");
		out.print("<a name='thrid'>技术特长</a>");
		out.print("</tr><br/>");
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
		System.out.println("Init Servlet");
	}

}
