package chapter05;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/5_1")
public class Exam05_1 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		System.out.println("전달받은 아이디:" + id);
		String passwd = req.getParameter("passwd");
		System.out.println("전달받은 패스워드:"+passwd);
		
		req.setAttribute("id", id);
		req.setAttribute("pw", passwd);
		RequestDispatcher dc = req.getRequestDispatcher("chapter5/Exam5_1.jsp");
		dc.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
