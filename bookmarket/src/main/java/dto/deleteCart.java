package dto;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/deleteCart")
public class deleteCart extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전처리
		//변수 유효성 검사
		System.out.println("deleteCart서버 연결");
		
		String id = req.getParameter("cartId");
		System.out.println("cartId:"+id);
		if(id==null||id.trim().equals("")) {
			resp.sendRedirect("cart.jsp");
			return;
		}
		HttpSession session = req.getSession(false);
		session.invalidate();
		resp.sendRedirect("cart.jsp");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
