package com.sist.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.MemberDAO;
import com.sist.model.MemberDTO;


@WebServlet("/update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원번호에 해당하는 회원의 정보를 조회해서
		// 수정 폼 페이지로 이동시키는 작업.
		
		int member_no = 
			Integer.parseInt(request.getParameter("num"));
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.contentMember(member_no);
		
		request.setAttribute("edit", dto);
		
		RequestDispatcher rd =
			request.getRequestDispatcher("view/member_edit.jsp");
		
		rd.forward(request, response);
		
	}

}
