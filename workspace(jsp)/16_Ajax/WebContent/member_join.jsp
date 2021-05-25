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
		$("#idcheck_btn").mouseover(function() {
			$("#idcheck").hide(); //span영역 숨기기
			let userId = $("#member_id").val();
			
			// 입력 길이 체크
			if($.trim($("#member_id").val()).length < 4) {
				let warningTxt = '<font color="red">아이디는 4자 이상이어야 합니다.</font>';
				$("#idcheck").text(''); // span영역 초기화
				$("#idcheck").show();
				$("#idcheck").append(warningTxt);
				$("member_id").val("").focus();
				return false;
			}
			
			// 입력 길이 체크
			if($.trim($("#member_id").val()).length > 16) {
				let warningTxt = '<font color="red">아이디는 16자 이하여야 합니다.</font>';
				$("#idcheck").text(''); // span영역 초기화
				$("#idcheck").show();
				$("#idcheck").append(warningTxt);
				$("member_id").val("").focus();
				return false;
			}
			
			// 아이디 중복 여부 확인 - Ajax(비동기)
			$.ajax({
				type:"post",
				url: "data/idCheck.jsp",
				data: {"paramId" : userId},
				success: function(data) {
					if($.trim(data) == 1) { // id 존재할 경우
						let warningTxt = '<font color="red">중복된 아이디입니다.</font>';
						$("#idcheck").text(""); // span영역 초기화
						$("#idcheck").show();
						$("#idcheck").append(warningTxt);
						$("member_id").val("").focus();
						return false;
					} else {
						let warningTxt = '<font color="blue">사용 가능한 아이디입니다.</font>';
						$("#idcheck").text(""); // span영역 초기화
						$("#idcheck").show();
						$("#idcheck").append(warningTxt);
					}
				},
				error: function(request,status,error){
			        alert("code:"+request.status+"\n"
			        		+"message:"+request.responseText+"\n"+"error:"+error);
				}
			});
		});
		
	});
</script>
</head>
<body>
	<form method="post" action="http://www.google.com">
		<table border="1" cellspacing="0" width="450">
			<tr>
				<th>회원 아이디</th>
				<td>
					<input type="text" name="member_id" id="member_id" size="20">
					<input type="button" value="아이디중복체크" id="idcheck_btn">
					<span id="idcheck"></span>
				</td>
			</tr>
			
			<tr>
				<th>회원 이름</th>
				<td> <input name="member_name"> </td>
			</tr>
		</table>
	</form>
</body>
</html>