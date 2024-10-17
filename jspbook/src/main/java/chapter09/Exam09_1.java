package chapter09;

import java.io.IOException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/9_1")
public class Exam09_1 extends HttpServlet 
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Locale locale = req.getLocale();
		Date currentDate = new Date();
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
		NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
		
		req.setAttribute("locale", locale);
		req.setAttribute("currentDate", currentDate);
		req.setAttribute("dateFormat", dateFormat);
		req.setAttribute("numberFormat", numberFormat);
		
		System.out.println(locale);
		System.out.println(currentDate);
		System.out.println(dateFormat);
		System.out.println(numberFormat);
		
		RequestDispatcher rd = req.getRequestDispatcher("chapter9/Exam9_1.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
