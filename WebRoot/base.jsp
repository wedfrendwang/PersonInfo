<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<% 
  	if(session.getAttribute("name") == null){//用户没有登陆
  		//跳转至你的用户登陆的界面
  		response.sendRedirect("index.jsp");
  	}
  	%>

