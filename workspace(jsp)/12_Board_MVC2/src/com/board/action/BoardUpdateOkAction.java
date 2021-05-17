package com.board.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDAO;
import com.board.model.BoardDTO;

public class BoardUpdateOkAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 해당 글번호의 글 수정
		String board_title = request.getParameter("title").trim();
		String board_content = request.getParameter("content").trim();
		String board_pwd = request.getParameter("pwd").trim();
		int board_no = Integer.parseInt(request.getParameter("no").trim());
		String board_db_pwd = request.getParameter("db_pwd").trim();
		
		PrintWriter out = response.getWriter();
		
		if(board_pwd.equals(board_db_pwd)) {
			BoardDTO dto = new BoardDTO();
			dto.setBoard_no(board_no);
			dto.setBoard_title(board_title);
			dto.setBoard_cont(board_content);
			
			BoardDAO dao = BoardDAO.getInstance();
			int res = dao.updateBoard(dto);
			
			if(res > 0) {
				out.println("<script>");
				out.println("alert('게시물 수정 성공')");
				out.println("location.href='board_cont.do?no="+board_no+"'");
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('게시물 수정 실패')");
				out.println("history.back()");
				out.println("</script>");
			}
		} else { //비밀번호가 맞지 않음
			out.println("<script>");
			out.println("alert('비밀번호 불일치')");
			out.println("history.back()");
			out.println("</script>");
		}
		return null;
	}

}
