<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.apache.commons.fileupload.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<%
		String name = (String) request.getAttribute("name");
		String subject = (String) request.getAttribute("subject");
		String fileFieldName = (String) request.getAttribute("fileFieldName");
		String fileName = (String) request.getAttribute("fileName");
		String contentType = (String) request.getAttribute("contentType");
		long fileSize = (long) request.getAttribute("fileSize");
	%>
</head>
<body>
	<%
		out.println("name="+name);
		out.println("subject="+subject);
		out.println("----------------------------------<br>");
		out.println("요청 파라미터 이름 : " + fileFieldName + "<br>");
		out.println("저장 파일 이름 : " + fileName + "<br>");
		out.println("파일 콘텐츠 유형 : " + contentType + "<br>");
		out.println("파일 크기 : " + fileSize);
	%>
</body>
</html>