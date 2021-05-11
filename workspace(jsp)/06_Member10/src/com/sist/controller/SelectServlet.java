package com.sist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.MemberDAO;
import com.sist.model.MemberDTO;


@WebServlet("/select.do")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DB에서 member10 테이블의 전체 리스트를 조회하여
		// 해당 전체 리스트를 View Page로 넘겨주는 작업
		MemberDAO dao = new MemberDAO();
		
		// member10 테이블의 전체 리스트를 조회하는 메서드.
		List<MemberDTO> memberList = dao.getMemberList();
		
		// View Page로 해당 데이터를 이동시켜야 함.
		// 이동을 위한 작업
		// 1단계 : setAttribute() 를 이용하여 데이터를 저장.
		request.setAttribute("List", memberList);
		
		// 2단계 : forward() 이동방법을 이용하여 View Page로 이동을 하자.
		//        이 때 데이터도 같이 넘어간다.
		RequestDispatcher rd =
				request.getRequestDispatcher("view/member_list.jsp");
		rd.forward(request, response);
		
	}

}






