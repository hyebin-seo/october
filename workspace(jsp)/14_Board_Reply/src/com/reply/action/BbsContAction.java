package com.reply.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reply.model.BbsDAO;
import com.reply.model.BbsDTO;

public class BbsContAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// get 방식으로 넘어온 글번호 해당하는 글 내용 출력
		
		int bbs_no = Integer.parseInt(request.getParameter("no"));
		int nowPage = Integer.parseInt(request.getParameter("page"));
		
		BbsDAO dao = BbsDAO.getInstance();
		
		dao.bbsHit(bbs_no);
		
		BbsDTO dto = dao.bbsCont(bbs_no);
		request.setAttribute("cont", dto);
		request.setAttribute("page", nowPage);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("view/bbs_cont.jsp");
		
		return forward;
	}

}
