<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/views/common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서목록</title>
</head>
<body>
<table border="1">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>출판일</th>
		<th>내용</th>
	</tr>
<c:forEach items="${bookList}" var="book">
	<tr>
		<td>${book.b_num}</td>
		<td><a href="/book/view?b_num=${book.b_num}">${book.b_title}</a></td>
		<td>${book.b_author}</td>
		<td>${book.b_credat}</td>
		<td>${book.b_desc}</td>
	</tr>

</c:forEach>		
</table>
<a href="/views/book/book_insert"><button>회원추가</button></a>
</body>
</html>