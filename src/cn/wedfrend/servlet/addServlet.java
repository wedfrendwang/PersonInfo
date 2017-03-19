package cn.wedfrend.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wedfrend.category.Relation;
import cn.wedfrend.dao.RelationDAO;
@WebServlet("/add")
public class addServlet extends HttpServlet{
	RelationDAO relationDAO = new RelationDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/**
		 * 生成Request对象由服务器生成
		 * 
		 * 1.url
		 * 2.<a href="">
		 * 3.JS中的location.href=""
		 * 4.form表单的提交
		 * 
		 */
		req.setCharacterEncoding("utf-8");
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
		Relation relation = new Relation(name, hobby, level, date);
		//添加书籍
		if(relationDAO.add(relation)>0){
//			resp.getWriter().print("success");
			
			//重定向
			resp.sendRedirect("relation");
		}else{
			resp.getWriter().print("添加失败");
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
