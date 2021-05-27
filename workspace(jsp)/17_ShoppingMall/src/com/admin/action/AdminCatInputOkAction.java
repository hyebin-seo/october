package com.admin.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.CategoryDAO;

public class AdminCatInputOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 카테고리 폼 페이지에서 넘어온 데이터들을 DB에 저장하는 컨트롤러 클래스
		
		String cat_code = request.getParameter("cat_code").trim();
		String cat_name = request.getParameter("cat_name").trim();
		
		
		CategoryDAO dao = CategoryDAO.getInstance();
		int check = dao.insertCategory(cat_code, cat_name);
		
		PrintWriter out = response.getWriter();
		ActionForward forward = new ActionForward();
		
		if(check > 0) {
			forward.setRedirect(true);
			forward.setPath("admin_cat_list.do");
		}else {
			out.println("<script>");
			out.println("alert('카테고리 등록 실패~~~')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;
		
	}

}
