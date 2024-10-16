package chapter08;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/8_5")
public class Exam08_5 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("chapter8/Exam8_5.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String phone1 = req.getParameter("phone1");
		String phone2 = req.getParameter("phone2");
		String phone3 = req.getParameter("phone3");
		String email = req.getParameter("email");
		
		req.setAttribute("id", id);
		req.setAttribute("pw", pw);
		req.setAttribute("name", name);
		req.setAttribute("phone1", phone1);
		req.setAttribute("phone2", phone2);
		req.setAttribute("phone3", phone3);
		req.setAttribute("email", email);
		
		System.out.println(id);
		System.out.println(pw);
		System.out.println(name);
		System.out.println(phone1);
		System.out.println(phone2);
		System.out.println(phone3);
		System.out.println(name);
		
		RequestDispatcher rd = req.getRequestDispatcher("chapter8/Exam8_5_sub.jsp");
		rd.forward(req, resp);
		
		
	}

}
