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
		
		// method="post" ��쿡�� �ѱ� ���� ������ �߻���
		// �ѱ��� ������ �ʰ� ����
		request.setCharacterEncoding("UTF-8");
		
		//1�ܰ�: Ex05.jsp ���������� �Ѿ�� �����͵��� ó��������.
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int mat = Integer.parseInt(request.getParameter("mat"));
		int tot = kor+eng+mat;
		int avg = (kor+eng+mat)/3;
		
		//2�ܰ�: ���������� ��û�� ����� ȭ�鿡 ��������.
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("�� �� : " + name +"<br>");
		out.println("�������� : " + kor +"<br>");
		out.println("�������� : " + eng +"<br>");
		out.println("�������� : " + mat +"<br>");
		out.println("���� : " + tot +"<br>");
		out.println("��� : " + String.format("%.2f��", avg) +"<br>");
		out.println("���� : ");
		
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
