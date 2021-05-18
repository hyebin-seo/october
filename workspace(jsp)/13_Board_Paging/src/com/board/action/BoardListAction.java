package com.board.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDAO;
import com.board.model.BoardDTO;

public class BoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// action 클래스는 비지니스 로직을 수행하는 클래스.
		// board 테이블의 전체 리스트를 조회하는 클래스.
		
		/*BoardDAO dao = BoardDAO.getInstance();
		
		List<BoardDTO> boardList = dao.getBoardList();
		
		request.setAttribute("List", boardList);
		
		return "view/board_list.jsp";
		*/
		
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
		
		BoardDAO dao = BoardDAO.getInstance();
		
		totalRecord = dao.getListCount();
		
		allPage = (int) Math.ceil(totalRecord / (double)rowsize);
		
		if (endBlock > allPage) {
			endBlock = allPage;
		}
		
		List<BoardDTO> pageList = dao.getBoardList(page, rowsize);
		
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
	}

}
