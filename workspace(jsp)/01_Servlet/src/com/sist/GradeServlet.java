package com.sist;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/grade")
public class GradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GradeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// method="post" 경우에는 한글 깨짐 현상이 발생함
		// 한글이 깨지지 않게 설정
		request.setCharacterEncoding("UTF-8");
		
		//1단계: Ex05.jsp 페이지에서 넘어온 데이터들을 처리해주자.
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int mat = Integer.parseInt(request.getParameter("mat"));
		int tot = kor+eng+mat;
		int avg = (kor+eng+mat)/3;
		
		//2단계: 웹즈라우저에 요청한 결과를 화면에 보여주자.
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("이 름 : " + name +"<br>");
		out.println("국어점수 : " + kor +"<br>");
		out.println("영어점수 : " + eng +"<br>");
		out.println("수학점수 : " + mat +"<br>");
		out.println("총점 : " + tot +"<br>");
		out.println("평균 : " + String.format("%.2f점", avg) +"<br>");
		out.println("학점 : ");
		
		if(avg > 90) {
			out.println("A<br>");
		} else if (avg > 80){
			out.println("B<br>");
		} else if (avg > 80){
			out.println("C<br>");
		} else if (avg > 80){
			out.println("D<br>");
		} else{
			out.println("F<br>");
		}
		
		out.println("</body>");
		out.println("</html>");
	}

}
