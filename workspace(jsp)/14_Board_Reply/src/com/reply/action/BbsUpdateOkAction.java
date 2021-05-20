package com.reply.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reply.model.BbsDAO;
import com.reply.model.BbsDTO;

public class BbsUpdateOkAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String board_title = request.getParameter("title").trim();

		String board_content = request.getParameter("content").trim();

		String board_pwd = request.getParameter("pwd");

		int no = Integer.parseInt(request.getParameter("board_no").trim());
		
		int nowPage = Integer.parseInt(request.getParameter("page"));
		
		PrintWriter out = response.getWriter();
		ActionForward forward = new ActionForward();
		
		BbsDTO dto = new BbsDTO();
		
		dto.setBoard_no(no);

		dto.setBoard_title(board_title);

		dto.setBoard_cont(board_content);

		BbsDAO dao = BbsDAO.getInstance();

		int res = dao.updateBoard(dto, board_pwd);
		
		if (res > 0) {
			out.println("<script>");
			out.println("alert('게시물 수정 성공!!!')");
			out.println("</script>");
			forward.setRedirect(true);
			forward.setPath("bbs_cont.do?no="+no+"&page="+nowPage);
		} else if(res == -1) {
			out.println("<script>");
			out.println("alert('비밀번호 불일치!')");
			out.println("</script>");
			forward.setRedirect(true);
			forward.setPath("bbs_update.do?no="+no+"&page="+nowPage);
		} else {
			out.println("<script>");
			out.println("alert('게시물 수정 실패~~~')");
			out.println("</script>");
			forward.setRedirect(true);
			forward.setPath("bbs_update.do?no="+no+"&page="+nowPage);
		}
		
		return forward;
	}
}
