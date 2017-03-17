package cn.wedfrend.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import cn.wedfrend.category.HobyCategory;

@WebServlet("/info")
public class InfoServlet implements Servlet {
	
	public InfoServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * ����һ�� ServletConfig����,��������servlet�ĳ�ʼ������ʼ������ ���ص�ServletConfig������Ǵ��ݸ�
	 * init����һ���� �ýӿڵ�ʵ����Ϊ�˴洢 ServletConfig ������ʹ�ø÷����ܽ��䷵�ء�
	 */
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * servlet containerÿ�γ�ʼ��the servlet֮��͵��� init����һ�� . init
	 * ����������servlet�ܹ��յ��κ�����֮ǰ�ͳɹ���ɡ�
	 */

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * ��servlet container����������servlet��Ӧһ������ �������ֻ�ڵ�servlet��init()�������ɹ���ɺ�ű����á�
	 */
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
		os.print("<h1 align='center' width='80%'>");
		os.print("wedfrend hobby");
		os.print("</h1><br/>");
		os.print("<hr/>");
		os.print("<table border='1' align='center' width='80%'>");
		os.print("<tr>");
		os.print("<td title='wedfrend hobby' align='center'>");
		os.print("����");
		os.print("</td>");
		os.print("<td align='center'>");
		os.print("�Ȱ��̶�");
		os.print("</td>");
		os.print("</tr>");
		for (HobyCategory hobyCategory : list) {
			os.print("<tr>");
			os.print("<td align='center'>");
			os.print(hobyCategory.getHoby());
			os.print("</td>");
			os.print("<td align='center'>");
			os.print(hobyCategory.getLevel());
			os.print("</td>");
			os.print("</tr>");
		}
		os.print("</table>");
		os.print("</body>");
		os.print("</html>");
		os.flush();
		os.close();
	}
	
	
	/**
	 * �����й�servlet����Ϣ���������ߡ��汾����Ȩ�� �÷������ص��ַ���Ӧ���Ǵ��ı��ļ�����Ӧ�����κ����͵ĸ�ʽ���ţ���HTML��XML�ȡ�
	 */
	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * �� servlet container�����Ը�֪һ��servlet�����޳�����. �÷���ֻ��һ�����е�servlet
	 * ��service�����е��߳��Ѿ��˳������Ѿ����˳�ʱʱ��ʱ�Żᱻ���á������е�servlet container
	 * �����˸÷���֮�����������ڵ��ù��ڸ�servlet��service������
	 * �÷�����servletһ��������������б�hold����Դ�����磬�ڴ桢�߳�
	 * ���ļ�����ȡ�������ȷ�����еĹ̶�״̬���ڴ���servlet��ǰ��״̬����ͬ����
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
