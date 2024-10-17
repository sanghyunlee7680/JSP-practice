package chapter010;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/10_3")
public class Exam010_3 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//전처리 
		String remoteUser = req.getRemoteUser();
		String authType = req.getAuthType();
		boolean userInRole = req.isUserInRole("guest");
		boolean userInRole2 = req.isUserInRole("manager");		
		
		//이동
		req.setAttribute("remoteUser", remoteUser);
		req.setAttribute("authType", authType);
		req.setAttribute("userInRole", userInRole);
		req.setAttribute("userInRole2", userInRole2);
		
		RequestDispatcher rd = req.getRequestDispatcher("chapter10/Exam10_3_success.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
