package com.board.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDAO;
import com.board.model.BoardDTO;

public class BoardUpdateOkAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String board_title = request.getParameter("title").trim();

		String board_content = request.getParameter("content").trim();

		String board_pwd = request.getParameter("pwd");

		String db_pwd = request.getParameter("db_pwd");
		
		int board_no = Integer.parseInt(request.getParameter("board_no").trim());
		
		int nowPage = Integer.parseInt(request.getParameter("page"));
		
		PrintWriter out = response.getWriter();
		
		if(board_pwd.equals(db_pwd)) {
			BoardDTO dto = new BoardDTO();
	
			dto.setBoard_no(board_no);
	
			dto.setBoard_title(board_title);
	
			dto.setBoard_cont(board_content);
	
			BoardDAO dao = BoardDAO.getInstance();
	
			int res = dao.updateBoard(dto);

			if (res > 0) {
				out.println("<script>");
				out.println("alert('게시물 수정 성공!!!')");
				out.println("location.href='board_cont.do?no=" +board_no+ "&page=" +nowPage+ "'");
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('게시물 수정 실패~~~')");
				out.println("history.back()");
				out.println("</script>");
			}
		} else {
			out.println("<script>");
			out.println("alert('비밀번호 불일치!')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
}
