package com.board.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDAO;
import com.board.model.BoardDTO;

public class BoardDeleteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int board_no = Integer.parseInt(request.getParameter("no"));
		
		//BoardDAO dao = BoardDAO.getInstance();
		//BoardDTO dto = dao.boardCont(board_no);
		//request.setAttribute("del", dto);
		
		request.setAttribute("no", board_no);
		return "view/board_delete.jsp";
	}

}
