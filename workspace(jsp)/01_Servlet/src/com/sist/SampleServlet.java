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

		// 1�ܰ�: Ŭ���̾�Ʈ�κ��� �Ѿ�� �����͸� �޾� ����.
		String userName = request.getParameter("name");
		String userAge = request.getParameter("age");
		
		// 2�ܰ�: ó���� �����͸� ���������� ����غ���.
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("�� �� >>> " + userName +"<br>");
		out.println("�� �� >>> " + userAge +"<br>");
		out.println("</body>");
		out.println("</html>");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
