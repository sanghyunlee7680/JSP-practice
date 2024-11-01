package Board_Controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BoardRepository;
import dao.BookRepository;
import dto.Board;
import dto.Book;
import dto.Member;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/BoardWriteForm")
public class Create_Controller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("1.Board Create_Controller의 doGet() 실행");
		//전처리
		HttpSession session = req.getSession(false);
		if(session == null) {
			System.out.println("세션 생성 실패");
			resp.sendRedirect("member_login");
		}
		else if(session != null)
		{
			Member mb = (Member)session.getAttribute("user");
			if(session.getAttribute("user") == null ) {
				System.out.println("세션존재 멤버 없음 이동한다.");
				resp.sendRedirect("member_login");
			}
			else {
				RequestDispatcher rd = req.getRequestDispatcher("writeForm.jsp");
				rd.forward(req, resp);				
			}
		}
		//모델이동 없음
		//뷰이동
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("3.Board Create_Controller의 doPost() 실행");
		
		//전처리
		HttpSession session = req.getSession(false);
		Member mb = (Member)session.getAttribute("user");
		
		String id = mb.getId();
		String name = req.getParameter("name");
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		
		Date currentDatetime = new Date(System.currentTimeMillis());
		java.sql.Date sqlDate = new java.sql.Date(currentDatetime.getTime());
		java.sql.Timestamp regist_day= new java.sql.Timestamp(currentDatetime.getTime());
		
		int hit = 0;
		String ip = req.getRemoteAddr();
		
		Board bd = new Board();
		
		bd.setId(id);
		bd.setName(name);
		bd.setSubject(subject);
		bd.setContent(content);
		bd.setRegist_day(regist_day);
		bd.setHit(hit);
		bd.setIp(ip);
		
		//모델 이동
		BoardRepository bdr = BoardRepository.getInstance();
		bdr.create(bd);
		
		
		resp.sendRedirect("BoardListAction");
	}

}
