package Book_Controller;

import java.io.IOException;

import dao.BookRepository;
import dto.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/book")
public class Read_one_Controller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("1.Read_one_Controller의 doGet()입장");
		//전처리
		String bookId = req.getParameter("id");
		//모델이동
		BookRepository br = BookRepository.getInstance();
		Book bk = br.getOneBook(bookId);
		if(bk==null) {
			System.out.println("3.oneBook의 정보를 받지못함.");
		}
		//뷰이동
		req.setAttribute("dto", bk);
		
		RequestDispatcher rd = req.getRequestDispatcher("book.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
