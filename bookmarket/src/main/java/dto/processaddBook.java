package dto;

import java.io.IOException;

import dao.BookRepository;

import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/addBook")
public class processaddBook extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("./addBook.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String filename="";
		String realFolder = request.getServletContext().getRealPath("resource/images");
		int maxSize=5*1024*1024; // 최대 업로드될 파일 크기 5MB
		String encType="utf-8"; // 인코딩 유형
		
		MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		
		//텍스트 파트
		String bookId = multi.getParameter("bookId");
		String name = multi.getParameter("name");
		String unitPrice = multi.getParameter("unitPrice");
		String author = multi.getParameter("author");
		String publisher = multi.getParameter("publisher");
		String releaseDate = multi.getParameter("releaseDate");
		String description = multi.getParameter("description");
		String category = multi.getParameter("category");
		String unitsInStock = multi.getParameter("unitsInStock");
		String condition = multi.getParameter("condition");
		 
		//이미지 이름을 가져옴 이미지 파트
		String fileName = multi.getFilesystemName("BookImage");
		
		//유효성 검사
		Integer price;
		
		if(unitPrice.isEmpty())
		{
			price=0;		
		}
		else
		{
			price=Integer.valueOf(unitPrice);  // 문자-> 숫자		
		}
		
		long stock;
		
		if(unitsInStock.isEmpty())
		{
			stock=0;
		}
		else
		{
			stock=Long.valueOf(unitsInStock); // 문자-> 숫자
		}
		
		BookRepository dao = BookRepository.getInstance();
		
		
		//묶음 처리 Book 객체에 넣음,  전처리 이후에는 묶음이 나옴
		//위의 데이터를 하나의 객체로 묶음처리 , 모델
		Book newBook = new Book();
		newBook.setBookId(bookId);
		newBook.setName(name);
		newBook.setUnitPrice(price);
		newBook.setAuthor(author);
		newBook.setPublisher(publisher);
		newBook.setReleaseDate(releaseDate);
		newBook.setDescription(description);
		newBook.setCategory(category);
		newBook.setUnitsInStock(stock);
		newBook.setCondition(condition);
		newBook.setFilename(fileName);
		
		dao.addBook(newBook);
		
		response.sendRedirect("books.jsp");
	}

}
