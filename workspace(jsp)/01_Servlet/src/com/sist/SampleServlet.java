package com.sist;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/profile")
public class SampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public SampleServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1단계: 클라이언트로부터 넘어온 데이터를 받아 주자.
		String userName = request.getParameter("name");
		String userAge = request.getParameter("age");
		
		// 2단계: 처리한 데이터를 웹브라우저에 출력해보자.
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("이 름 >>> " + userName +"<br>");
		out.println("나 이 >>> " + userAge +"<br>");
		out.println("</body>");
		out.println("</html>");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
