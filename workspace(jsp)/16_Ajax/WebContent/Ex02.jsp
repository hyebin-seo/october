<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">

	//문서의 body 부분을 읽고 난 후 jquery를 실행하라는 의미
	$(function () {
		$.ajax({
			type: "post",
			dataType: "html",
			url : "data/data.html",
			success : function(data) {
				document.body.innerHTML = data;
			},
			error : function () {
				alert("에러 발생");
			}
		});
	});
</script>
</head>
<body>

</body>
</html>