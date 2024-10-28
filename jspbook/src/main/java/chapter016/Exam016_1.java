package chapter016;

import java.io.IOException;

import ch16_dao.ch16_dao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/16_1")
public class Exam016_1 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전처리 없음
		//모델이동 
		
		// DB연결
		ch16_dao dao = ch16_dao.getInstance();
		dao.DBconn();
		
		if(dao.DBconn()!=null) {
			RequestDispatcher rd = req.getRequestDispatcher("chapter16/Exam16_1.jsp");
			rd.forward(req, resp);			
		}
		else {
			RequestDispatcher rd = req.getRequestDispatcher("chapter16/Exam16_1_fail.jsp");
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
