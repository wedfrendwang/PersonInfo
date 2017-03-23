<%@ page language="java" import="java.util.*,cn.wedfrend.dao.RelationDAO,cn.wedfrend.category.Relation" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
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
  
  <h1>Welcome ${name}</h1>
  
  <table align="center" width="80%">
		<tr>
			<td>编号</td>
			<td>姓名</td>
			<td>爱好</td>
			<td>等级</td>
			<td>登陆日期</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${list }" var="bean">
		<tr>
			<td>${bean.id }</td>
			<td>${bean.name }</td>
			<td>${bean.hobby }</td>
			<td>${bean.level }</td>
			<td><fmt:formatDate value="${bean.date }" pattern="yyyy-MM"/></td>
			<td><a href="update?id=${bean.id }">修改</a>   <a href="del?id=${bean.id }">删除</a></td>
		</tr>
		</c:forEach>
	</table>
	
	<c:if test="${1==1 }">成立</c:if>
	
	<c:choose>
	<c:when test="${1==2 }">1等于2</c:when><c:otherwise>1 不等于2</c:otherwise>
	</c:choose>
	
	<!-- 通用标签  -->
	<c:set scope="session" var="t" value="23" ></c:set>
	<c:out value="${t }"></c:out>
	<hr>
	<c:remove var="t" scope="session"/>
	<c:out value="${t } " default="wag"></c:out>
	
    
  </body>
</html>
