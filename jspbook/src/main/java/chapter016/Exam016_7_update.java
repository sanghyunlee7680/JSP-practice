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
@WebServlet("/update")
public class Exam016_7_update extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전처리
		String id = req.getParameter("id");
		
		//모델이동
		ch16_dao dao = ch16_dao.getInstance();
		ch16_dto dto = dao.getOneplayer(id);
		
		req.setAttribute("DTO",dto);
		
		RequestDispatcher rd = req.getRequestDispatcher("chapter16/Exam16_7_update.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Exam16_7_update doPost연결완료");
		//전처리
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		
		System.out.println("id:"+id);
		System.out.println("pw:"+pw);
		System.out.println("name:"+name);
		ch16_dto dto = new ch16_dto();
		
		dto.setId(id);
		dto.setPw(pw);
		dto.setName(name);
		
		//모델 이동
		ch16_dao dao = ch16_dao.getInstance();
		dao.updatePlayer(dto);
		
		//뷰 이동
		resp.sendRedirect("16_5_read");
		
		
	}
	
}
