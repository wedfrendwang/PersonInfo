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
		 * MVCģʽ�����д����¼�
		 * 
		 * 1.��ȡ����
		 * 
		 * 2.�����ж�
		 * 
		 * 3.������ת
		 * 
		 */
		
		//1.�ȴ����������
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		//2.��ȡ���������������(��̨���ж���Щ������ǰ�˱�����Ʋ�Ϊ�գ���ʱ���ת������)
		String name = req.getParameter("name");
		String pass = req.getParameter("psw");
		//3.�������ݿ��ƥ�䣬�߼�����
		user us = new user(name, pass);
		us = userDAO.getUser(us);
		if(us!=null){//˵����½�ɹ������������ݿ��и��û�����Ϣ����
			
			//��session�д洢��ֵ
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("name", us.getName());//���Ǹ��û������ִ���session
			httpSession.setMaxInactiveInterval(10*60);//10����֮��ʧЧ
			//дһЩ������cookie
			Cookie cookie = new Cookie("name",us.getName());
			cookie.setMaxAge(10*60);
			resp.addCookie(cookie);
			Cookie cookie2 = new Cookie("psw", us.getPws());
			cookie2.setMaxAge(10*60);
			resp.addCookie(cookie2);
			//��Щ�洢���֮����ô��������Ӧ������ת
			resp.sendRedirect("indexs.jsp");
			
		}else{
			//˵����ѯ���ݿ�ʧ�ܣ���ô�п���û�и��û�����Ϣ�����ߵ�¼�����������
			req.setAttribute("msg", "�û������������");
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
