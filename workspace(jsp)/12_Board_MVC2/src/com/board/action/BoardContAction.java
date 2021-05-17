package com.board.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDAO;
import com.board.model.BoardDTO;

public class BoardContAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 글제목 클릭시 글 번호를 가지고 상세 내역 조회
		int board_no = Integer.parseInt(request.getParameter("no").trim());
		
		BoardDAO dao = BoardDAO.getInstance();
		
		// 조회 수 증가
		dao.boardHit(board_no);
		
		// 상세 내역 조회 메서드
		BoardDTO dto = dao.boardCont(board_no);
		
		request.setAttribute("Cont", dto);
		
		return "view/board_content.jsp";
	}

}
