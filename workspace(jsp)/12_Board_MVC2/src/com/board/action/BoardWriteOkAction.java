package com.board.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDAO;
import com.board.model.BoardDTO;

public class BoardWriteOkAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 글쓰기 폼에서 넘어온 데이터들을 DB에 저장하는 클래스.
		
		String board_writer = request.getParameter("writer").trim();
		String board_title = request.getParameter("title").trim();
		String board_content = request.getParameter("content").trim();
		String board_pwd = request.getParameter("pwd").trim();
		
		// DTO 객체의 setter() 메서드에 넘어온 데이터들을 인자로 넘겨주자.
		BoardDTO dto = new BoardDTO();
		dto.setBoard_writer(board_writer);
		dto.setBoard_title(board_title);
		dto.setBoard_cont(board_content);
		dto.setBoard_pwd(board_pwd);
		
		// DAO 객체에 DTO 객체를 인자로 넘겨서 DB에 게시물을 저장하자.
		BoardDAO dao = BoardDAO.getInstance();
		
		int res = dao.insertBoard(dto);
		
		PrintWriter out = response.getWriter();
		
		if(res > 0) {
			out.println("<script>");
			out.println("alert('게시물 추가 성공!!!')");
			out.println("location.href='board_list.do'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('게시물 추가 실패~~~')");
			out.println("hidtory.back()");
			out.println("</script>");
		}
		
		return null;
	}

}
