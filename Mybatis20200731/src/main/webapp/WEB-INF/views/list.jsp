<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" type = "text/css" href = "resources/css/board200707.css">
</head>
<body>
	<h1>게시글 목록</h1>
		<table width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<th>번호</th><th>작성자</th><th>내용</th><th>삭제</th><th>조회수</th>
			<td>GroupNo</td><td>StepNo</td><td>IndentNo</td>
		</tr>
		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.mId}</td>
				<td>${dto.mWriter}</td>
				<td>${dto.mContent}</td>
				<td><a href="delete?mid=${dto.mId}"></a>	
				
				
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5"><a href="writeForm">글작성</a></td>
   		</tr>
   		
 
   </table>	
     
					
</body>
</html>