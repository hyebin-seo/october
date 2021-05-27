package com.shop.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.UserDAO;
import com.shop.model.UserDTO;

public class UserLoginOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 사용자 로그인 폼에서 넘어온 아이디와 비밀번호를 가지고
		// DB에서 확인하여 회원이 맞는지 여부를 확인하는 컨트롤러 클래스.
		
		String user_id = request.getParameter("user_id").trim();
		String user_pwd = request.getParameter("user_pwd").trim();
		
		UserDAO dao = UserDAO.getInstance();
		
		int check = dao.userCheck(user_id, user_pwd);
		
		PrintWriter out = response.getWriter();
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		
		if(check > 0) {
			UserDTO dto = dao.getMember(user_id);
			
			session.setAttribute("userId", dto.getMemid());
			session.setAttribute("userName", dto.getMemname());
			
			forward.setRedirect(true);
			forward.setPath("user_main.do");
		}else if(check == -1) {
			out.println("<script>");
			out.println("alert('비밀번호가 틀립니다. 확인해 주세요~~~')");
			out.println("history.back()");
			out.println("</script>");
		}else if(check == -2) {
			out.println("<script>");
			out.println("alert('회원이 아닙니다. 아이디 다시 화인하세요!!!')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;
	}

}
