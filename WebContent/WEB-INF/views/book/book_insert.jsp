<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보입력</title>
</head>
<body>
	<form method="post" action="/book/insert">
	
	<table border="3">
	<tr>
		<th>제목</th>
		<td><input type="text" name="b_title"></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><input type="text" name="b_author"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><input type="text" name="b_desc"></td>
	</tr>
	<tr>
		<th colspan="2"><button>회원정보입력</button></th>
	</tr>
	</table>
	</form>

</body>
</html>