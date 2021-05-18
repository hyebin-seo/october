package com.board.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDAO;
import com.board.model.BoardDTO;

public class BoardSearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 검색어에 해당하는 게시물을 DB에서 조회하여 view page로 전송
		
		String search_field = request.getParameter("search_field").trim();

		String search_name = request.getParameter("search_name").trim();

		BoardDAO dao = BoardDAO.getInstance();

		// 페이징 작업
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
		
		totalRecord = dao.searchListCount(search_field, search_name);
		
		allPage = (int) Math.ceil(totalRecord / (double)rowsize);
		
		if (endBlock > allPage) {
			endBlock = allPage;
		}
		
		List<BoardDTO> search = dao.searchBoardList(search_field, search_name, page, rowsize);
		
		request.setAttribute("page", page);
		request.setAttribute("rowsize", rowsize);
		request.setAttribute("block", block);
		request.setAttribute("totalRecord", totalRecord);
		request.setAttribute("allPage", allPage);
		request.setAttribute("startNo", startNo);
		request.setAttribute("endNo", endNo);
		request.setAttribute("startBlock", startBlock);
		request.setAttribute("endBlock", endBlock);
		request.setAttribute("List", search);
		request.setAttribute("search_field", search_field);
		request.setAttribute("search_name", search_name);
	}

}
