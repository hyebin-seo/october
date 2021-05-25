package com.reply.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reply.model.BbsDAO;
import com.reply.model.BbsDTO;

public class BbsReplyOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 답변글 폼에서 넘어온 데이터들을 DB에 저장하는 클래스
		
		String reply_writer = request.getParameter("reply_writer").trim();
		String reply_title = request.getParameter("reply_title").trim();
		String reply_content = request.getParameter("reply_content").trim();
		String reply_pwd = request.getParameter("reply_pwd").trim();
		
		// 히든으로 넘어온 데이터들도 받아 주어야 한다.
		int bbs_no = 
			Integer.parseInt(request.getParameter("bbs_no").trim());
		
		int bbs_group =
			Integer.parseInt(request.getParameter("bbs_group").trim());
		
		int bbs_step =
			Integer.parseInt(request.getParameter("bbs_step").trim());
		
		int bbs_indent = 
			Integer.parseInt(request.getParameter("bbs_indent").trim());
		
		int nowPage = 
			Integer.parseInt(request.getParameter("page").trim());
		
		
		BbsDTO dto = new BbsDTO();
		dto.setBoard_no(bbs_no);
		dto.setBoard_writer(reply_writer);
		dto.setBoard_title(reply_title);
		dto.setBoard_cont(reply_content);
		dto.setBoard_pwd(reply_pwd);
		dto.setBoard_group(bbs_group);
		dto.setBoard_step(bbs_step);
		dto.setBoard_indent(bbs_indent);
		
		BbsDAO dao = BbsDAO.getInstance();
		
		// 기존에 작성했던 답변글이 있으면 해당 답변글의 step을 하나 증가시키는 메서드 호출
		dao.replyUpdate(bbs_group, bbs_step);
		
		// 답변 글을 DB에 등록하는 메서드 호출
		int res = dao.replyBbs(dto);
		
		PrintWriter out = response.getWriter();
		
		ActionForward forward = new ActionForward();
		
		
		if(res > 0) {   // 답변 글이 정성적으로 DB에 등록이 된 경우
			forward.setRedirect(true);
			forward.setPath("bbs_list.do?page="+nowPage);
		}else {
			out.println("<script>");
			out.println("alert('게시물 답변 등록 실패~~~')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		
		return forward;
		
	}

}
