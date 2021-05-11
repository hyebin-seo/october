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


@WebServlet("/updateOk.do")
public class UpdateOkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateOkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원 수정폼 페이지에서 넘어온 데이터들을
		// DB에 반영하는 작업.
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
		
		// type="hidden"으로 넘어온 데이터도 받아주어야 한다.
		int member_num = 
			Integer.parseInt(request.getParameter("num").trim());
		
		MemberDTO dto = new MemberDTO();
		dto.setNum(member_num);
		dto.setMemid(member_id);
		dto.setMemname(member_name);
		dto.setPwd(member_pwd);
		dto.setAge(member_age);
		dto.setMileage(member_mileage);
		dto.setJob(member_job);
		dto.setAddr(member_addr);
		
		MemberDAO dao = new MemberDAO();
		int res = dao.updateMember(dto);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(res > 0) {
			out.println("<script>");
			out.println("alert('회원 정보 수정 성공')");
			out.println("location.href='content.do?num="+dto.getNum()+"'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('회원 정보 수정 실패!!!!')");
			out.println("history.go(-1)");   // 이전 페이지로 이동
			out.println("</script>");
		}
		
	}

}
