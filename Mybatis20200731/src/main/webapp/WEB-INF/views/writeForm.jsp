<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" type = "text/css" href = "./css/board200707.css">
</head>
<body>
	<h1>게시글 목록</h1>
		<table width="500" cellpadding="0" cellspacing="0" border="1">
			<form action="write.do" method="post">
				<tr>
					<th>이름</th>
					<td><input type="text" name="bName" size="50"></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="bTitle" size="50"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="bContent" rows="10" cols="80"></textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="입력">
					&nbsp;&nbsp;
					<a href="list.do">목록보기</a> 
				</tr>
			</form>
   		</table>	
					
</body>
</html>