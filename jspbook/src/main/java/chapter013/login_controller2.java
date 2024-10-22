package chapter013;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/13_1")
public class login_controller2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		String id = (String) session.getAttribute("id");
		String pw = (String) session.getAttribute("pw");
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
	
		
		RequestDispatcher rd = req.getRequestDispatcher("chapter13/printer2.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전처리
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		if(id.equals("admin")&&pw.equals("1234"))
		{	// getSession(true) 혹은 getSession()은 현재 세션 객체가 없으면 새로 생성한다.
			// getSession(false)는 현재 세션 객체가 있으면 그냥쓰고 없으면 null 반납한다.
			HttpSession session = req.getSession(true); //세션 생성
			session.setAttribute("id", id);
			session.setAttribute("pw", pw);
			
			RequestDispatcher rd = req.getRequestDispatcher("chapter13/printer.jsp");
			rd.forward(req, resp);
		}
		else
		{
			
		}
		//모델
		
		
		//이동
	}

}
