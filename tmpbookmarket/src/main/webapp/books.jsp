<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "dto.Book" %>
<%
	ArrayList<Book> listOfBooks = (ArrayList<Book>)request.getAttribute("arry");
%>
<!--  
URL 전달된걸 꺼낼때는 getParameter("");
직접 집어넣고 꺼낼때는 get, setAttribute("");
get만나면 변수에 담음 return이 있기때문에 set은 리턴이 없기때문에 담지않음
setAttribute: request.setAttribute("arry", listOfBooks)와 같이 ArrayList<Book> 타입의 객체를 request에 저장할 때, 내부적으로는 Object 타입으로 저장됩니다.
getAttribute: request.getAttribute("arry")를 호출하면 Object 타입으로 반환되므로, 이를 ArrayList<Book>로 사용하려면 캐스팅이 필요합니다.
-->
<!DOCTYPE html>
<html>
<head>
<link href = "https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel = "stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container py-4">
		<%@ include file="menu.jsp" %>
		
		<div class="p-5 mb-4 bg-body-tertiary rounded-3">
			<div class="container-fluid py-5">
				<h1 class="display-5 fw-bold">도서목록</h1>
				<p class="col-md-8 fs-4">BookList</p>
			</div>
		</div>		
		<div class="row align-items-md-stretch	text-center">
		<!-- HTML을 포함한 for문 중요! -->
			<%
				for(int i=0; i<listOfBooks.size();i++){
					Book book = listOfBooks.get(i);
			%>
			<div class="col-md-4">
				<div class="h-100 p-2">
					<h5><b><%=book.getName() %></b></h5>
					<p> <%=book.getAuthor() %>
					<br><%=book.getPublisher() %> | 35<%=book.getUnitPrice() %>원
					<p> 37<%=book.getDescription().substring(0,60) %>...
					<p> <%=book.getUnitPrice() %>원
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