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
		
		// method="post" ��쿡�� �ѱ� ���� ������ �߻���
		// �ѱ��� ������ �ʰ� ����
		request.setCharacterEncoding("UTF-8");
		
		//1�ܰ�: Ex05.jsp ���������� �Ѿ�� �����͵��� ó��������.
		String hakbun = request.getParameter("hakbun");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String[] major = request.getParameterValues("major");
		
		//2�ܰ�: ���������� ��û�� ����� ȭ�鿡 ��������.
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("�� �� : " + hakbun +"<br>");
		out.println("�� �� : " + name +"<br>");
		
		out.println("�������� : ");
		for(int i=0; i<major.length; i++) {
			out.println(major[i] + "&nbsp;&nbsp;");
		}
		
		out.println("<br>�� �� ó : " + phone +"<br>");
		out.println("</body>");
		out.println("</html>");
	}

}
