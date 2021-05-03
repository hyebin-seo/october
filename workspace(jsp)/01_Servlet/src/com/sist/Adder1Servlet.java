package com.sist;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Adder1Servlet")
public class Adder1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Adder1Servlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//method="post"�� ��� ������ ó���ϴ� �޼���
		int su1 = Integer.parseInt(request.getParameter("num1"));
		int su2 = Integer.parseInt(request.getParameter("num2"));
		
		// ���� �� �ѱ� ó��
		response.setContentType("text/html; charset=UTF-8");
		// 2�ܰ�: ó���� ����� Ŭ���̾�Ʈ �� �������� ����ϴ� �۾�.
		PrintWriter out = response.getWriter(); 
		
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");
		out.println("<h1>�� ���� �� >>> " + (su1+su2)+"</h1>");
		out.println("</body>");
		out.println("</html>");
	}

}
