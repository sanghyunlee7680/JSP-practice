package Controller;

import java.io.IOException;

import dao.Repository;
import dto.member;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/join")
public class Create_Controller extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("1.join요청 Create_Controller의 doGet() 실행");
		//전처리 없음
		//모델이동 없음
		//뷰이동
		RequestDispatcher rd = req.getRequestDispatcher("join.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("3.join요청 Create_Controller의 doPost() 실행");
		//전처리
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		int age = Integer.parseInt(req.getParameter("age"));
		member dto = new member();
		dto.setId(id);
		dto.setPw(pw);
		dto.setAge(age);
		//모델 이동
		Repository dao = Repository.getInstance();
		dao.createId(dto);
		
		resp.sendRedirect("home.jsp");
		
	}

}
