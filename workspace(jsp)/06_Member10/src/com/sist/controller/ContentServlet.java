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


@WebServlet("/content.do")
public class ContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ContentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get방식으로 넘어온 번호에 해당하는 회원의 정보를 조회.
		int member_no = 
			Integer.parseInt(request.getParameter("num"));
		
		MemberDAO dao = new MemberDAO();
		
		MemberDTO dto = dao.contentMember(member_no);
		
		request.setAttribute("cont", dto);
		
		RequestDispatcher rd =
			request.getRequestDispatcher("view/member_content.jsp");
		
		rd.forward(request, response);
		
		
	}

}
