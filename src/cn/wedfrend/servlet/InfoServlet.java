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
	 * 返回一个 ServletConfig对象,它包含了servlet的初始化和起始参数。 返回的ServletConfig对象就是传递给
	 * init的那一个。 该接口的实现是为了存储 ServletConfig 对象，以使得该方法能将其返回。
	 */
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * servlet container每次初始化the servlet之后就调用 init方法一次 . init
	 * 方法必须在servlet能够收到任何请求之前就成功完成。
	 */

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * 被servlet container调用以允许servlet响应一个请求。 这个方法只在当servlet的init()方法被成功完成后才被调用。
	 */
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<HobyCategory> list = new ArrayList<HobyCategory>();
		list.add(new HobyCategory("篮球", "高"));
		list.add(new HobyCategory("乒乓球", "高"));
		list.add(new HobyCategory("足球", "低"));
		list.add(new HobyCategory("台球", "高"));
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
		os.print("爱好");
		os.print("</td>");
		os.print("<td align='center'>");
		os.print("热爱程度");
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
	 * 返回有关servlet的信息，例如作者、版本、版权。 该方法返回的字符串应当是纯文本文件而不应该是任何类型的格式符号，如HTML，XML等。
	 */
	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 被 servlet container调用以告知一个servlet它被剔除服务. 该方法只有一旦所有的servlet
	 * 的service方法中的线程已经退出或是已经过了超时时间时才会被调用。在所有的servlet container
	 * 调用了该方法之后，它将不会在调用关于该servlet的service方法。
	 * 该方法给servlet一个机会来清除所有被hold的资源（例如，内存、线程
	 * 、文件句柄等。），并确保所有的固定状态于内存中servlet当前的状态保持同步。
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
