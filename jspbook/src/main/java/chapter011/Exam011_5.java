package chapter011;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/11_5")
public class Exam011_5 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("chapter11/Exam11_5.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String num1 = req.getParameter("num1");
		String num2 = req.getParameter("num2");
		int a = Integer.parseInt(num1);	
		int b = Integer.parseInt(num2);
		int c = a/b;
		
		req.setAttribute("c", c);
		
		RequestDispatcher rd = req.getRequestDispatcher("chapter11/Exam11_5_process.jsp");
		rd.forward(req, resp);
	}
	
}
