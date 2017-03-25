<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>booklist</title>
    
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
    <h1>welcome ${name } book list</h1>
    <br/><br/>
    
    <p align="right"><a href='books?op=toadd'><b>添加书籍</b></a></p>
    
    <br/><br/>
    
    <table width="80%" align="center">
    	<tr>
    	<td>编号</td>
    	<td>书名</td>
    	<td>类别</td>
    	<td>作者</td>
    	<td>价格</td>
    	<td>日期</td>
    	<td>操作方式</td>
    	</tr>
    	<c:forEach items="${list }" var="bean" varStatus="status">
    	
    	<tr <c:if test="${status.index%2==0 }">style="background:#0f0;"</c:if>>
    	<td>${bean.id }</td>
    	<td>${bean.name }</td>
    	<%-- <td>${bean.categoryId }</td> --%>
    	
    	<td><c:forEach items="${category }" var="cbean" >
    	<c:if test="${cbean.id eq bean.categoryId }">${cbean.category }</c:if></c:forEach></td>
    	
    	<td>${bean.author }</td>
    	<td>${bean.price }</td>
    	<td>${bean.date }</td>
    	<td><a href="books?op=selectid&id=${bean.id }">修改</a><a href="books?op=del&id=${bean.id }">删除</a></td>
    	</tr>
    	</c:forEach>
    	
    	<tr>
    	<td align="right" colspan="7">
    		<a href="book?op=list&current=${page.currentPage-1 }"
    		<c:if test="${page.currentPage==1 }">style="color:#ccc;" onclick="javascript:return false;"</c:if>
    		>上一页</a>
    		<c:forEach  begin="1" step="1" end="${page.totalPage }" var="itempage">
    		<a href="book?op=list&current=${itempage }">${itempage }</a>
    		</c:forEach>
    		<a href="book?op=list&current=${page.currentPage+1 }" 
    		<c:if test="${page.currentPage==page.totalPage }">style="color:#ccc;" onclick="javascript:return false;"</c:if>
    		>下一页</a>
    		
    		<span>共${page.totalPage }页</span>
    		
    		到第<input type="text" name="cp" id="cp" style="width: 20px" maxlength="4">页<input type="button" value="确定" onclick="search()">
    	</td>
    	</tr>
    </table>
    
    <script type="text/javascript">
    	function search(){
    	var cp = document.getElementById("cp").value;
    	location.href="book?op=list&current="+cp;
    	}
    </script>
    
    
  </body>
</html>
