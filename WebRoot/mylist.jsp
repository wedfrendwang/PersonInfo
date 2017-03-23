<%@ page language="java" import="java.util.*,cn.wedfrend.dao.RelationDAO,cn.wedfrend.category.Relation" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% 
  //java小脚本，那么你应该以分好结尾
  String name = "wedfrend";
  %>
  <%-- 方法声明--%>
  <%! 
  String getName(){
  	return "wangxiaobo";
  } %>
  
<%
//获取数据库中list的值
RelationDAO relationDAO = new RelationDAO();
List<Relation> list = relationDAO.getAllRelation();
 %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>jsp 应用</title>
    
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
  	<!-- 静态导入 -->
  	<%@include file="base.jsp"  %>
  	<%-- <!-- 动态导入 -->
  	<jsp:include file="base.jsp"></jsp:include> --%>
  	<!-- jsp中判断用户是否登陆 -->
  	<%-- <% 
  	if(session.getAttribute("name") == null){//用户没有登陆
  		//跳转至你的用户登陆的界面
  		response.sendRedirect("index.jsp");
  		return;
  	}
  	%> --%>
  	
     <%--  欢迎你<%=session.getAttribute("name") %> --%>
      <h1>welcome ${name}</h1>
  <table align="center" width="80%">

		<tr>
			<td>编号</td>
			<td>姓名</td>
			<td>爱好</td>
			<td>等级</td>
			<td>登陆日期</td>
			<td>操作</td>
		</tr>
		<%for(int i = 0;i<list.size();i++){ %>
		<tr>
			<td><%=list.get(i).getId() %></td>
			<td><%=list.get(i).getName() %></td>
			<td><%=list.get(i).getHobby() %></td>
			<td><%=list.get(i).getLevel() %></td>
			<td><%=list.get(i).getDate() %></td>
			<td><a href="update?id=<%=list.get(i).getId() %>">修改</a>   <a href="del?id=<%=list.get(i).getId() %>">删除</a></td>
		</tr>
		<%} %>
	</table>
  
  
  </body>
</html>
