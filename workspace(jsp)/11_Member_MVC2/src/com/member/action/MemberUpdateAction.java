package com.member.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.model.MemberDAO;
import com.member.model.MemberDTO;

public class MemberUpdateAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// get방식으로 넘어온 회원번호에 해당하는 회원의 정보를 조회하여
		// 수정 폼 페이지로 이동시키는 클래스
		
		int member_num = 
			Integer.parseInt(request.getParameter("num"));
		
		MemberDAO dao = MemberDAO.getInstance();
		MemberDTO dto = dao.contentMember(member_num);
		
		request.setAttribute("edit", dto);
		
		return "view/member_update.jsp";
	}

}
