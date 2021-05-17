package com.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardWriteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 글쓰기 폼으로 이동하는 클래스
		
		return "view/board_write.jsp";
		
	}

}
