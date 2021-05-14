package com.member.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.model.MemberDAO;
import com.member.model.MemberDTO;


public class MemberJoinOkAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//회원등록 홈페이지에서 넘어온 데이터들을 DB에 저장하는 클래스
		String member_id = request.getParameter("mem_id").trim();
		
		String member_name = request.getParameter("mem_name").trim();
		
		String member_pwd = request.getParameter("mem_pwd").trim();
		
		int member_age = 
			Integer.parseInt(request.getParameter("mem_age").trim());
		
		int member_mileage = 
			Integer.parseInt(request.getParameter("mem_mileage").trim());
		
		String member_job = request.getParameter("mem_job").trim();
		
		String member_addr = request.getParameter("mem_addr").trim();
		
		
		MemberDTO dto = new MemberDTO();
		
		dto.setMemid(member_id);
		
		dto.setMemname(member_name);
		
		dto.setPwd(member_pwd);
		
		dto.setAge(member_age);
		
		dto.setMileage(member_mileage);
		
		dto.setJob(member_job);
		
		dto.setAddr(member_addr);
		
		
		MemberDAO dao = MemberDAO.getInstance();
		
		int res = dao.insertMember(dto);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(res > 0) {
			out.println("<script>");
			out.println("alert('회원가입 완료')");
			out.println("location.href='select.do'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('회원가입 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		return null;
	}

}
