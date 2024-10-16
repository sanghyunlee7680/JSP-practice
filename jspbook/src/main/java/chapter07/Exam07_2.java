package chapter07;

import java.io.IOException;

import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/7_2")
public class Exam07_2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("chapter7/Exam7_2.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전처리
		String save = req.getServletContext().getRealPath("img");
		MultipartRequest multi = new MultipartRequest(req, save, 5*1024*1024, "utf-8", new DefaultFileRenamePolicy());
		
		//하나씩 처리
		String name1 = multi.getParameter("name1");
		String subject1 = multi.getParameter("subject1");
		String file1 = multi.getFilesystemName("filename1");
		
		String name2 = multi.getParameter("name2");
		String subject2 = multi.getParameter("subject2");
		String file2 = multi.getFilesystemName("filename2");
		
		String name3 = multi.getParameter("name3");
		String subject3 = multi.getParameter("subject3");
		String file3 = multi.getFilesystemName("filename3");
		
		System.out.println(save);
		
		//이동
		req.setAttribute("name1", name1);
		req.setAttribute("subject1", subject1);
		req.setAttribute("file1", file1);
		
		req.setAttribute("name2", name2);
		req.setAttribute("subject2", subject2);
		req.setAttribute("file2", file2);
		
		req.setAttribute("name3", name3);
		req.setAttribute("subject3", subject3);
		req.setAttribute("file3", file3);
		
		RequestDispatcher rd = req.getRequestDispatcher("chapter7/Exam7_2_jpg.jsp");
		rd.forward(req, resp);
	}
	

}
