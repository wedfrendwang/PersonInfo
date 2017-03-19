package cn.wedfrend.servlet;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wedfrend.category.Relation;
import cn.wedfrend.dao.RelationDAO;

public class ChangeServlet extends HttpServlet {
	
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
		String name = req.getParameter("name");
		System.out.println(name);
		String hobby = req.getParameter("hobby");
		String level = req.getParameter("level");
		Date date = null;
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("date"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Relation relation = new Relation(id,name, hobby, level, date);
		//添加书籍
		if(relationDAO.update(relation)>0){
//			resp.getWriter().print("success");
			
			//重定向
			resp.sendRedirect("relation");
		}else{
			resp.getWriter().print("修改失败");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
