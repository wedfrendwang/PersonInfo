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
		String op = req.getParameter("op");
		System.out.println("op ====="+op);
		//ע��
		if("1".equals(op)||op == null){
			
			resignNewUser(req,resp);
			
		}else if("2".equals(op)){//��֤�û����Ƿ��Ѿ�����
			
			checkUserName(req,resp);
		}
		
		
		
		
		
		
		
		
		
		
	}
	
	private void checkUserName(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("UserName");
		System.out.println("name ====="+name);
			switch (userDAO.getAjaxUserByname(name)) {
			case 0://����ע��
				System.out.println("0 ====="+0);
				resp.getWriter().print("0");
				break;

			case 1://�û����Ѿ�����
				System.out.println("1 ====="+1);
				resp.getWriter().print("���û����Ѿ���ע��");
				break;
			default:
				break;
			}
	}

	private void resignNewUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		//��ע��֮ǰ�������ж��Ƿ��������Ѿ���ע����ˡ�
			String name = req.getParameter("UserName");
			String psw = req.getParameter("psw");
				switch (userDAO.resignUser(name, psw)) {
				case 0://ע��ɹ�
					resp.sendRedirect("index.jsp");
					break;

				case 1:
					resp.getWriter().print("ע��ʧ��");
//					resp.getWriter().print("<a href='resign.html'>���ע��</a>");
//					resp.getWriter().print("<br/><a href='load.jsp'>�����½</a>");
					break;
				case 2:
					resp.getWriter().print("�û����Ѵ��ڣ�������ע��<br/>");
//					resp.getWriter().print("<a href='resign.html'>���ע��</a>");
//					resp.getWriter().print("<br/><a href='load.jsp'>�����½</a>");
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
