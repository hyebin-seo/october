package com.admin.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.AdminDAO;
import com.shop.model.AdminDTO;

public class AdminLoginOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 관리자 로그인 페이지에서 넘어온 아이디와 비밀번호를 가지고
		// 관리자인지 확인하는 컨틀롤러 클래스.
		
		String admin_id = request.getParameter("admin_id").trim();
		String admin_pwd = request.getParameter("admin_pwd").trim();
		
		AdminDAO dao = AdminDAO.getInstance();
		int res = dao.adminCheck(admin_id, admin_pwd);
		
		PrintWriter out = response.getWriter();
		ActionForward forward = new ActionForward();
		// 세션을 생성하는 방법
		HttpSession session = request.getSession();
		
		if(res > 0) {
			// 관리자인 경우 관리자의 정보를 받아 오자.
			AdminDTO dto = dao.getAdmin(admin_id);
			
			session.setAttribute("adminId", dto.getAdmin_id());
			session.setAttribute("adminName", dto.getAdmin_name());
			
			//  세션에 저장된 정보를 가지고 View Page로 이동하자.
			forward.setRedirect(false);
			forward.setPath("admin/admin_main.jsp");
			
		}else if(res == -1) {
			// 관리자 비밀번호가 틀린 경우
			out.println("<script>");
			out.println("alert('관리자 비밀번호가 틀립니다. 확인 요망~~~')");
			out.println("history.back()");
			out.println("</script>");
		}else if(res == -2) {
			// 관리자가 아닌 경우
			out.println("<script>");
			out.println("alert('관리자가 아닙니다.~~~')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;
	}

}
