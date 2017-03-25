package cn.wedfrend.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/download")
public class DownLoadServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ͨ���ļ�����������
		//1.����ý���ļ�����
		resp.setContentType("application/octet-stream");
		//2.����ͷ����Ϣ�������������ʾ��
		resp.setHeader("Content-Disposition", "attachment;filename=\"commons-fileupload-1.3.2.jar\"");
		//�ļ���ַĿ¼
		String path = req.getServletContext().getRealPath("download");
		File file = new File(path, "commons-fileupload-1.3.2.jar");
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
