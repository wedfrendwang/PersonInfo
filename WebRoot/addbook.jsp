<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addbook.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	function judge(){
    if(""==document.getElementById("name").value||
    ""==document.getElementById("categoryId").value||
    ""==document.getElementById("author").value||
    ""==document.getElementById("price").value||
    ""==document.getElementById("date").value
    ){
    alert("请正确填写");
    return false;
    }
    return true;
	}
	
	</script>
  </head>
  
  <body>
    <h1>添加书籍界面</h1>
    <form action="book" method="post" onsubmit="return judge()">
    
    <input type="hidden" name="op" value="add" />
    <table width="80%" align="center">
   	<tr>
   	<td>书名：</td>
   	<td><input type="text" name="name" id="name" value="" placeholder="请输入书名"/></td>
   	</tr>
   	<tr>
   	<td>分类：</td>
   	<td>
	   	<select id="categoryId" name="categoryId">
	   	
	   		<c:forEach items="${category }" var="cbean">
	   			<option value="${cbean.id }">${cbean.category }</option>
	   		</c:forEach>
	   		
	   	</select>
   	</td>
   	</tr>
   	<tr>
   	<td>作者：</td>
   	<td><input type="text" name="author" id="author" value="" placeholder="请输入作者"/></td>
   	</tr>
   	<tr>
   	<td>价格：</td>
   	<td><input type="text" name="price" id="price" value="" placeholder="请输入价格"/></td>
   	</tr>
   	<tr>
   	<td>日期：</td>
   	<td><input type="text" name="date" id="date" value="" placeholder="请输入日期"/></td>
   	</tr>
   	
   	<tr>
   	<td colspan="2" align="center"><input type="submit" value="提交"/></td>
   	</tr>
    </table>
    </form>
  </body>
</html>
