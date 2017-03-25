<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Loading...</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- 提示数据错误 -->
	<script type="text/javascript">
		if("${msg}"!=""){
		alert("${msg}");
		}
	
	</script>
	
	
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
	
  </head>
  
  <body bgcolor="#ccc">
  
  
  <%-- java脚本
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
	%> --%>
    <img src="http://localhost:8080/PersonInfo/upload/8943adfb-8d0a-4ab6-bc3e-02bc8b01f052.jpg" width="100%" height="150px"/>
  <center>
    <form action="loads" method="post" onsubmit="return toVaild()">		
    用户名: <input type="text" name="name" id="name" placeholder="用户名/邮箱/手机号" value="${ empty cookie.name.value?'':cookie.name.value }"/><br /><br /> 
    密    码: <input type="password" name="psw" id="pass" placeholder="密码" value="${ empty cookie.psw.value?'':cookie.psw.value }"/><br /><br /> 
    <input type="checkbox" name="isRemeber" value="1" />记住密码<br /><br /> 
    <input type="submit" value="submit" /><br />
	</form>
	<br/>
	<a href='resign.html'>没有账号！点击注册</a>
	</center>
  </body>
</html>
