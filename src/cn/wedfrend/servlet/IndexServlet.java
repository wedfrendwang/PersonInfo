package cn.wedfrend.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.wedfrend.dao.UserDAO;

@WebServlet("/index")
public class IndexServlet extends HttpServlet{
	private UserDAO userDAO = new UserDAO();
	//��¼����ʽ
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//�������
		req.setCharacterEncoding("utf-8");
		
		//�ж��û��Ƿ��ǵ�½��״̬
		if(req.getSession().getAttribute("name")==null){
			resp.sendRedirect("index.jsp");
			return;
		}
		
		String name = req.getParameter("name");
		name = new String(name.getBytes("iso-8859-1"), "utf-8");
		String psw = req.getParameter("psw");
		/**
		 * һ��ָ��cookie���������ʱ��������ʱ�������������һ����ֵ����ζ��cookie���ᱻ�洢�����Ϊ�㣬��ɾ����cookie�� 
		 */
		//�������cookie������д��
		if("1".equals(req.getParameter("isRemeber"))){
			//cook�ɿͻ��˹�����ô�洢��λ�ø����������й�
			Cookie cookie = new Cookie("name", name);
			//��δ洢����
			//Cookie cok = new Cookie("name",URLEncoder.encode(name, "utf-8"));
			//����cookie�������ʱ�䣬������㣬��ȱʡ����£�-1��ʾ��cookie��һ�³����������shutdownΪֹ
			cookie.setMaxAge(10*60);
			//ͨ��response��cookieд��ͻ���
			resp.addCookie(cookie);
			Cookie cookies = new Cookie("psw", psw);
			//����cookie�������ʱ�䣬������㣬��ȱʡ����£�-1��ʾ��cookie��һ�³����������shutdownΪֹ
			cookies.setMaxAge(10*60);
			System.out.println("cookies.getMaxAge()------>"+cookies.getMaxAge());//cookies.getMaxAge()------>-1
			//ͨ��response��cookieд��ͻ��ˣ���д���������
			resp.addCookie(cookies);
		}
		//�������ݿⲢ�Ҳ�ѯ��Ӧ������
		int i = userDAO.getUserByName(name, psw);
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		switch (i) {
		case 0:
			//��ȡȫ�����ñ���
			ServletContext sc = this.getServletContext();
			if(sc.getAttribute("count") == null){
				sc.setAttribute("count",1);
			}else{
				int count = (Integer) sc.getAttribute("count");
				sc.setAttribute("count",++count);
			}
			
			//��ȡsession
			HttpSession httpSession = req.getSession();
			//��session�д洢����,�Լ�ֵ�Ե���ʽ����
			System.out.println("httpSession.getId()------>"+httpSession.getId());
			/**
			 * public int getMaxInactiveInterval()
			 * ����servlet�������������ͻ��˷���֮�䱣�ֻỰ���ŵļ�������ʱ�䣬�����ʱ��
			 * һ������ʱ������Ự������û�г�ʱ�� 
			 * ����ֵ:����һ��������ָ��servlet�������������ͻ��˷���֮�䱣�ֻỰ���ŵļ�������ʱ�䣬�����ʱ��
			 */
			//Ĭ��30����
			System.out.println("httpSession.getId()------>"+httpSession.getMaxInactiveInterval());
			httpSession.setAttribute("name", name);
			httpSession.setAttribute("psw", psw);
			//�ض������ҵĽ���
			resp.sendRedirect("load");
			break;
		case 1:
			req.setAttribute("msg", "�������");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
//			resp.getWriter().print("ʧ�ܣ������������������");
			break;
		case 2:
			req.setAttribute("msg", "�û���������");
			//ת����Я������
			req.getRequestDispatcher("index.jsp").forward(req, resp);
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
