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
 * �������дservletContextȫ�ֲ���
 * 
 * ȫ�ֲ���������д��ʽ
 * 
 * ʵ�����ǣ�1��������վ�ĵڼ�����
 * 
 * 2��һ�������ң����������ʹ�øù���
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
		//��ǰ��½�˵�����
		String name = (String) session.getAttribute("name");
		//��ȡȫ�ֵ��ļ�����
		ServletContext sc = this.getServletContext();
		//�ڼ�����
		int count = (Integer) sc.getAttribute("count");
		if(sc.getAttribute("content") == null){
			//����һ����ֵ
			sc.setAttribute("content", "");
		}
		String content = (String) sc.getAttribute("content");
		content = content + name+":"+ (message==null?("��"+count+"���뷿��"):message)+"\r\n";
		sc.setAttribute("content", content);
//		System.out.println(this.getServletContext().getInitParameter("wang"));
//		System.out.println(this.getServletContext().getInitParameter("xiao"));
//		��ȡ�ļ�
//		InputStream is = this.getServletContext().getResourceAsStream("db.properties");
//		Properties pro = new Properties();
//		pro.load(is);
//		System.out.println(pro.getProperty("Driver"));
//		System.out.println(pro.get("Url"));
		/*
		 * ������ȡ�ļ�
		 */
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print(" �ҵ�������<br/>");
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
