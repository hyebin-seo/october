package com.reply.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reply.action.Action;
import com.reply.action.ActionForward;


public class FrontController extends HttpServlet{

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String uri = request.getRequestURI();
		System.out.println("uri >>> " + uri);
		
		String path = request.getContextPath();
		System.out.println("path >>> " + path);
		
		String command = uri.substring(path.length() + 1);
		System.out.println("command >>> " + command);
		
		Action action = null;
		ActionForward forward = null;
		
		Properties prop = new Properties(); // 환경 변수 및 속성 값을 저장하여 접근(키-값)
		FileInputStream fis = new FileInputStream("D:\\sist\\workspace(jsp)\\14_Board_Reply\\src\\com\\reply\\controller\\mapping.properties");
		
		prop.load(fis);
		String value = prop.getProperty(command);
		System.out.println("value >>> " + value);
		
		if(value.substring(0, 7).equals("execute")) {
			StringTokenizer st = new StringTokenizer(value, "|");
			String url_1 = st.nextToken(); // "execute"
			String url_2 = st.nextToken(); // "패키지명.클래스명"
			
			try {
				Class url = Class.forName(url_2);
				// 동적으로 객체 생성
				// action = new BbsListAction();
				action = (Action) url.newInstance();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath(value);
		}
		
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
				rd.forward(request, response);
			}
		}
	}
}
