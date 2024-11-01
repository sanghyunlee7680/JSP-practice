<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="dao.BookRepository" %>
<%@ page import="dto.Book" %>
<%@ page session="false" %>
<%
	System.out.println("3.updateBook.jsp로 이동함");
	Book bk = (Book)request.getAttribute("dto");
%>
<!DOCTYPE html>
<html>
<head>
<link href = "./resources/css/bootstrap.min.css" rel = "stylesheet"/>
<meta charset="UTF-8">
<title>도서 수정</title>
</head>
<body>
	<div class="container py-4">
		<%@ include file="menu.jsp" %>
		
		<div class="p-5 mb-4 bg-body-tertiary rounded-3">
			<div class="container-fluid py-5">
				<h1 class="display-5 fw-bold">도서 수정</h1>
				<p class="col-md-8 fs-4">Book Updating</p>
			</div>
		</div>

		<div class="row align-items-md-stretch">
			<div class="col-md-5">
				<img src="./resources/images/<%=bk.getFilename()%>" alt="image" style="width:100%"/>
			</div>
			<div class="col-md-7">
				<form name="newBook" action="updateBook" method="post" enctype="multipart/form-data">
					<div class="mb-3 row">
						<label class="col-sm-2">도서코드</label>
						<div class="col-sm-5">
							<input type="text" name="bookId" id="bookId" class="form-control" value='<%=bk.getBookId()%>' readonly>
						</div>
					</div>
					<div class="mb-3 row">
						<label class="col-sm-2">도서명</label>
						<div class="col-sm-5">
							<input type="text" name="bookname" id="ㅠname" class="form-control" value='<%=bk.getBookname()%>'>
						</div>
					</div>
					<div class="mb-3 row">
						<label class="col-sm-2">가격</label>
						<div class="col-sm-5">
							<input type="text" name="unitPrice" id="unitPrice" class="form-control" value='<%=bk.getUnitPrice()%>'>
						</div>
					</div>
					<div class="mb-3 row">
						<label class="col-sm-2">저자</label>
						<div class="col-sm-5">
							<input type="text" name="author" id="author" class="form-control" value='<%=bk.getAuthor()%>'>
						</div>
					</div>
					<div class="mb-3 row">
						<label class="col-sm-2">출판사</label>
						<div class="col-sm-5">
							<input type="text" name="publisher" id="publisher" class="form-control" value='<%=bk.getPublisher()%>'>
						</div>
					</div>
					<div class="mb-3 row">
						<label class="col-sm-2">출판일</label>
						<div class="col-sm-5">
							<input type="text" name="releaseDate" id="releaseDate" class="form-control" value='<%=bk.getReleaseDate()%>'>
						</div>
					</div>
					<div class="mb-3 row">
						<label class="col-sm-2">상세정보</label>
						<div class="col-sm-8">
							<textarea name="bookdescription" id="description" cols="50" rows="2" class="form-control" placeholder="100자 이상 적어주세요">
								<%=bk.getBookdescription() %>
							</textarea>
						</div>
					</div>
					<div class="mb-3 row">
						<label class="col-sm-2">분류</label>
						<div class="col-sm-5">
							<input type="text" name="category" id="category" class="form-control" value='<%=bk.getCategory()%>'>
						</div>
					</div>
					<div class="mb-3 row">
						<label class="col-sm-2">재고수</label>
						<div class="col-sm-5">
							<input type="text" name="unitsInStock" id="unitsInStock" class="form-control" value='<%=bk.getUnitsInStock()%>'>
						</div>
					</div>
					<div class="mb-3 row">
						<label class="col-sm-2">상태</label>
						<div class="col-sm-8">
							<%
								String status = bk.getBookcondition();
								System.out.println("status : "+ status);
							%>
							<input type="radio" name="bookcondition" value="new" <%if(status.equals("new")){out.println("checked");} %>>신규도서
							<input type="radio" name="bookcondition" value="old" <%if(status.equals("old")){out.println("checked");} %>>중고도서
							<input type="radio" name="bookcondition" value="ebook" <%if(status.equals("ebook")){out.println("checked");} %>>E-Book
						</div>
					</div>
					<div class="mb-3 row">
						<label class="col-sm-2">이미지</label>
						<div class="col-sm-8">
							<input type="file" name="bookImage" class="form-control" >
						</div>
					</div>
					<div class="mb-3 row">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" class="btn btn-primary" value="수정">
						</div>
					</div>
				</form>
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>