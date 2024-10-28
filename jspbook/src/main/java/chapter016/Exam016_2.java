package chapter016;

import java.io.IOException;

import ch16_dao.ch16_dao;
import ch16_dto.ch16_dto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/16_2")
public class Exam016_2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("chapter16/Exam16_2_form.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전처리
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		
		ch16_dto dto = new ch16_dto();
		
		dto.setId(id);
		dto.setPw(pw);
		dto.setName(name);
		
		//모델이동
		ch16_dao dao = ch16_dao.getInstance();
		dao.createPlayer(dto);
		
		//뷰이동
		RequestDispatcher rd = req.getRequestDispatcher("chapter16/Exam16_2.jsp");
		rd.forward(req, resp);
	}
	
}
