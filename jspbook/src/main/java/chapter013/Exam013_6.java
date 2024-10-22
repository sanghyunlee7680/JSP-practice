package chapter013;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/13_6")
public class Exam013_6 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("chapter13/Exam13_6_form.jsp");
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
			int time = session.getMaxInactiveInterval()/60;
			session.setAttribute("time", time);
			
			session.setMaxInactiveInterval(60*60);
			int time2 = session.getMaxInactiveInterval()/60;
			session.setAttribute("time2", time2);
			
			String session_id=session.getId();
			long last_time=session.getLastAccessedTime();
			long start_time=session.getCreationTime();
			long used_time = (last_time - start_time)/60000;
			
			session.setAttribute("session_id", session_id);
			session.setAttribute("last", last_time);
			session.setAttribute("start", start_time);
			session.setAttribute("used", used_time);
			RequestDispatcher rd = req.getRequestDispatcher("chapter13/Exam13_6_pro.jsp");
			rd.forward(req, resp);
		}
		else {
			System.out.println("세션 설정이 실패했습니다.");
			RequestDispatcher rd = req.getRequestDispatcher("chapter13/Exam13_6_fail.jsp");
			rd.forward(req, resp);
		}
	}
	
}
