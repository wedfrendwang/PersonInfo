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
	<script type="text/javascript">
		if("${msg}"!=""){
		alert("${msg}");
		}
	
	</script>
	
  </head>
  
  <body>
    <form action="loads" method="post">		用户名: <input type="text" name="name"/><br />
		<br /> 密 码: <input type="password" name="psw"/><br />
		<br /> <input type="checkbox" name="isRemeber" value="1" />记住密码<br />
		<br /> <input type="submit" value="submit" /><br />
	</form>
	<a href='resign.html'>没有账号！点击注册</a>
  </body>
</html>
