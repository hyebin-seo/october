package com.upload.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upload.model.UploadDAO;
import com.upload.model.UploadDTO;

public class UploadDeleteOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 삭제폼 페이지에서 넘어온 글번호와 비밀번호를 가지고 DB에서 해당 글을 삭제하는 클래스.
		
		String upload_pwd = request.getParameter("upload_pwd").trim();
		
		int upload_no = 
			Integer.parseInt(request.getParameter("upload_no"));
		
		UploadDAO dao = UploadDAO.getInstance();
		
		UploadDTO dto = dao.uploadContent(upload_no);
		
		// upload된 파일까지 삭제.
		String up = "C:\\NCS\\workspace(jsp)\\15_Board_FileUpload\\WebContent\\upload";
		
		// 업로드된 파일명 : /년-월-일/파일명
		String fileName = dto.getUpload_file();
		
		ActionForward forward = new ActionForward();
		
		PrintWriter out = response.getWriter();
		
		int res = 0;
		
		// 비밀번호가 틀린 경우
		if(!upload_pwd.equals(dto.getUpload_pwd())) {
			out.println("<script>");
			out.println("alert('비밀번호가 틀립니다. 확인 요망')");
			out.println("history.back()");
			out.println("</script>");
		}else {  // 비밀번호가 같다면
			res = dao.uploadDelete(upload_no);
			
			if(fileName != null) {  // 첨부파일이 있는 경우
				File file = new File(up+fileName);
				file.delete();      // 기존 이진 파일 삭제하는 메서드.
			}
			
			if(res > 0) {
				forward.setRedirect(true);
				forward.setPath("upload_list.do");
			}else {
				out.println("<script>");
				out.println("alert('게시물 삭제 실패~~~')");
				out.println("history.back()");
				out.println("</script>");
			}
		}
		
		return forward;
	}

}
