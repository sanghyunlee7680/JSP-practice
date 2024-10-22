package chapter012;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

public class Exam012_2_fil implements Filter{

	private FilterConfig filterConfig = null;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Filter02 초기화...");
		this.filterConfig=filterConfig;
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fc)
			throws IOException, ServletException {
		System.out.println("Filter02 수행...");
		
		String ID = req.getParameter("id");
		String passwd = req.getParameter("pw");
		
		
		System.out.println("ID : " + ID);
		System.out.println("passwd : " +passwd);
		
		String para1 = filterConfig.getInitParameter("param1");
		String para2 = filterConfig.getInitParameter("param2");
		
		System.out.println("para2 : " + para2);
		System.out.println("para1 : " + para1);
		
		String message;
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = resp.getWriter();
		
		if(ID.equals(para1)&& passwd.equals(para2)) {
			message = "로그인 성공했습니다.";		
		} else {
			message = "로그인 실패했습니다.";
			writer.println(message);
			return;
		}
		
		req.setAttribute("message", message);
		req.setAttribute("ID", ID);
		req.setAttribute("passwd", passwd);
		
		
		fc.doFilter(req, resp);
		
	}

	@Override
	public void destroy() {
		System.out.println("Filter02 해제...");
	}

}
