<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ch16_dto.ch16_dto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList<ch16_dto> arr = (ArrayList<ch16_dto>) request.getAttribute("player");
	%>
	<h1>회원 명단</h1>
	<table>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
		</tr>
		<%
			for(int i=0; i<arr.size(); i++){
				ch16_dto dto = arr.get(i);
				String id = dto.getId();
				String pw = dto.getPw();
				String name = dto.getName();
		%>
		<tr>
			<th><%=id %></th>
			<th><%=pw %></th>
			<th><%=name %></th>
			<th><a href="update?id=<%=id%>">수정</a></th>
			<th><a href="delete?id=<%=id%>">삭제</a></th>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>