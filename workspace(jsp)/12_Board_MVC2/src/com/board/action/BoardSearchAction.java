package com.board.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDAO;
import com.board.model.BoardDTO;

public class BoardSearchAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String search_field = request.getParameter("search_field").trim();
		String search_name = request.getParameter("search_name").trim();
		
		BoardDAO dao = BoardDAO.getInstance();
		List<BoardDTO> list = dao.searchBoard(search_field, search_name);
		request.setAttribute("search", list);
		return "view/board_search.jsp";
	}

}
