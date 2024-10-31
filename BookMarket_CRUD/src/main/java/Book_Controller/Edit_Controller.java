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
@WebServlet("/editBook")
public class Edit_Controller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("1.Edit_Controller의 doGet() 입장");
		//전처리
		String edit = req.getParameter("edit");
		
		//모델이동
		BookRepository br = BookRepository.getInstance();
		ArrayList<Book> arr = br.getAllBooks();		
		if(arr==null ) {
			System.out.println("3.리스트 정보를 받지못함.");
		}
		//뷰이동
		req.setAttribute("list", arr);
		req.setAttribute("edit", edit); // if(edit.equals("update" or "delete")로 사용하기위해 가져감
		RequestDispatcher rd = req.getRequestDispatcher("editBook.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("1.Edit_Controller의 doPost() 입장");
	}

}
