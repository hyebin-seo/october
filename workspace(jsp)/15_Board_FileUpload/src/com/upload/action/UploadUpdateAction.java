package com.upload.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upload.model.UploadDAO;
import com.upload.model.UploadDTO;

public class UploadUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 글번호에 해당하는 글을 DB에서 조회해서 수저 폼 페이지로 전달하는 클래스.
		
		int upload_no = 
			Integer.parseInt(request.getParameter("no").trim());
		
		UploadDAO dao = UploadDAO.getInstance();
		
		UploadDTO dto = dao.uploadContent(upload_no);
		
		// DB에서 반환받은 상세내역을 키로 저장하여 수정폼 페이지(view page)로 이동.
		request.setAttribute("update", dto);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		
		forward.setPath("view/upload_update.jsp");
		
		
		return forward;
	
	}

}
