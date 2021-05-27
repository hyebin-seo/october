package com.admin.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.CategoryDAO;
import com.shop.model.CategoryDTO;

public class AdminCatListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 카테고리 테이블의 전체 레코드를 조회하는 컨트롤러 클래스.
		
		CategoryDAO dao = CategoryDAO.getInstance();
		
		List<CategoryDTO> list = dao.getCategoryList();
		
		// 카테고리 리스트를 키에 저장하여 view page로 이동시켜야 함.
		request.setAttribute("categoryList", list);
		
		ActionForward forward = new ActionForward();

		forward.setRedirect(false);
		
		forward.setPath("admin/admin_cat_list.jsp");
		
		return forward;
		
	}

}
