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

@WebServlet("/updateOk.do")
public class UpdateOkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateOkServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		String board_writer = request.getParameter("writer").trim();
		String board_title = request.getParameter("title").trim();
		String board_cont = request.getParameter("content").trim();
		String board_pwd = request.getParameter("pwd").trim();
		
		BoardDTO dto = new BoardDTO();
		dto.setBoard_no(board_no);
		dto.setBoard_writer(board_writer);
		dto.setBoard_title(board_title);
		dto.setBoard_cont(board_cont);
		dto.setBoard_pwd(board_pwd);
		
		BoardDAO dao = BoardDAO.getInstance();
		int res = dao.updateBoard(dto);
		
		PrintWriter out = response.getWriter();
		
		if(res > 0) { //성공
			out.println("<script>");
			out.println("alert('게시물 수정 성공!!!')");
			out.println("location.href='content.do?no="+board_no+"'");
			out.println("</script>");
		} else if(res < 0){ //비밀번호 틀림
			out.println("<script>");
			out.println("alert('비밀번호가 틀렸습니다.')");
			out.println("history.back()"); //실패했으니 뒤로 돌아가기
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('존재하지 않는 게시글입니다.')");
			out.println("history.back()"); //실패했으니 뒤로 돌아가기
			out.println("</script>");
		}
	}

}
