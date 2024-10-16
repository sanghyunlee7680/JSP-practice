package chapter07;

import java.io.*;
import java.io.IOException;
import java.util.*;

import org.apache.commons.fileupload.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/7_4")
public class Exam07_4 extends HttpServlet 
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		RequestDispatcher rd = req.getRequestDispatcher("chapter7/Exam7_4.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{	
			String path = req.getServletContext().getRealPath("img");
			System.out.print(path);	
		
			DiskFileUpload upload = new DiskFileUpload();
			
			upload.setSizeMax(1000000);
			upload.setSizeThreshold(4096);
			upload.setRepositoryPath(path);
			
			List items;
			String name = new String();
			String subject = new String();
			String fileFieldName = new String();
			String fileName = new String();
			String contentType = new String();
			long fileSize = 0 ;
			Iterator params = null;
			File file;
			
			
			try 
			{
				items = upload.parseRequest(req);
				System.out.println("아이템"+items);
				params = items.iterator();
				System.out.println("파람"+params);
				
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while(params.hasNext())
			{
				FileItem item = (FileItem) params.next();
				
				if(item.isFormField())
				{
					name = item.getFieldName();
					subject = item.getString("utf-8");
					System.out.println(name + " = " + subject + "<br>");
				}
				else
				{
					fileFieldName 	= item.getFieldName();
					fileName = item.getName();
					contentType = item.getContentType();
					
					fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
					fileSize = item.getSize();
					
					file = new File(path + "/" + fileName);
					try {
						item.write(file);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
			req.setAttribute("name", name);
			req.setAttribute("subject", subject );
			req.setAttribute("fileFieldName", fileFieldName );
			req.setAttribute("fileName",fileName );
			req.setAttribute("fileSize", fileSize );
			req.setAttribute("contentType", contentType);
			System.out.println(name);
			System.out.println(subject);
			System.out.println(fileFieldName);
			System.out.println(fileName);
			System.out.println(fileSize);
			System.out.println(contentType);
	
	
	
			RequestDispatcher rd = req.getRequestDispatcher("chapter7/Exam7_4_sub.jsp");
			rd.forward(req, resp);
		}
}
