package com.member.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.action.*;

public class FrontController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		// �ѱ� ���ڵ� ó��
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		// getRequestURI() : "/������Ʈ��/���ϸ�(*.do)"��� ���ڿ��� ��ȯ���ִ� �޼���
		String uri = req.getRequestURI();
		System.out.println("URI >>> " + uri);
		
		// getContextPath() : ������Ʈ ��� ��ȯ
		String path = req.getContextPath();
		System.out.println("PATH >>> " + path);
		
		// ������Ʈ ����� ���ڼ��� ��ȯ �޾�(/�� �����ϱ� ���� +1) uri���� ������Ʈ ��θ� �߶󳻰� ���� �̸��� ��´�.
		String command = uri.substring(path.length()+1);
		System.out.println("command >>> " + command);
		
		Action action = null;
		
		if(command.equals("select.do")) {
			action = new MemberListAction();
		}
		
		//�׼ǿ��� ���� ���� �������� �̵�
		String path1 = action.execute(req, res);
		RequestDispatcher rd = req.getRequestDispatcher(path1);
		rd.forward(req, res);
	}
}
