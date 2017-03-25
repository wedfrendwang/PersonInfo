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
		//�ж��û��Ƿ��ǵ�½��״̬
		if(request.getSession().getAttribute("name")==null){
			response.sendRedirect("index.jsp");
			return;
		}
		
//		request.getRequestDispatcher("example.jsp").forward(request, response);

		//�鿴cookֵ
		Cookie[] cookies = request.getCookies();
		if(cookies!= null){
			for (int i = 0; i < cookies.length; i++) {
				System.out.println("cookies[i].getName()-------"+cookies[i].getName());
				System.out.println("cookies[i].getValue()------"+cookies[i].getValue());
			}
		}
		//��session��ȡֵ
		HttpSession session = request.getSession();
		
		String name = (String)session.getAttribute("name");
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>wedfrend introduction</TITLE></HEAD>");
		out.println("  <BODY>");
		out.println("���ǵ�<span>"+this.getServletContext().getAttribute("count")+"</span>λ���ʸ���վ");
		out.print("<h1 width='80%' align='center'>welcome to <b>"+name+"</b> webpage!</h1><hr/> ");
		out.print("<p width='80%' align='right'>");
		out.print("<b>�����˵ļ�ǿ�������������ļ�</b><br/>");
		out.print("<big>���м����ӣ����е�ÿһ�룬�㶼Ը����һ��ȥ��ȡ</big><br/>");
		out.print("����<em>���仰</em>�����е�ÿ�����ۣ��㶼Ը�������е�<i>ҹ��</i>ȥ��ϰ<br/>");
		out.print("<small>���м��γ���</small>�����е�ÿ�����棬�㶼Ը����ȫ��������ȥ����<br/>");
		out.print("<strong>���м�<sub>����</sub>�����е�ÿһ��<sup>����</sup>���㶼Ը�������ֵĳ�ŵȥ����</strong><br/>");
		out.print("</p>");
		out.print("<hr/>");
		
		
		
		out.print("<a href='my.html'><h5>"+name+" CSDN link</h5></a>");
		out.print("<a href='context'><h5>����������</h5></a>");
		out.print("<a href='relation'><h5>�����б�</h5></a>");
		out.print("<a href='mylist.jsp'><h5>�����б�jsp</h5></a>");
		out.print("<a href='books'><h5>�鼮�б�</h5></a>");
		out.print("<a href='upload1.jsp'><h5>�ϴ�ͼƬ��Դ</h5></a>");
		out.print("<a href='download.jsp'><h5>������Դ</h5></a>");
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
	 * ����ê
	 * @param out
	 */
	private void author(PrintWriter out){

		
		out.print("<tr>");
		out.print("<a href='#first'>�ҵĽ���</a>");
		out.print("</tr><br/>");
		
		out.print("<tr>");
		out.print("<a href='#second'>�ҵļ���</a>");
		out.print("</tr><br/>");
		
		out.print("<tr>");
		out.print("<a href='#thrid'>�����س�</a>");
		out.print("</tr><br/>");
		for (int i = 0; i < 50; i++) {
			out.print(i+"<br/>");
		}
		out.print("<tr>");
		out.print("<a name='first'>�ҵĽ���</a>");
		out.print("</tr><br/>");
		for (int i = 0; i < 50; i++) {
			out.print(i+"<br/>");
		}
		out.print("<tr>");
		out.print("<a name='second'>�ҵļ���</a>");
		out.print("</tr><br/>");
		for (int i = 0; i < 50; i++) {
			out.print(i+"<br/>");
		}
		out.print("<tr>");
		out.print("<a name='thrid'>�����س�</a>");
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
