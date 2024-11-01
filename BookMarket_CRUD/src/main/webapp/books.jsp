<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "dto.Book" %>
<%@ page import = "dao.BookRepository" %>
<%@ page import = "java.sql.*" %>
<%@ page session="false" %>
<%
	System.out.println("4:Books.jsp 뷰로 이동함");
%>
<!DOCTYPE html>
<html>
<head>
<link href = "./resources/css/bootstrap.min.css" rel = "stylesheet"/>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container py-4">
		<%@ include file="menu.jsp" %>
		<%
			ArrayList<Book> arr = (ArrayList<Book>)request.getAttribute("list");
			if(arr==null){
				System.out.println("5:리스트 값을 전달받지 못함.");
			}
		%>
		<div class="p-5 mb-4 bg-body-tertiary rounded-3">
			<div class="container-fluid py-5">
				<h1 class="display-5 fw-bold">도서목록</h1>
				<p class="col-md-8 fs-4">BookList</p>
			</div>
		</div>
		
		<div class="row align-items-md-stretch	text-center">
			<%  
				for(int i=0; i<arr.size(); i++){
					Book bk = arr.get(i);	
			%>
			<div class="col-md-4">
				<div class="h-100 p-2">
					<img src="./resources/images/<%=bk.getFilename() %>" width="250"; height="350";/>
					<h5><b><%=bk.getBookname() %></b></h5>
					<p> <%=bk.getAuthor() %>
					<br><%=bk.getPublisher() %> | <%=bk.getReleaseDate()%>
					<p> <%=bk.getBookdescription() %>...
					<p> <%=bk.getUnitPrice() %>원
					<p> <a href="book?id=<%=bk.getBookId()%>" 
						class="btn btn-secondary" role="botton">상세 정보 &raquo;</a>
				</div>
			</div>
			<%
				}
			%>
		</div>
		<%@ include file = "footer.jsp" %>
	</div>
</body>
</html>