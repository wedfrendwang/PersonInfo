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
	//ע����棬��ôӦ�ý������ݿ�Ĳ������
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		
		String name = req.getParameter("name");
		String psw = req.getParameter("psw");
		
		//��ע��֮ǰ�������ж��Ƿ��������Ѿ���ע����ˡ�
		switch (userDAO.resignUser(name, psw)) {
		case 0://ע��ɹ�
			resp.sendRedirect("index.jsp");
			break;

		case 1:
			resp.getWriter().print("ע��ʧ��");
			resp.getWriter().print("<a href='resign.html'>���ע��</a>");
			break;
		case 2:
			resp.getWriter().print("�û����Ѵ��ڣ�������ע��<br/>");
			resp.getWriter().print("<a href='resign.html'>���ע��</a>");
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
