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

@WebServlet("/update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get 방식으로 넘어온 글번호로 조회
		int board_no = Integer.parseInt(request.getParameter("no"));
		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO cont = dao.boardCont(board_no); //글 상세 내용 조회

		request.setAttribute("edit", cont);
		RequestDispatcher rd = 
				request.getRequestDispatcher("view/board_edit.jsp");
		rd.forward(request, response);
	}

}
