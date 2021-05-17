package com.board.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDAO;
import com.board.model.BoardDTO;

public class BoardUpdateAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//글 번호에 해당하는 게시글을 가져와서 폼에 띄워줌
		int board_no = Integer.parseInt(request.getParameter("no").trim());
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO dto = dao.boardCont(board_no);
		
		request.setAttribute("edit", dto);
		
		return "view/board_update.jsp";
	}

}
