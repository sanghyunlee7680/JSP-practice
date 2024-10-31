package Board_Controller;

import java.io.IOException;
import java.util.ArrayList;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BoardRepository;
import dao.BookRepository;
import dto.Board;
import dto.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/BoardListAction")
public class Read_Controller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//한 페이지에 출력할 게시글의 갯수를 제한
		int Limit = 5;
		
		System.out.println("1.Board Read_Controller의 doGet() 입장");
		//전처리 
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		//모델이동
		BoardRepository br = BoardRepository.getInstance();
		ArrayList<Board> allBoard = br.getAllBoard();
		int total_record = br.getTotalCount();
		int total_page=0;
		if(total_record % Limit == 0) {
			total_page = total_record / Limit;
		}
		else {
			total_page = (total_record / Limit)+1;
		}
		
		//뷰이동
		req.setAttribute("pageNum", pageNum);			//현재 페이지
		req.setAttribute("list", allBoard);				//전체 글의 객체
		req.setAttribute("total_record", total_record);	//전체 글의 갯수 (행,줄)
		req.setAttribute("total_page", total_page); 	//출력할 페이지의 갯수
		
		RequestDispatcher rd = req.getRequestDispatcher("list.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Read_Controller의 doPost() 입장");
		
	}

}
