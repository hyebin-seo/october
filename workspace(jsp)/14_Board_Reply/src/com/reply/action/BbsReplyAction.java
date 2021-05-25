package com.reply.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reply.model.BbsDAO;
import com.reply.model.BbsDTO;

public class BbsReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// get방식으로 넘어온 글번호에 해당하는 게시글을 조회하여 상세내역을
		// 답변글 폼 페이지에 넘겨주는 클래스.
		
		int bbs_no = 
			Integer.parseInt(request.getParameter("no").trim());
		
		int nowPage = 
			Integer.parseInt(request.getParameter("page").trim());
		
		BbsDAO dao = BbsDAO.getInstance();
		BbsDTO dto = dao.getBbsCont(bbs_no);
		
		// dto 데이터를 키로 저장하여 답변글 폼 페이지로 이동시키자.
		request.setAttribute("reply", dto);
		request.setAttribute("page", nowPage);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("view/bbs_reply.jsp");
		
		return forward;
		
	}

}
