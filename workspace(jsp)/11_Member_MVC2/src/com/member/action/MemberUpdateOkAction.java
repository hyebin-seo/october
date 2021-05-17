package com.member.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.model.MemberDAO;
import com.member.model.MemberDTO;

public class MemberUpdateOkAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 수정폼 페이지에서 넘어온 데이터들을 DB에 반영하는 클래스
		
		String member_id = request.getParameter("mem_id").trim();
		String member_name = request.getParameter("mem_name").trim();
		String member_pwd = request.getParameter("mem_pwd").trim();
		int member_age = 
			Integer.parseInt(request.getParameter("mem_age").trim());
		int member_mileage = 
			Integer.parseInt(request.getParameter("mem_mileage").trim());
		String member_job = request.getParameter("mem_job").trim();
		String member_addr = request.getParameter("mem_addr").trim();
		
		// 히든으로 넘어온 데이터도 받아주어야 한다.
		int member_num = 
			Integer.parseInt(request.getParameter("mem_num").trim());
		
		MemberDTO dto = new MemberDTO();
		dto.setNum(member_num);
		dto.setMemid(member_id);
		dto.setMemname(member_name);
		dto.setPwd(member_pwd);
		dto.setAge(member_age);
		dto.setMileage(member_mileage);
		dto.setJob(member_job);
		dto.setAddr(member_addr);
		
		MemberDAO dao = MemberDAO.getInstance();
		int res = dao.updateMember(dto);
		
		PrintWriter out = response.getWriter();
		
		if(res > 0) {
			out.println("<script>");
			out.println("alert('회원 정보 수정 성공!!!')");
			out.println("location.href='content.do?num="+dto.getNum()+"'");
			out.println("</script>");
		}else if(res == -1) {
			out.println("<script>");
			out.println("alert('비밀번호가 틀립니다. 확인해 주세요~~~')");
			out.println("history.back()");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('회원 정보 수정 실패~~~')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return null;
	}

}
