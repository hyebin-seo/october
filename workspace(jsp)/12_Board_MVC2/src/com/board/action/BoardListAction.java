package com.board.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDAO;
import com.board.model.BoardDTO;

public class BoardListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// action 클래스는 비지니스 로직을 수행하는 클래스.
		// board 테이블의 전체 리스트를 조회하는 클래스.
		
		BoardDAO dao = BoardDAO.getInstance();
		
		List<BoardDTO> boardList = dao.getBoardList();
		
		request.setAttribute("List", boardList);
		
		return "view/board_list.jsp";
		
	}

}
