package cn.wedfrend.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondFilter implements Filter{
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("SecondFilter destroy ");
		
	}@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("SecondFilter doFilter Ç°");
		
		chain.doFilter(request, response);
		
		System.out.println("SecondFilter doFilter ºó");
		
		
		
	}public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {
		System.out.println("SecondFilter init");
	};

}
