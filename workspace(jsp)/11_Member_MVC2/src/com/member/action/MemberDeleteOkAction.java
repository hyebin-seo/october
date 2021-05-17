package com.member.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.model.MemberDAO;

public class MemberDeleteOkAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 삭제 폼 창에서 넘어온 회원번호와 회원 비밀번호를 가지고
		// DB 에서 회원번호에 해당하는 회원을 삭제하는 클래스
		
		String member_pwd = request.getParameter("mem_pwd").trim();
		int member_num = 
			Integer.parseInt(request.getParameter("mem_num").trim());
		
		MemberDAO dao =MemberDAO.getInstance();
		int res = dao.deleteMember(member_num, member_pwd);
		
		PrintWriter out = response.getWriter();
		
		if(res > 0) {
			out.println("<script>");
			out.println("alert('회원 삭제 성공!!!')");
			out.println("location.href='select.do'");
			out.println("</script>");
		}else if(res == -1) {
			out.println("<script>");
			out.println("alert('비밀번호가 틀립니다. 확인 요망')");
			out.println("history.back()");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('회원 삭제 실패~~~')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return null;
	}

}
