package com.member.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.action.*;


public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		// �ѱ� ���ڵ� ó��
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// getRequestURI() : "/������Ʈ��/���ϸ�(*.do)" ��� ���ڿ���
		//                   ��ȯ�� �ִ� �޼���.
		String uri = request.getRequestURI();
		System.out.println("uri >>> " + uri);
		
		// getContextPath() : ���� ������Ʈ���� ���ڿ��� ��ȯ�� �ִ� �޼���
		String path = request.getContextPath();
		System.out.println("path >>> " + path);
		
		String command = uri.substring(path.length() + 1);
		System.out.println("command >>> " + command);
		
		
		Action action = null;
		
		
		if(command.equals("select.do")) {
			action = new MemberListAction();
		}else if(command.equals("insert.do")) {
			action = new MemberJoinAction();
		}else if(command.equals("insertOk.do")) {
			action = new MemberJoinOkAction();
		}else if(command.equals("content.do")) {
			action = new MemberContentAction();
		}else if(command.equals("update.do")) {
			action = new MemberUpdateAction();
		}else if(command.equals("updateOk.do")) {
			action = new MemberUpdateOkAction();
		}else if(command.equals("delete.do")) {
			action = new MemberDeleteAction();
		}else if(command.equals("deleteOk.do")) {
			action = new MemberDeleteOkAction();
		}
		
		String path1 = action.execute(request, response);
		
		RequestDispatcher rd =
			request.getRequestDispatcher(path1);
		
		rd.forward(request, response);
		
	}
}
