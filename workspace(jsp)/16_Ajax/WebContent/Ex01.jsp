<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">
	/*
		Ajax 형식
		$.ajax({
			type : 통신 타입을 설정 - "get" 또는 "post"
			async : 비동기식으로 처리할지를 결정 - false인 경우 동기식. 생략시 비동기식(true)
			url : 요청할 URL
			data : 서버에 요청할 때 보낼 매개변수 설정 - 서버로 전송할 데이터
			dataType : 응답을 받을 데이터의 타입을 설정 - text, xml, json 등
			success : 요청 및 응답에 실패했을 때 처리할 내용
			complete : 모든 작업을 마친 후 처리할 내용을 설정
		});
	
	*/

	function process() {
		$.ajax({
				type: "get",
				dataType: "text",
				url: "data/test.jsp",
				data: {param: "Hello Ajax!!!"},
				success: function(data) {
					$(".message").append(data);
				},
				error: function(data) {
					alert("에러가 발생했습니다.");
				},
				complete: function(data) {
					alert("작업을 완료했습니다.");
				}
				
		});
		
	}
</script>
</head>
<body>
	<input type="button" value="전송하기" onclick="process()"> 
	
	<div id="message"></div>
</body>
</html>