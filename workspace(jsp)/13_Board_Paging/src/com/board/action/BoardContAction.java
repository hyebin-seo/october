package com.board.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDAO;
import com.board.model.BoardDTO;

public class BoardContAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 글제목을 클릭 했을 때 get방식으로 넘어온 글번호에 해당하는 게시글 조회
		
		int board_no = Integer.parseInt(request.getParameter("no"));
		int nowPage = Integer.parseInt(request.getParameter("page"));
		
		BoardDAO dao = BoardDAO.getInstance();
		
		// 상세 내역 출력 전 조회수 증가
		dao.boardHit(board_no);
		
		// 글번호에 해당하는 상세 내역 메서드 호출
		BoardDTO dto = dao.boardCont(board_no);
		request.setAttribute("cont", dto);
		request.setAttribute("page", nowPage);
		
		
	}

}
