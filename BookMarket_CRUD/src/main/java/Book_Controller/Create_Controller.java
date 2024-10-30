package Book_Controller;

import java.io.IOException;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BookRepository;
import dto.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/addBook")
public class Create_Controller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("1.Create_Controller의 doGet() 입장");
		//전처리 없음
		//모델이동 없음
		//뷰이동
		RequestDispatcher rd = req.getRequestDispatcher("addBook.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("3.Create_Controller의 doPost() 입장");
		//전처리
		req.setCharacterEncoding("UTF-8"); //한글 깨지지 않게 인코딩
		
		//일반 텍스트와 이미지 데이터가 섞여있으므로 분리가능한 객체가 필요하다.
		String realFolder = req.getServletContext().getRealPath("resources/images");
		System.out.println("3-1.realFolder의 주소를 반환 : " + realFolder);
		String encType="utf-8"; // 인코딩 타입
		int maxSize = 5*1024*1024;
		
		MultipartRequest multi = new MultipartRequest(req, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		if(multi ==null) {
			System.out.println("3-2.multi객체를 전달받지 못함.");
		}
		
		//일반 텍스트 파트 전처
		String bookId = multi.getParameter("bookId");
		String name = multi.getParameter("bookname");
		String author = multi.getParameter("author");
		String publisher = multi.getParameter("publisher");
		String releaseDate = multi.getParameter("releaseDate");
		String description = multi.getParameter("bookdescription");
		String category = multi.getParameter("category");
		String condition = multi.getParameter("bookcondition");
		
		//아래의 두개의 값은 갯수를 뜻하므로 정수로 변경되어야 함.
		String unitPrice = multi.getParameter("unitPrice");
		String unitsInStock = multi.getParameter("unitsInStock");
		
	
		
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
		//일반텍스트 전처리 끝
		
		//이미지 이름을 가져옴 이미지 파트 전처리
		//저장된 이미지의 이름을 변수에 저장
		String fileName = multi.getFilesystemName("bookImage");
		System.out.println("fileName: " + fileName);
		
		
		
		Book bk = new Book();
		bk.setBookId(bookId);
		bk.setBookname(name);
		bk.setAuthor(author);
		bk.setPublisher(publisher);
		bk.setReleaseDate(releaseDate);
		bk.setBookdescription(description);
		bk.setCategory(category);
		bk.setBookcondition(condition);
		
		bk.setUnitPrice(price);
		bk.setUnitsInStock(stock);
		
		bk.setFilename(fileName);
		
		
		//모델이동
		BookRepository br = BookRepository.getInstance();
		br.addBook(bk);
		//뷰이동 : CUD는 보여줄 뷰어가 없음
		resp.sendRedirect("books");
	}

}
