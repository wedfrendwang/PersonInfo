<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="wed" uri="DiceFunctions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'example.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
  <%-- <jsp:useBean id="person" class="cn.wedfrend.category.Person" scope="request">
  <jsp:setProperty name="person" property="name" value="wedfrend"></jsp:setProperty>
  </jsp:useBean>
    This is <b><jsp:getProperty name="person" property="name"></jsp:getProperty></b> JSP page. <br>
   --%>
   
   ${wed:getName()}扔的数目是${wed:rollIt()}
   
   </body>
</html>
