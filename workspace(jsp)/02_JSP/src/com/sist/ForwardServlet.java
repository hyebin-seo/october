package com.sist;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward")
public class ForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ForwardServlet() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String userId = request.getParameter("id").trim();
		String userPwd = request.getParameter("pwd").trim();
		
		//������ DB�� ȸ�� ���� ���̺��� �Է��� id�� pwd�� �´��� Ȯ���Ͽ� ȸ���̸� ���� �������� �̵�
		String dbId = "hong";
		String dbPwd = "1234";
		
		if(userId.equals(dbId)) { // �Է��� ���̵�� DB���̺� ���� ���̵� ���� ���
			if(userPwd.equals(dbPwd)) { // �Է��� ��й�ȣ�� DB���̺� ���� ��й�ȣ�� ���� ���
				// ȸ���� ��쿡�� ���� �������� �̵�
				
				// Ű ����(Ű, ��)
				request.setAttribute("name", "ȫ�浿");
				request.setAttribute("addr", "����� ������");
				
				// ������ ������ �̵�
				RequestDispatcher rd = request.getRequestDispatcher("Ex10.jsp");
				rd.forward(request, response); 
			} else {
				System.out.println("��й�ȣ�� Ʋ���ϴ�.");
			}
		} else {
			System.out.println("���̵� Ȯ�����ּ���.");
		}
	}

}
