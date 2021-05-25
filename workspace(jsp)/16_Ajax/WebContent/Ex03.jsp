<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">
	$(function () {
		$.ajax({
			type: "get",
			dataType: "xml",
			url : "data/book.xml",
			success : function(data) {
				// $(data)는 $.ajax() 메서드가 book.xml에서 불러온 데이터 객체
				// each() : 반복 함수
				$(data).find("book").each(function () {
					// this : 현재의 book 객체
					let title = $("title", this).text();
					let author = $("author", this).text();
					let price = $("price", this).text();
					let txt = "<li>책 제목 : "+title+"</li>"+
							  "<li>책 저자 : "+author+"</li>"+
							  "<li>책 가격 : "+price+"</li><hr>";
					$("body").append(txt);
				});
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