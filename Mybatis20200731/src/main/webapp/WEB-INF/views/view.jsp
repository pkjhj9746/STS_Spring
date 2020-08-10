<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet" type = "text/css" href = "./css/board200707.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시글 보기</h1>
	<table width="500" cellpadding ="0" cellspacing="0" border="1">
		<form action="modify.do" method="post">
			<input type="hidden" name="bId" value="${content_view.bId}">
			<tr>
				<th>번호</th>
				<td>${content_view.bId}</td>
			</tr>		
			<tr>
				<th>히트</th>
				<td>${content_view.bHit}</td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type = "text" name = "bName" value="${content_view.bName}"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type = "text" name = "bTitle" value="${content_view.bTitle}"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows = "10" cols="80" name="bContent">${content_view.bContent}</textarea></td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="수정"> &nbsp;&nbsp;
					<a href="list.do">목록보기</a>&nbsp;&nbsp;
					<a href="delete.do?bId=${content_view.bId}">삭제</a>&nbsp;&nbsp;
					<a href="reply_view.do?bId=${content_view.bId}">답변</a>
				</td>
			</tr>
		</form>	
	</table>
</body>
</html>