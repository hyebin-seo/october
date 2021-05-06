package com.sist.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.EmpDAO;


@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 삭제라는 글자를 클릭 시 사원번호를 가지고  DB에 가서
		// 사원번호에 해당하는 사원정보를 삭제하는 작업.
		
		int empno = 
			Integer.parseInt(request.getParameter("no"));
		
		EmpDAO dao = new EmpDAO();
		int res = dao.deleteEmp(empno);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(res > 0) {  // 사원 삭제가 성공인 경우
			response.sendRedirect("select");
		}else {  // 사원 삭제가 실패한 경우
			out.println("<script>");
			out.println("alert('사원 삭제 실패~~~");
			out.println("history.back()");
			out.println("</script>");
		}
	}

}
