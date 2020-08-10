<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
 	response.sendRedirect("http://localhost:8181/20200727EazyandClean/listSearch.do");
	// url 맵핑이라 list.do와 같은 모든 .do는 BFrontController인 서블릿으로 가게 된다.
	%>	
</body>
</html>