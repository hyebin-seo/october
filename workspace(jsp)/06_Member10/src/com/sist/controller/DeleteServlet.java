package com.sist.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.MemberDAO;


@WebServlet("/delete.do")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get방식으로 넘겨 받은 회원 번호에 해당하는 회원을
		// DB에서 삭제시키는 작업.
		int member_no = 
			Integer.parseInt(request.getParameter("num"));
		MemberDAO dao = new MemberDAO();
		
		int res = dao.deleteMember(member_no);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(res > 0) {
			out.println("<script>");
			out.println("alert('회원 삭제 성공!!!')");
			out.println("location.href='select.do'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('회원 삭제 실패~~~')");
			out.println("history.back()");
			out.println("</script>");
		}
	}

}
