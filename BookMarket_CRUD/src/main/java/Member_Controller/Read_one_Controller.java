package Member_Controller;

import java.io.IOException;

import dao.BookRepository;
import dao.MemberRepository;
import dto.Book;
import dto.Member;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/member_login")
public class Read_one_Controller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("1.Member Read_one_Controller의 doGet() 실행");
		//전처리
		//모델이동
		//뷰이동
		RequestDispatcher rd = req.getRequestDispatcher("loginMember.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("3.Member Read_one_Controller의 doPost() 실행");
		//전처리
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		
		
		//모델이동
		MemberRepository mr = MemberRepository.getInstance();
		Member mb = mr.getUser(id, password);
		if(mb!=null) //DTO가 존재하므로 회원이 맞음
		{	
			//세션 생성
			System.out.println("DTO가 존재한다.");
			HttpSession session = req.getSession(true);
			session.setAttribute("user", mb);
			System.out.println("네임:" + mb.getName());
			RequestDispatcher rd = req.getRequestDispatcher("resultMember.jsp?msg=2");
			rd.forward(req, resp);
		}
		else
		{
			resp.sendRedirect("member_login?error=1");
		}
		//뷰이동
	}

}
