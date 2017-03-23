package cn.wedfrend.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/loginfirst")
public class LoginFirstServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		/**
		 * 检查cookie是否有值
		 */
		Cookie[] cookies = req.getCookies();
		String nameCK = null;
		String pswCK = null;
		
		if(cookies!=null)
		for (Cookie cookie : cookies) {
			if("name".equals(cookie.getName())){
				nameCK = cookie.getValue();
				System.out.println(nameCK);
			}
			if("psw".equals(cookie.getName())){
				pswCK = cookie.getValue();
			}
		}
//		写出一个网页也真是邪乎
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print(" 用户登录 <br/>");
		out.print("<form action=\"index\" method=\"post\">");
		out.print("用户名:<input type=\"text\" name=\"name\" value=\""+(nameCK!=null?nameCK.replaceAll("\\s+", ""):"")+"\"/><br/><br/>");
		out.print("密	码:<input type=\"password\" name=\"psw\"value=\""+(pswCK!=null?pswCK:"")+"\" /><br/><br/>");
		out.print("<input type=\"checkbox\" name=\"isRemeber\" value=\"1\"/>记住密码<br/>    <br/>  ");
		out.print("<input type=\"submit\" value=\"submit\"/><br/>");
		out.print("</form>");
		out.print("<a href='resign.html'>没有账号！点击注册</a>");
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
