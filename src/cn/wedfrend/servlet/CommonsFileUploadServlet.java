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
 * 使用Apache的类库commons-fileupload
 * @author welive
 */
@WebServlet("/uploads")
public class CommonsFileUploadServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * 创建磁盘目录工厂
		 * 1:org.apache.commons.fileupload.disk.DiskFileItemFactory.class//创建文件磁盘目录
		 */
		DiskFileItemFactory df = new DiskFileItemFactory();
		/**
		 * 做文件上传处理
		 * 2:org.apache.commons.fileupload.servlet.ServletFileUpload.class
		 */
		
		ServletFileUpload su = new ServletFileUpload(df);
		
		try {
			//版本原因
			List<FileItem> listFileItem = su.parseRequest(req);
			
			for (FileItem fitem : listFileItem) {
				if(fitem.isFormField()){//判断是否是表单
				
					//处理数据，必要时可以进行类的封装，然后进行数据库的处理
					System.out.println(fitem.getFieldName()+"--"+fitem.getName()+"---"+fitem.getString());
				
				}else{//获取文件
					System.out.println(fitem.getFieldName()+"--"+fitem.getName()+"---"+fitem.getString());
					String path = req.getServletContext().getRealPath("upload");
//					/**
//					 * 方法1
//					 */
//					InputStream is = fitem.getInputStream();
//					//上传文件写入的目录
//					
//					//文件目录
//					File file = new File(path,fitem.getName());
//					OutputStream os = new FileOutputStream(file);
//					//byte类型
//					byte[] buffer = new byte[1024];
//					
//					int len = 0;
//					
//					while ((len = is.read(buffer))!=-1) {
//						os.write(buffer, 0, len);
//					}
//					//异常外抛
//					os.close();
//					is.close();
					String FileName = UUID.randomUUID()+fitem.getName().substring(fitem.getName().lastIndexOf("."));
					fitem.write(new File(path,FileName));
					/**
					 * 方法2
					 */
					String httpPath = req.getRequestURL().substring(0,req.getRequestURL().lastIndexOf("/")+1);
					//这个 路径是存在后台的服务其中的
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
//		//上传文件写入的目录
////		String path = req.getContextPath()+"/upload";
//		String path = req.getServletContext().getRealPath("upload");
//		System.out.println("path--------------"+path);
//		//文件目录
//		File file = new File(path,"t.txt");
//		OutputStream os = new FileOutputStream(file);
//		//byte类型
//		byte[] buffer = new byte[1024];
//		
//		int len = 0;
//		
//		while ((len = is.read(buffer))!=-1) {
//			os.write(buffer, 0, len);
//		}
//		//异常外抛
//		os.close();
//		is.close();
	}
	
}
