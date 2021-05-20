package com.reply.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BbsDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int board_no = Integer.parseInt(request.getParameter("no"));
		int nowPage = Integer.parseInt(request.getParameter("page"));
		
		request.setAttribute("no", board_no);
		request.setAttribute("page", nowPage);

		ActionForward forward = new ActionForward();

		forward.setRedirect(false);
		forward.setPath("view/bbs_delete.jsp");

		return forward;
		
	}

}
