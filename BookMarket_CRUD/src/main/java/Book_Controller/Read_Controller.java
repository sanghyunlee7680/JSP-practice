package Book_Controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.BookRepository;
import dto.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/books")
public class Read_Controller extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("1.Read_Controll의 doget실행");
		// 전처리 없음
	
		// 모델 이동
		BookRepository br = BookRepository.getInstance();
		if(br==null) {
			System.out.println("2-1:BookRepositor객체를 리턴받지 못함");
		}
		//객체 묶음
		ArrayList<Book> arr = br.getAllBooks();
		if(arr==null) {
			System.out.println("3-1:리스트 정보를 전달받지 못함");
		}
	
		// 뷰 이동
		req.setAttribute("list", arr);
		
		RequestDispatcher rd = req.getRequestDispatcher("books.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}	

}
