package com.reply.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reply.model.BbsDAO;
import com.reply.model.BbsDTO;

public class BbsDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// get방식으로 넘어온 글번호에 해당하는 게시글을 DB에서 삭제하는 클래스.
		
		int bbs_no = 
			Integer.parseInt(request.getParameter("no").trim());
		
		int nowPage = 
			Integer.parseInt(request.getParameter("page").trim());
		
		BbsDAO dao = BbsDAO.getInstance();
		BbsDTO dto = dao.getBbsCont(bbs_no);
		
		request.setAttribute("Cont", dto);
		request.setAttribute("bunho", bbs_no);
		request.setAttribute("page", nowPage);
		
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("view/bbs_delete.jsp");
		
		return forward;
		
	}

}
