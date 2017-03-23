package cn.wedfrend.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;

public class FirstFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("FirstFilter init");
	}

	
	//ʵ�ֹ��˲���
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("doFilter ǰ");
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		System.out.println("getContextPath"+req.getContextPath());
		System.out.println("getRequestURI"+req.getRequestURI());
		System.out.println("getRequestURL"+req.getRequestURL());
		
		
		
		if(req.getSession().getAttribute("name") == null){
			//��ȡ
			String path = req.getRequestURL().substring(req.getRequestURL().lastIndexOf("/")+1);
			//�Ź�˭
			if(!("load.jsp".equals(path)||"loads".equals(path)||"resign.html".equals(path)||"resign".equals(path))){
				resp.sendRedirect("load.jsp");
				return;
			}
		}
		chain.doFilter(request, response);
		
		//ִ����һ��Filter��û�о�����
		System.out.println("doFilter ��");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("doFilter destroy");
	}

	

}
