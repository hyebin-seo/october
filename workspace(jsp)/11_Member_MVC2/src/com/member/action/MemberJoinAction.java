package com.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberJoinAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		// ��� ��� �� �������� �̵�
		
		return "view/member_join.jsp";
	}

}
