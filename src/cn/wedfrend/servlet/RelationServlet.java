package cn.wedfrend.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wedfrend.category.Relation;
import cn.wedfrend.dao.RelationDAO;
@WebServlet("/relation")
public class RelationServlet extends HttpServlet{
	private RelationDAO relationDAO = new RelationDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��ȡ������java������ ��ʽ
		List<Relation> listRelation = relationDAO.getAllRelation();
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>��ϵ����</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<table width='80%' align='center'>");
		out.print("<tr>");
		
		out.print("<td>");
		out.print("���");
		out.print("</td>");
		
		out.print("<td>");
		out.print("����");
		out.print("</td>");
		
		out.print("<td>");
		out.print("����");
		out.print("</td>");
		
		out.print("<td>");
		out.print("�ȼ�");
		out.print("</td>");
		
		out.print("<td>");
		out.print("¼������");
		out.print("</td>");
		
		out.print("<td>");
		out.print("����");
		out.print("</td>");
		out.print("</tr>");
		if(listRelation!=null)
		for (int i = 0; i < listRelation.size(); i++) {
			out.print("<tr>");
			
			out.print("<td>");
			out.print(listRelation.get(i).getId());
			out.print("</td>");
			
			out.print("<td>");
			out.print(listRelation.get(i).getName());
			out.print("</td>");
			
			out.print("<td>");
			out.print(listRelation.get(i).getHobby());
			out.print("</td>");
			
			out.print("<td>");
			out.print(listRelation.get(i).getLevel());
			out.print("</td>");
			
			out.print("<td>");
			//listRelation.get(i).getDate().toLocaleString()����
			out.print(new SimpleDateFormat("yyyy-MM-dd").format(listRelation.get(i).getDate()));
			out.print("</td>");
			
			out.print("<td>");
			out.print("<a href='update?id="+listRelation.get(i).getId()+"'>�޸�</a>   <a href='del?id="+listRelation.get(i).getId()+"'>ɾ��</a>");
			out.print("</td>");
			
			out.print("</tr>");
		}
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
		out.flush();
		out.close();
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
