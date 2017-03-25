package cn.wedfrend.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
/**
 * ʹ��Apache�����commons-fileupload
 * @author welive
 */
@WebServlet("/uploads")
public class CommonsFileUploadServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * ��������Ŀ¼����
		 * 1:org.apache.commons.fileupload.disk.DiskFileItemFactory.class//�����ļ�����Ŀ¼
		 */
		DiskFileItemFactory df = new DiskFileItemFactory();
		/**
		 * ���ļ��ϴ�����
		 * 2:org.apache.commons.fileupload.servlet.ServletFileUpload.class
		 */
		
		ServletFileUpload su = new ServletFileUpload(df);
		
		try {
			//�汾ԭ��
			List<FileItem> listFileItem = su.parseRequest(req);
			
			for (FileItem fitem : listFileItem) {
				if(fitem.isFormField()){//�ж��Ƿ��Ǳ�
				
					//�������ݣ���Ҫʱ���Խ�����ķ�װ��Ȼ��������ݿ�Ĵ���
					System.out.println(fitem.getFieldName()+"--"+fitem.getName()+"---"+fitem.getString());
				
				}else{//��ȡ�ļ�
					System.out.println(fitem.getFieldName()+"--"+fitem.getName()+"---"+fitem.getString());
					String path = req.getServletContext().getRealPath("upload");
//					/**
//					 * ����1
//					 */
//					InputStream is = fitem.getInputStream();
//					//�ϴ��ļ�д���Ŀ¼
//					
//					//�ļ�Ŀ¼
//					File file = new File(path,fitem.getName());
//					OutputStream os = new FileOutputStream(file);
//					//byte����
//					byte[] buffer = new byte[1024];
//					
//					int len = 0;
//					
//					while ((len = is.read(buffer))!=-1) {
//						os.write(buffer, 0, len);
//					}
//					//�쳣����
//					os.close();
//					is.close();
					String FileName = UUID.randomUUID()+fitem.getName().substring(fitem.getName().lastIndexOf("."));
					fitem.write(new File(path,FileName));
					/**
					 * ����2
					 */
					String httpPath = req.getRequestURL().substring(0,req.getRequestURL().lastIndexOf("/")+1);
					//��� ·���Ǵ��ں�̨�ķ������е�
					String realPath = httpPath+"upload/"+FileName;
					
					System.out.println("realPath---"+realPath);
					
					
					
					req.setAttribute("imgpath", realPath);
					
					req.getRequestDispatcher("imag.jsp").forward(req, resp);
				}
			}
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
//		ServletInputStream is = req.getInputStream();
//		//�ϴ��ļ�д���Ŀ¼
////		String path = req.getContextPath()+"/upload";
//		String path = req.getServletContext().getRealPath("upload");
//		System.out.println("path--------------"+path);
//		//�ļ�Ŀ¼
//		File file = new File(path,"t.txt");
//		OutputStream os = new FileOutputStream(file);
//		//byte����
//		byte[] buffer = new byte[1024];
//		
//		int len = 0;
//		
//		while ((len = is.read(buffer))!=-1) {
//			os.write(buffer, 0, len);
//		}
//		//�쳣����
//		os.close();
//		is.close();
	}
	
}
