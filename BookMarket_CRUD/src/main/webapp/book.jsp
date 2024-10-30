<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="dto.Book" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dao.BookRepository" %>
<%@ page errorPage="exceptionNoBookId.jsp" %>
<%
	System.out.println("4.book.jsp 뷰로 이동");
	Book bk = (Book)request.getAttribute("dto");
%>
<!DOCTYPE html>
<html>
<head>
<link rel ="stylesheet" href ="/BookMarket_CRUD/resources/css/bootstrap.min.css" />
<meta charset="UTF-8">
<title>도서 상세 정보</title>
</head>
<body>
	<div clas="container py-4">
		<%@ include file="menu.jsp" %>
		
		<div class="p-5 mb-4 bg-body-tertiary rounded-3">
			<div class="container-fluid py-5">
				<h1 class="display-5 fw-bold">도서정보</h1>
				<p class="col-md-8 fs-4">BookInfo</p>
			</div>
		</div>
		<div class="row align-items-md-stretch">
			<div class="col-md-5">
				<img src="./resources/images/<%=bk.getFilename() %>" style="width : 50%">
			</div>
			<div class="col-md-6">
				<h3><b><%=bk.getBookname() %></b></h3>
				<p> <%=bk.getBookdescription() %></p>
				<p> <b>도서코드 : </b><span class="badge text-bg-danger"><%=bk.getBookId() %></span>
				<p> <b>저자</b> : <%=bk.getAuthor() %>
				<p> <b>출판사</b> : <%=bk.getPublisher() %>
				<p> <b>출판일</b> : <%=bk.getReleaseDate() %>
				<p> <b>분류</b> : <%=bk.getCategory() %>
				<p> <b>재고수</b> : <%=bk.getUnitsInStock() %>
				<h4><%=bk.getUnitPrice() %>원</h4>
				<form name="addForm" action="#" method="post">
				<a href="addCart?id=<%=bk.getBookId() %>" class="btn btn-info" onclick="AddToCart()"> 도서 주문 &raquo;</a>
				<a href="./cart.jsp" class="btn btn-warning">장바구니 &raquo;</a>
				<a href="books" class="btn btn-secondary"> 도서 목록 &raquo;</a>
				</form>
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
	<script type="text/javascript" src="/BookMarket_CRUD/resources/js/vali.js"></script>
</body>
</html>