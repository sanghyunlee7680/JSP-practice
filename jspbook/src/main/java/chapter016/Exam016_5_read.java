package chapter016;

import java.io.IOException;
import java.util.ArrayList;

import ch16_dao.ch16_dao;
import ch16_dto.ch16_dto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/16_5_read")
public class Exam016_5_read extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ch16_dao dao = ch16_dao.getInstance();
		ArrayList<ch16_dto> arr = dao.getAllplayer();
		
		//뷰이동
		req.setAttribute("player", arr);
		
		RequestDispatcher rd = req.getRequestDispatcher("chapter16/Exam16_5.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
