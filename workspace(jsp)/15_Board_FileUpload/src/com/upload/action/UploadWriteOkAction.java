package com.upload.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.upload.model.UploadDAO;
import com.upload.model.UploadDTO;

public class UploadWriteOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 자료실 폼 페이지에서 넘어온 데이터들을 DB에 저장하는 클래스.
		
		UploadDTO dto = new UploadDTO();
		
		// 첨부파일이 저장될 경로(위치)
		String saveFolder =
				"C:\\NCS\\workspace(jsp)\\15_Board_FileUpload\\WebContent\\upload";
		
		// 첨부파일의 최대 크기
		int fileSize = 10 * 1024 * 1024;  // 10MB
		
		// 파일 업로드를 진행 시 이진 파일 업로드를 위한 객체 생성
		MultipartRequest multi = new MultipartRequest(
				request,                         // 일반적인 request 객체
				saveFolder,                      // 업로드 파일 저장 위치 
				fileSize,                        // 업로드할 파일의 최대 크기 
				"UTF-8",                         // 문자 인코딩 방식
				new DefaultFileRenamePolicy()    // 파일 이름이 중복이 안되게 설정
				);
		
		// 자료실 폼에서 넘어온 데이터들을 받아주어야 한다.
		String upload_writer = multi.getParameter("upload_writer").trim();
		String upload_title = multi.getParameter("upload_title").trim();
		String upload_content = multi.getParameter("upload_content").trim();
		String upload_pwd = multi.getParameter("upload_pwd").trim();
		
		// 자료실 폼에서 type="file" 로 되어 있으면
		// getFile() 메서드로 받아 주어야 함.
		File upload_file = multi.getFile("upload_file");
		
		if(upload_file != null) {  // 첨부파일이 존재하는 경우
			
			// getName() : 첨부파일의 이름을 문자열로 반환해 주는 메서드
			String fileName = upload_file.getName();
			
			// 날짜 객체 생성
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH) + 1;
			int day = cal.get(Calendar.DAY_OF_MONTH);
			
			// ........../upload/2021-05-21
			String homedir = saveFolder+"/"+year+"-"+month+"-"+day;
			
			
			// 날짜 폴더를 만들어 보자.
			File path1 = new File(homedir);
			if(!path1.exists()) {  // 폴더가 존재하지 않는 경우
				path1.mkdirs();    // 실제 폴더를 만드는 메서드.
			}
			
			// 파일 폴더를 만들어 보자. ==> 예) 홍길동_파일명
			// ........../upload/2021-05-21/홍길동_파일명
			String reFileName = upload_writer+"_"+fileName;
			
			upload_file.renameTo(new File(homedir+"/"+reFileName));
			
			String fileDBName = 
					"/"+year+"-"+month+"-"+day+"/"+reFileName;
			
			dto.setUpload_file(fileDBName);
			
		}
		
		dto.setUpload_writer(upload_writer);
		dto.setUpload_title(upload_title);
		dto.setUpload_cont(upload_content);
		dto.setUpload_pwd(upload_pwd);
		
		UploadDAO dao = UploadDAO.getInstance();
		
		int res = dao.insertUpload(dto);
		
		PrintWriter out = response.getWriter();
		ActionForward forward = new ActionForward();
		
		if(res > 0) {
			forward.setRedirect(true);
			forward.setPath("upload_list.do");
		}else {
			out.println("<script>");
			out.println("alert('자료실 업로드 실패~~~')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;
		
	}

}
