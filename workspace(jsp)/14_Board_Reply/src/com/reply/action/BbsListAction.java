package com.reply.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reply.model.BbsDAO;
import com.reply.model.BbsDTO;

public class BbsListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// DB의 전체 레코드를  view page로 이동시키는 클래스
		BbsDAO dao = BbsDAO.getInstance();
		
		int rowsize = 10;
		int block = 5;
		int totalRecord = 0;
		int allPage = 0;
		int page = 0;
		
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}else {
			page = 1;
		}
		
		int startNo = (page * rowsize) - (rowsize - 1);
		int endNo = (page * rowsize);
		int startBlock = (((page - 1) / block) * block) + 1;
		int endBlock = (((page - 1) / block) * block) + block;
		
		totalRecord = dao.getListCount();
		
		allPage = (int) Math.ceil(totalRecord / (double)rowsize);
		
		if (endBlock > allPage) {
			endBlock = allPage;
		}
		
		List<BbsDTO> pageList = dao.getBbsList(page, rowsize);
		
		request.setAttribute("page", page);
		request.setAttribute("rowsize", rowsize);
		request.setAttribute("block", block);
		request.setAttribute("totalRecord", totalRecord);
		request.setAttribute("allPage", allPage);
		request.setAttribute("startNo", startNo);
		request.setAttribute("endNo", endNo);
		request.setAttribute("startBlock", startBlock);
		request.setAttribute("endBlock", endBlock);
		request.setAttribute("List", pageList);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("view/bbs_list.jsp");
		
		return forward;
		
	}

}
