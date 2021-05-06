package com.sist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.EmpDAO;
import com.sist.model.EmpDTO;


@WebServlet("/select")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SelectServlet() {
        super();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DB에 접속을 해서 EMP 테이블의 전체 리스트를 가져오는 작업(비지니스 로직)
		// 가져온 전체 리스트를 View page로 넘겨주는 작업.
		
		EmpDAO dao = new EmpDAO();
		
		// DB EMP 테이블에서 전체 리스트를 조회하는 작업
		List<EmpDTO> allList = dao.selectList();
		System.out.println("allList >>> " + allList);
		
		// 페이지 이동 시 데이터를 같이 이동시키자.
		request.setAttribute("List", allList);
		
		// 페이지 이동
		RequestDispatcher rd =
				request.getRequestDispatcher("select.jsp");
		rd.forward(request, response);  // 실제적으로 페이지 이동
	}

}
