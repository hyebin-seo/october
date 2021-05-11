package com.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDAO;
import com.board.model.BoardDTO;

@WebServlet("/content.do")
public class ContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ContentServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get 방식으로 넘어온 글번호로 조회
		int board_no = Integer.parseInt(request.getParameter("no"));
		BoardDAO dao = BoardDAO.getInstance();
		dao.boardHit(board_no); //조회수 증가 메서드
		BoardDTO boardCont = dao.boardCont(board_no); //글 상세 내용 조회
		request.setAttribute("cont", boardCont);
		RequestDispatcher rd = 
				request.getRequestDispatcher("view/board_content.jsp");
		rd.forward(request, response);
		
	}

}
