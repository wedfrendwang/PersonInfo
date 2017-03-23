package cn.wedfrend.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * @author welive
 * 
 * 这个类来写servletContext全局参数
 * 
 * 全局参数两种书写方式
 * 
 * 实践的是：1：进入网站的第几个人
 * 
 * 2：一个聊天室，着这个界面使用该功能
 *
 */
@WebServlet("/context")
public class ContextServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		String message = req.getParameter("mes");
		HttpSession session = req.getSession();
		//当前登陆人的姓名
		String name = (String) session.getAttribute("name");
		//获取全局的文件变量
		ServletContext sc = this.getServletContext();
		//第几个人
		int count = (Integer) sc.getAttribute("count");
		if(sc.getAttribute("content") == null){
			//设置一个空值
			sc.setAttribute("content", "");
		}
		String content = (String) sc.getAttribute("content");
		content = content + name+":"+ (message==null?("第"+count+"加入房间"):message)+"\r\n";
		sc.setAttribute("content", content);
//		System.out.println(this.getServletContext().getInitParameter("wang"));
//		System.out.println(this.getServletContext().getInitParameter("xiao"));
//		读取文件
//		InputStream is = this.getServletContext().getResourceAsStream("db.properties");
//		Properties pro = new Properties();
//		pro.load(is);
//		System.out.println(pro.getProperty("Driver"));
//		System.out.println(pro.get("Url"));
		/*
		 * 来，读取文件
		 */
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print(" 我的聊天室<br/>");
		out.print("<form action=\"context\" method=\"post\">");
		out.print("<textarea name=\"introduce\" rows=\"10\" ,class=\"6\">"+content+"</textarea><br/>");
		out.print("<input type=\"text\" name=\"mes\"/>");
		out.print("<input type=\"submit\" value=\"submit\"/><br/>");
		out.print("</form>");
		out.print("</body>");
		out.print("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
