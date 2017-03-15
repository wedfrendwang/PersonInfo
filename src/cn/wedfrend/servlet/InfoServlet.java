package cn.wedfrend.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import cn.wedfrend.category.HobyCategory;

@WebServlet("/info")
public class InfoServlet implements Servlet{

	//����servlet������һ��ʱ�䲻��ʹ�õ�ʱ��
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	//��ʼ��Servlet
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	//�������ķ���
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<HobyCategory> list = new ArrayList<HobyCategory>();
		list.add(new HobyCategory("����", "��"));
		list.add(new HobyCategory("ƹ����", "��"));
		list.add(new HobyCategory("����", "��"));
		list.add(new HobyCategory("̨��", "��"));
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html");
		res.setCharacterEncoding("utf-8");
		PrintWriter os = res.getWriter();
		os.print("<meta charset='utf-8'/>");
		os.print("<html>");
		os.print("<head>");
		os.print("<title>");
		os.print("wedfrend Hoby List");
		os.print("</title>");
		os.print("</head>");
		os.print("<body>");
		os.print("<table align='center' width='80%'>");
		os.print("<tr>");
		os.print("<td>");
		os.print("����");
		os.print("</td>");
		os.print("<td>");
		os.print("�Ȱ��̶�");
		os.print("</td>");
		os.print("</tr>");
		for (HobyCategory hobyCategory : list) {
			os.print("<tr>");
			os.print("<td>");
			os.print(hobyCategory.getHoby());
			os.print("</td>");
			os.print("<td>");
			os.print(hobyCategory.getLevel());
			os.print("</td>");
			os.print("</tr>");
		}
		os.print("</table>");
		os.print("</body>");
		os.print("</html>");
	}

}
