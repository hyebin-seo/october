package com.reply.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reply.model.BbsDAO;
import com.reply.model.BbsDTO;

public class BbsContAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// get 방식으로 넘어온 글번호에 해당하는 상세내역을 조회하는 클래스.
		
		int bbs_no = 
			Integer.parseInt(request.getParameter("no").trim());
		int nowPage = 
			Integer.parseInt(request.getParameter("page").trim());
		
		BbsDAO dao = BbsDAO.getInstance();
		
		// 조회수 증가 메서드 호출
		dao.bbsHit(bbs_no);
		
		// 글번호에 해당하는 상세 내역을 조회하는 메서드 호출
		BbsDTO dto = dao.getBbsCont(bbs_no);
		
		// 키로 저장하여 view page로 이동
		request.setAttribute("cont", dto);
		request.setAttribute("page", nowPage);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("view/bbs_cont.jsp");
		
		return forward;
		
	}

}
