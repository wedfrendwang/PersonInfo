package cn.wedfrend.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wedfrend.category.Relation;
import cn.wedfrend.dao.RelationDAO;

public class DeleteServlet extends HttpServlet {
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
		if(relationDAO.del(id)>0){
			resp.sendRedirect("relation");
			
		}else{
			resp.getWriter().print("É¾³ýÊ§°Ü");
			
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		this.doGet(req, resp);
		
	};

}
