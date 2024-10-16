<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %> %>
<%@ page import="org.apache.commons.fileupload.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String fileUploadPath = request.getServletContext().getRealPath("img");
		System.out.println(fileUploadPath);
		// 1. 객체 생성
		DiskFileUpload upload = new DiskFileUpload();
		
	
		
		try 
		{
			
			//2. get
			List items = upload.parseRequest(request);
			Iterator params = items.iterator();
			System.out.println(items);
			System.out.println(params);
			//3.구분?
			while(params.hasNext())
			{
				FileItem fileItem=(FileItem) params.next();
				if(!fileItem.isFormField())
				{
					String fileName = fileItem.getName();
					System.out.println(fileName);
					fileName=fileName.substring(fileName.lastIndexOf("\\")+1);
					File file = new File(fileUploadPath + "/" + fileName);
					fileItem.write(file);					
				}
			}
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	%>
</body>
</html>