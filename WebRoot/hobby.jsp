<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'hobby.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <script type="text/javascript" src="js/jquery.1.7.2.min.js"></script>
  
  <script type="text/javascript">
  
  
  	$(function(){
  	
  		$('#btn').click(function(){
  		//js可以处理json数据格式,那么在后台的数据传输出来的字符串你就需要将数据转换为json的格式
  			$.post("relation",{op:1},function(data){
				  			
  			//var da = eval("("+data+")");
  			//[{id:'1',name:'王晓波',hobby:'桌球',level:'high',date:'2017-03-17'},{id:'2',name:'wedfrend',hobby:'篮球',level:'high',date:'2017-02-15'},{id:'3',name:'iolo',hobby:'乒乓',level:'middle',date:'2017-03-09'}]
  			eval("var da="+data);
  			var html="<tr><td>id</td><td>name</td><td>hobby</td><td>level</td><td>date</td></tr>";
  			for(i = 0;i<da.length;i++){
  				html+="<tr><td>"+da[i].id+"</td><td>"+
  				da[i].name+"</td><td>"+da[i].hobby+"</td><td>"+
  				da[i].level+"</td><td>"+da[i].date+"</td></tr>";
  			}
  			
  			$('#mytable').html(html);
  			},'json');
  		});
  	
  	});
  
  
  </script>
  
  
  </head>
  
  <body>
  	<!-- EL表达式 -->
    <h1 align="center">${name } 个人爱好列表</h1>
    
    
    <input type="button" id="btn" value="获取${name }爱好数据："/>
    
    <br/><br/>
    
    <table id="mytable"  width="80%" align="right">
    
    </table>    
    
    
  </body>
</html>
