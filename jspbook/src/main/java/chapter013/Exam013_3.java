package chapter013;

import java.io.IOException;
import java.util.Enumeration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/13_3")
public class Exam013_3 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("chapter13/Exam13_3_form.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		String name = new String();
//		String value = new String();
		HttpSession session = req.getSession(true);
//		
//		Enumeration en = req.getParameterNames();
//		int i=0;
//		
//		while(en.hasMoreElements())
//		{	
//			i++;
//			name = en.nextElement().toString();
//			System.out.println("name"+ name);
//			value = req.getParameter(name).toString();
//			System.out.println("value " + value);	
//		}
//		
//		session.setAttribute("name", name);
//		session.setAttribute("value", value);
//		
//		session.removeAttribute("name");
//		
//		en = req.getParameterNames();
//		
//		while(en.hasMoreElements())
//		{	
//			name = en.nextElement().toString();
//			System.out.println("name"+ name);
//			value = req.getParameter(name).toString();
//			System.out.println("value " + value);	
//		}
		
		
		RequestDispatcher rd = req.getRequestDispatcher("chapter13/Exam13_3_pro.jsp");
		rd.forward(req, resp);
		
		
		
		
	}
	
}
