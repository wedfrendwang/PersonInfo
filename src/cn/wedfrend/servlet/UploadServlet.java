package cn.wedfrend.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/upload")
public class UploadServlet extends HttpServlet{
	
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletInputStream is = req.getInputStream();
		//上传文件写入的目录
//		String path = req.getContextPath()+"/upload";
		String path = req.getServletContext().getRealPath("upload");
		System.out.println("path--------------"+path);
		//文件目录
		File file = new File(path,"t.txt");
		OutputStream os = new FileOutputStream(file);
		//byte类型
		byte[] buffer = new byte[1024];
		
		int len = 0;
		
		while ((len = is.read(buffer))!=-1) {
			os.write(buffer, 0, len);
		}
		//异常外抛
		os.close();
		is.close();
	}
	
}
