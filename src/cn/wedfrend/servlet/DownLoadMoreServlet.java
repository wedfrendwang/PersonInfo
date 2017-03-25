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
		
		//ע�����������ݿ��ж���Ҫ��ѯ������Ѹ�׵����Ӿ�֪����   key --------  path
		
		String name = req.getParameter("filename");
		System.out.println(name);
		
		//ͨ���ļ�����������
		
		//1.����ý���ļ�����
		resp.setContentType("application/octet-stream");
		//2.����ͷ����Ϣ�������������ʾ��-------------���������
		resp.setHeader("Content-Disposition", "attachment;filename=\""+URLEncoder.encode(name, "utf-8")+"\"");
		//�ļ���ַĿ¼
		String path = req.getServletContext().getRealPath("download");
		File file = new File(path, name);
		//����ʾ�ֽ���
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
