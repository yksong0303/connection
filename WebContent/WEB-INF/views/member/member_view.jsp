<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<th>번호</th>
		<td>${member.m_num}</td>
	</tr>
	<tr>
		<th>이름</th>
		<td>${member.m_name}</td>
	</tr>
	<tr>
		<th>아이디</th>
		<td>${member.m_id}</td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td>${member.m_pwd}</td>
	</tr>
	<tr>
		<th>가입일</th>
		<td>${member.m_credate}</td>
	</tr>
</table>
</body>
</html>