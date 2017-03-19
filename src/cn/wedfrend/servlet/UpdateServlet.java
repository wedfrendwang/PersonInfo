package cn.wedfrend.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wedfrend.category.Relation;
import cn.wedfrend.dao.RelationDAO;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

	RelationDAO relationDAO = new RelationDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		int id=0;
		if(req.getParameter("id")!=null){
			id = Integer.parseInt(req.getParameter("id"));
		}
		Relation relation = relationDAO.getRelationById(id);
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();

		pw.print("<html>");
		pw.print("<head>");
		pw.print("<title>修改数据</title>");
		pw.print("</head>");
		pw.print("<body>");
		pw.print("<form align='center' width='80%' action='change' method='post'>");
		
		pw.print("姓名：<input typer='text' name='name' value='"+relation.getName()+"'/>");
		pw.print("爱好：<input typer='text' name='hobby' value='"+relation.getHobby()+"'/>");
		pw.print("等级：<input typer='text' name='level' value='"+relation.getLevel()+"'/>");
		pw.print("日期：<input typer='text' name='date' value='"+ new SimpleDateFormat("yyyy-MM-dd").format(relation.getDate())+"'/>");
//	    很重要，必须用ID来进行使用
		pw.print("<input type='hidden' name='id' value='"+relation.getId()+"'/>");
		
		pw.print("<input type='submit' value='submit'/>");
		pw.print("</form>");
		pw.print("</body>");
		
		
		
		pw.print("</html>");
		
	
		
	
	
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		this.doGet(req, resp);
		
	};
	
}
