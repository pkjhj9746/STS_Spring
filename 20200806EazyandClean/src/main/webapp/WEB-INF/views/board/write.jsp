<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<%
	
%>
<body class="no-sidebar">

	<div id="main" class="wrapper style1">
		<div class="container">
			<h3 id="notice_text">공지사항 & 할인/이벤트 게시글 작성</h3>
			<form action="write" method="post" name="frm" enctype="multipart/form-data">
				<table align="center" id="content-table">
					<tr>
						<td>이름</td>
						<td><input type="text" name="bName" value="${loginAdmin}" /></td>
					</tr>
					<tr>
						<td>제목</td>
						<td><input type="text" name="bTitle" value="" /></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea rows=10 name="bContent"></textarea></td>
					</tr>					
					<tr>
						<th>사 진</th>
						<td><input type = "file" name = "bFile"></td>
					</tr> 


					<tr>
						<td colspan=2><input type="submit" value=입력 id="listbutton"/>&nbsp;&nbsp;&nbsp;
							<a href="listSearch.do" id="listbutton">목록</a></td>
					</tr>
				</table>

			</form>
		</div>
	</div>
	<%@ include file="../footer.jsp"%>