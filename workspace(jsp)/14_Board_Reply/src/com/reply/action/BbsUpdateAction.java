package com.reply.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reply.model.BbsDAO;
import com.reply.model.BbsDTO;

public class BbsUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int board_no = Integer.parseInt(request.getParameter("no"));
		int nowPage = Integer.parseInt(request.getParameter("page"));
		
		BbsDAO dao = BbsDAO.getInstance();

		// 글번호에 해당하는 상세 내역 메서드 호출
		BbsDTO dto = dao.bbsCont(board_no);
		request.setAttribute("cont", dto);
		request.setAttribute("page", nowPage);
		
		ActionForward forward = new ActionForward();

		forward.setRedirect(false);
		forward.setPath("view/bbs_update.jsp");

		return forward;
	}

}
