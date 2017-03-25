package cn.wedfrend.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/downloads")
public class DownLoadMoreServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//注意这里在数据库中都需要查询，看看迅雷的种子就知道了   key --------  path
		
		String name = req.getParameter("filename");
		System.out.println(name);
		
		//通过文件流进行下载
		
		//1.设置媒体文件类型
		resp.setContentType("application/octet-stream");
		//2.设置头部信息（弹出保存的提示框）-------------编码的问题
		resp.setHeader("Content-Disposition", "attachment;filename=\""+URLEncoder.encode(name, "utf-8")+"\"");
		//文件地址目录
		String path = req.getServletContext().getRealPath("download");
		File file = new File(path, name);
		//会显示字节数
		resp.setContentLength((int)file.length());
		FileInputStream is = new FileInputStream(file);
		byte[] b = new byte[1024];
		int len = 0;
		while ((len = is.read(b))!=-1) {
			resp.getOutputStream().write(b, 0, len);
		}
		is.close();
		resp.getOutputStream().close();
		
	}
	
}
