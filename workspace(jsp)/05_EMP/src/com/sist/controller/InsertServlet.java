package com.sist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.DeptDTO;
import com.sist.model.EmpDAO;
import com.sist.model.EmpDTO;


@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사원 추가폼으로 넘어가기 전에 관리자 리스트와
		// 부서번호 리스트를 DB 에서 조회하여 사원추가폼으로 넘겨주면 됨.
		EmpDAO dao = new EmpDAO();
		
		// EMP 테이블에서 담당업무 리스트 조회
		List<String> jobList = dao.jobList();
		
		// EMP 테이블에서 담당업무가 "MANAGER"인 사원 리스트 조회
		List<EmpDTO> mgrList = dao.mgrList();
		
		// 부서 테이블 전체 리스트 메서드 호출
		List<DeptDTO> deptList = dao.deptList();
		
		request.setAttribute("job", jobList);
		request.setAttribute("mgr", mgrList);
		request.setAttribute("dept", deptList);
		
		// 페이지 이동
		RequestDispatcher rd =
				request.getRequestDispatcher("insertForm.jsp");
		rd.forward(request, response);
	}

}
