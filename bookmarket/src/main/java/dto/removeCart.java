package dto;

import java.io.IOException;
import java.util.ArrayList;

import dao.BookRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/removeCart")
public class removeCart extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("removeCart연결");
		//전처리
		String id = req.getParameter("id");
		//변수의 유효성 검사
		System.out.println("1.id:"+id);
		if(id==null || id.trim().equals("")) {
			resp.sendRedirect("books.jsp");
			return;
		}
		
		BookRepository dao = BookRepository.getInstance();
		
		Book book = dao.getBookById(id);
		if(book==null) {
			resp.sendRedirect("exceptionNoBookId.jsp");			
		}
		HttpSession session = req.getSession(false);
		ArrayList<Book> cartList = (ArrayList<Book>)session.getAttribute("cartlist");
		Book goodsQnt = new Book();
		for(int i=0; i<cartList.size();i++) {
			goodsQnt=cartList.get(i);
			if(goodsQnt.getBookId().equals(id)) {
				cartList.remove(goodsQnt);
			}
		}
		
		resp.sendRedirect("cart.jsp");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
