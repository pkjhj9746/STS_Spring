<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<% %>
<body class="no-sidebar">

	<div id="main" class="wrapper style1">
		<div class="container">
			<h3 id="notice_text">공지사항 & 할인/이벤트 게시글 수정</h3>
			<form action="modefy" method="post" name="frm" enctype="multipart/form-data">

				<input type="hidden" name="bId" value="${dto.bId }" /> 
				<input type="hidden" name="page" value="${bSearchDto.currentPageNum }" /> 
					<input type="hidden" name="pageDataCount" value="${bSearchDto.pageDataCount }" />
					<input type="hidden" name = "nonmakeimg" value="${dto.bFile}"/>
<%-- 					<input type="text" name = "searchCol" value="${bSearchDto.searchCol}"/>
					<input type="text" name = "searchVal" value = "${bSearchDto.searchVal }"/> --%>
				<table align="center" id="content-table">
					<tr>
						<td>이름</td>
						<td>${dto.bName }</td>
						<td>제목</td>
						<td><input type="text" name="bTitle" value="${dto.bTitle }" /></td>
					</tr>
					<tr>
						<td>내용</td>
						<td colspan="3"><textarea rows=10 name="bContent">${dto.bContent}</textarea></td>
					</tr>										
					<tr>
						<td colspan="4">
							<c:choose>
								<c:when test = "${empty dto.bFile}">
									<img src = ".//images/MARK.jpg">
								</c:when>
								<c:otherwise>
									<img src = "image/${dto.bFile}">
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					
					<tr>
						<th>사 진</th>
						<td colspan="4">><input type="file" name="bFile"></td>
					</tr>
					<tr>
						<td colspan="5"><input type="submit" value="수정" id="listbutton" />&nbsp;&nbsp;&nbsp;
							<a
							href="listSearch.do?page=${bSearchDto.currentPageNum }
							&pageDataCount=${bSearchDto.pageDataCount }
							&searchCol=${bSearchDto.searchCol }
							&searchVal=${bSearchDto.searchVal }" id="listbutton">목록</a></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<%@ include file="../footer.jsp"%>