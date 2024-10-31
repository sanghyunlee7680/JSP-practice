package Board_Controller;

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
import jakarta.servlet.http.HttpSession;
@WebServlet("/BoardWriteForm")
public class Create_Controller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("1.Board Create_Controller의 doGet() 실행");
		//전처리
		HttpSession session = req.getSession(false);
		if(session == null) {
			System.out.println("세션 생성 실패");
			resp.sendRedirect("member_login");
		}
		//모델이동 없음
		//뷰이동
		RequestDispatcher rd = req.getRequestDispatcher("writeForm.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("3.Create_Controller의 doPost() 입장");
		
	}

}
