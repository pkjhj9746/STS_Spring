<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<body>
	<div id="main" class="wrapper style1">
		<div class="container">
<form action="reply.do" method="post">
<input type="hidden" name=bId value="${dto.bId }"/>
<input type="hidden" name=bGroup value="${dto.bGroup}"/>
<input type="hidden" name=bStep value="${dto.bStep }"/>
<input type="hidden" name=bIndent value="${dto.bIndent }"/>
<table boarder=1>
	<tr>
		<td>이름</td>
		<td><input type="text" name=bName value=""/></td>
	</tr>
	<tr>
		<td>제목</td>
		<td><input type="text" name=bTitle value=""/></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><textarea rows=10  name=bContent></textarea></td>
	</tr>
	<tr>
		<td colspan=2>
			<input type="submit" value="답글달기" />&nbsp;&nbsp;&nbsp;
			<a href="listSearch.do">목록보기</a>
		</td>
	</tr>
</table>

</form>
</div>
</div>
<%@ include file="../footer.jsp"%>















