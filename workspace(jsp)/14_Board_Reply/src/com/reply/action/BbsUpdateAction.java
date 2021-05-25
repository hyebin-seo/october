package com.reply.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reply.model.BbsDAO;
import com.reply.model.BbsDTO;

public class BbsUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 글번호에 해당하는 상세내역을 수정폼 페이지로 전달하는 클래스.
		int bbs_no = 
			Integer.parseInt(request.getParameter("no").trim());
		
		int nowPage = 
			Integer.parseInt(request.getParameter("page").trim());
		
		BbsDAO dao = BbsDAO.getInstance();
		BbsDTO dto = dao.getBbsCont(bbs_no);
		
		// 해당 데이터를 view page로 이동
		request.setAttribute("update", dto);
		request.setAttribute("page", nowPage);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("view/bbs_update.jsp");
		
		return forward;
		
	}

}
