package chapter05;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/5_8")
public class Exam05_8 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("chapter5/Exam5_8.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String userid = req.getParameter("id");
		String userpw = req.getParameter("passwd");
		
		req.setAttribute("userid", userid);
		req.setAttribute("userpw", userpw);
		
		RequestDispatcher rd = req.getRequestDispatcher("chapter5/Exam5_8_user.jsp");
		rd.forward(req, resp);
	}

}
