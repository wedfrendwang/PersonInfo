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
	//登录处理方式
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//解决乱码
		req.setCharacterEncoding("utf-8");
		
		//判断用户是否是登陆的状态
		if(req.getSession().getAttribute("name")==null){
			resp.sendRedirect("index.jsp");
			return;
		}
		
		String name = req.getParameter("name");
		name = new String(name.getBytes("iso-8859-1"), "utf-8");
		String psw = req.getParameter("psw");
		/**
		 * 一个指明cookie的最大生存时间的以秒计时的整数。如果是一个负值，意味着cookie不会被存储；如果为零，则删除该cookie。 
		 */
		//这里进行cookie的数据写入
		if("1".equals(req.getParameter("isRemeber"))){
			//cook由客户端管理，那么存储的位置跟你的浏览器有关
			Cookie cookie = new Cookie("name", name);
			//如何存储中文
			//Cookie cok = new Cookie("name",URLEncoder.encode(name, "utf-8"));
			//返回cookie的最大存活时间，以秒计算，在缺省情况下，-1标示该cookie将一致持续到浏览器shutdown为止
			cookie.setMaxAge(10*60);
			//通过response将cookie写入客户端
			resp.addCookie(cookie);
			Cookie cookies = new Cookie("psw", psw);
			//返回cookie的最大存活时间，以秒计算，在缺省情况下，-1标示该cookie将一致持续到浏览器shutdown为止
			cookies.setMaxAge(10*60);
			System.out.println("cookies.getMaxAge()------>"+cookies.getMaxAge());//cookies.getMaxAge()------>-1
			//通过response将cookie写入客户端，回写至浏览器。
			resp.addCookie(cookies);
		}
		//链接数据库并且查询相应的数据
		int i = userDAO.getUserByName(name, psw);
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		switch (i) {
		case 0:
			//获取全局配置变量
			ServletContext sc = this.getServletContext();
			if(sc.getAttribute("count") == null){
				sc.setAttribute("count",1);
			}else{
				int count = (Integer) sc.getAttribute("count");
				sc.setAttribute("count",++count);
			}
			
			//获取session
			HttpSession httpSession = req.getSession();
			//向session中存储数据,以键值对的形式存在
			System.out.println("httpSession.getId()------>"+httpSession.getId());
			/**
			 * public int getMaxInactiveInterval()
			 * 返回servlet容器将在两个客户端访问之间保持会话开放的间隔的最大时间，以秒计时。
			 * 一个负的时间表明会话从来都没有超时。 
			 * 返回值:返回一个整数，指明servlet容器将在两个客户端访问之间保持会话开放的间隔的最大时间，以秒计时。
			 */
			//默认30分钟
			System.out.println("httpSession.getId()------>"+httpSession.getMaxInactiveInterval());
			httpSession.setAttribute("name", name);
			httpSession.setAttribute("psw", psw);
			//重定向至我的界面
			resp.sendRedirect("load");
			break;
		case 1:
			req.setAttribute("msg", "密码错误");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
//			resp.getWriter().print("失败！密码错误，请重新输入");
			break;
		case 2:
			req.setAttribute("msg", "用户名不存在");
			//转发，携带参数
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
