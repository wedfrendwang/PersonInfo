package cn.wedfrend.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * �����������
 * @author wedfrend
 *
 */
public class ContextFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("ContextFilter init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("ContextFilter doFilter");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		//���POST����
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//���Get,
		
		chain.doFilter(new HttpServletRequestWrapper((HttpServletRequest) request){
			@Override
			public String getParameter(String name) {
				// TODO Auto-generated method stub
				if("get".equals(this.getMethod().toLowerCase())){//ת��ΪСд
					
					String value = super.getParameter(name);
					System.out.println("value------"+value);
					if(value!=null)
					try {
						return new String(value.getBytes("iso-8859-1"), "utf-8");
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return value;
				}
				return super.getParameter(name);
			}
		}, response);
		System.out.println("ContextFilter doFilter");
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("ContextFilter destroy");
		
	}

}
