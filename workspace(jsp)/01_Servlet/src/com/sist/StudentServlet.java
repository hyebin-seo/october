package com.sist;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public StudentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// method="post" 경우에는 한글 깨짐 현상이 발생함
		// 한글이 깨지지 않게 설정
		request.setCharacterEncoding("UTF-8");
		
		//1단계: Ex05.jsp 페이지에서 넘어온 데이터들을 처리해주자.
		String hakbun = request.getParameter("hakbun");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String[] major = request.getParameterValues("major");
		
		//2단계: 웹즈라우저에 요청한 결과를 화면에 보여주자.
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("학 번 : " + hakbun +"<br>");
		out.println("이 름 : " + name +"<br>");
		
		out.println("전공과목 : ");
		for(int i=0; i<major.length; i++) {
			out.println(major[i] + "&nbsp;&nbsp;");
		}
		
		out.println("<br>연 락 처 : " + phone +"<br>");
		out.println("</body>");
		out.println("</html>");
	}

}
