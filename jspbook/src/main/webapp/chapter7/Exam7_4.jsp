<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="7_4" method="post" enctype="multipart/form-data" name="fileForm">
		<p> 이	름 : <input type="text" name="name">
		<p> 제	목 : <input type="text" name="subject">
		<p> 파	일 : <input type="file" name="filename">
		<p> <input type="submit" value="파일 올리기">
	</form>
</body>
</html>