package com.sist.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.MemberDAO;
import com.sist.model.MemberDTO;


@WebServlet("/insert.do")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원등록 폼 페이지에서 넘어온 데이터를 DB에 저장.
		
		// 1단계 : 회원등록 폼 페이지에서 넘어온 데이터들을 받아 주어야 함.
		request.setCharacterEncoding("UTF-8");
		
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
		
		
		MemberDAO dao = new MemberDAO();
		
		int res = dao.insertMember(dto);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(res > 0) {
			// 회원 등록이 성공한 경우
			out.println("<script>");
			out.println("alert('회원 등록 성공!!!')");
			out.println("location.href='select.do'");
			out.println("</script>");
		}else {
			// 회원 등록이 실패한 경우
			out.println("<script>");
			out.println("alert('회원 등록 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		
	}

}
