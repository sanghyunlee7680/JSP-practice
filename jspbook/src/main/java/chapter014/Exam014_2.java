package chapter014;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/14_2")
public class Exam014_2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet 연결");
		RequestDispatcher rd = req.getRequestDispatcher("chapter14/Exam14_2_form.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		if(id.equals("admin") && pw.equals("1234")) {
			Cookie ck_id = new Cookie("userid", id);
			Cookie ck_pw = new Cookie("userpw",pw);
			resp.addCookie(ck_id);
			resp.addCookie(ck_pw);
			
			req.setAttribute("id", id);
			req.setAttribute("pw", pw);
			
			System.out.println("id:"+id);
			System.out.println("pw:"+pw);
			
			req.setAttribute("ck_id", ck_id);
			req.setAttribute("ck_pw", ck_pw);
			
			System.out.println("ck_id"+ck_id);
			System.out.println("ck_pw"+ck_pw);
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("chapter14/Exam14_2.jsp");
		rd.forward(req, resp);
	}

}
