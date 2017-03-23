<!-- page 指令  指定页面相关属性    导包   jsp有3大指令-->
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>






<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <script type="text/javascript">
    function toVaild(){
    
    var a = document.getElementById("name").value;
    if(a==""){
    alert("请输入姓名");
    return false;
    }
    var pass = document.getElementById("pass").value;
    if(pass==""){
    alert("请输入密码");
    return false;
    }
    return true;
    }
  
  </script>
  
  
  <body>
    This is my JSP page. <br>
    
    <form action="load" method="get" onsubmit="return toVaild()">
    
    用户名:
    <input type="text" name="name" id="name" placeholder="用户名/邮箱/手机号" /><br/>
    密	码:
    <input type="password" name="psw" id="pass" placeholder="密码"/><br/>
    <input type="submit" value="submit" /><br/>
    
    </form>
    
    
  </body>
<%-- </head>

<body>
	用户登录
	<br />
	<%
	String name="";
	String psw="";
	Cookie[] cookies = request.getCookies();
	if(cookies!=null){
  	for(Cookie ck:cookies){
  		if("name".equals(ck.getName())){
  		name = ck.getValue();
  		}
  		if("psw".equals(ck.getName())){
  		psw = ck.getValue();
  		}
  		}
	}
	%>
	<form action="index" method="post">
		用户名: <input type="text" name="name" value="<%=name%> "/><span style="color:red;"><%=request.getAttribute("msg")==null?"":request.getAttribute("msg") %></span><br />
		<br /> 密 码: <input type="password" name="psw" value="<%=psw%>" /><br />
		<br /> <input type="checkbox" name="isRemeber" value="1" />记住密码<br />
		<br /> <input type="submit" value="submit" /><br />
	</form>
	<a href='resign.html'>没有账号！点击注册</a>
</body> --%>
</html>
