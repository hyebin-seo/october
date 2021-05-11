package com.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDAO;
import com.board.model.BoardDTO;


@WebServlet("/insert.do")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public InsertServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String board_writer = request.getParameter("writer").trim();
		String board_title = request.getParameter("title").trim();
		String board_cont = request.getParameter("content").trim();
		String board_pwd = request.getParameter("pwd").trim();
		
		BoardDTO dto = new BoardDTO();
		dto.setBoard_writer(board_writer);
		dto.setBoard_title(board_title);
		dto.setBoard_cont(board_cont);
		dto.setBoard_pwd(board_pwd);
		
		BoardDAO dao = BoardDAO.getInstance();
		int res = dao.insertBoard(dto);
		
		PrintWriter out = response.getWriter();
		
		if(res > 0) { //성공
			out.println("<script>");
			out.println("alert('게시물 추가 성공!!!')");
			out.println("location.href='select.do'");
			out.println("</script>");
		} else { //실패
			out.println("<script>");
			out.println("alert('게시물 추가 실패...')");
			out.println("history.back()"); //실패했으니 홈페이지로 돌아가기
			out.println("</script>");
		}
	}

}
