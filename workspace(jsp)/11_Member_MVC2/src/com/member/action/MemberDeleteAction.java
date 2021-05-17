package com.member.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberDeleteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 삭제 폼 페이지로 이동하는 클래스
		int member_num =
			Integer.parseInt(request.getParameter("num"));
		
		request.setAttribute("number", member_num);
		
		
		return "view/member_delete.jsp";
		
	}

}
