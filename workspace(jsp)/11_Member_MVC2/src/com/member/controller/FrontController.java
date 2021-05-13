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
		
		// 한글 인코딩 처리
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		// getRequestURI() : "/프로젝트명/파일명(*.do)"라는 문자열을 반환해주는 메서드
		String uri = req.getRequestURI();
		System.out.println("URI >>> " + uri);
		
		// getContextPath() : 프로젝트 경로 반환
		String path = req.getContextPath();
		System.out.println("PATH >>> " + path);
		
		// 프로젝트 경로의 글자수를 반환 받아(/를 포함하기 위해 +1) uri에서 프로젝트 경로를 잘라내고 서블릿 이름을 얻는다.
		String command = uri.substring(path.length()+1);
		System.out.println("command >>> " + command);
		
		Action action = null;
		
		if(command.equals("select.do")) {
			action = new MemberListAction();
		}
		
		//액션에서 리턴 받은 페이지로 이동
		String path1 = action.execute(req, res);
		RequestDispatcher rd = req.getRequestDispatcher(path1);
		rd.forward(req, res);
	}
}
