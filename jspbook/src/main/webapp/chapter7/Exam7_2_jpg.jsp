<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<%
		String name1 = (String)request.getAttribute("name1");
		String subject1 = (String)request.getAttribute("subject1");
		String file1 = (String)request.getAttribute("file1");
		String name2 = (String)request.getAttribute("name2");
		String subject2 = (String)request.getAttribute("subject2");
		String file2 = (String)request.getAttribute("file2");
		String name3 = (String)request.getAttribute("name3");
		String subject3 = (String)request.getAttribute("subject3");
		String file3 = (String)request.getAttribute("file3");
	%>
</head>
<body>
	<table border="1">
		<tr>
			<th width="100">이름</th>
			<th width="100">제목</th>
			<th width="100">파일</th>
		</tr>
		<%
			out.print("<tr><td>" + name1 + " </td>");
			out.print("<td>" + subject1 + " </td>");
			out.println("<td>" + file1 + " </td></tr>\n");
			
			out.print("<tr><td>" + name2 + " </td>");
			out.print("<td>" + subject2 + " </td>");
			out.println("<td>" + file2 + " </td></tr>\n");
			
			out.print("<tr><td>" + name3 + " </td>");
			out.print("<td>" + subject3 + " </td>");
			out.println("<td>" + file3 + " </td></tr>\n");
		%>
	</table>
</body>
</html>