package chapter013;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/13_1f")
public class Exam013_1 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("chapter13/Exam13_1_form.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(true);
		String id= req.getParameter("id");
		String pw = req.getParameter("pw");
		
		if(id.equals("admin")&&pw.equals("1234")) {
			session.setAttribute("id", id);
			session.setAttribute("pw", pw);		
			System.out.println("세션 설정이 성공했습니다.<br>");
			System.out.println(id+"님 환영합니다.");
			RequestDispatcher rd = req.getRequestDispatcher("chapter13/Exam13_1_pro.jsp");
			rd.forward(req, resp);
		}
		else {
			System.out.println("세션 설정이 실패했습니다.");
			RequestDispatcher rd = req.getRequestDispatcher("chapter13/Exam13_1_fail.jsp");
			rd.forward(req, resp);
		}
		
		
	}
	
}
