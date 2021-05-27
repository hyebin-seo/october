package com.admin.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.CategoryDAO;

public class AdminCatDelAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 카테고리 번호에 해당하는 카테고리를 DB에서 삭제하는 컨트롤러 클래스.
		
		int cat_num = 
			Integer.parseInt(request.getParameter("cnum").trim());
		
		CategoryDAO dao = CategoryDAO.getInstance();
		
		int check = dao.deleteCategory(cat_num);
		
		dao.updateCategoryNo(cat_num);
		
		PrintWriter out = response.getWriter();
		ActionForward forward = new ActionForward();
		
		if(check > 0) {
			forward.setRedirect(true);
			forward.setPath("admin_cat_list.do");
			
		}else {
			out.println("<script>");
			out.println("alert('카테고리 삭제 실패~~~')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		
		return forward;
		
	}

}
