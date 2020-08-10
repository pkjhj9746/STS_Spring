<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../header.jsp"%>

<body class="no-sidebar">
	<div id="main" class="wrapper style1">
		<div class="container">

			<h3 id="notice_text">공지사항 & 할인/이벤트</h3>
			<table align="center" id="content-table">
				<tr>
				<tr>
					<td colspan="5">
						<form action="listSearch" method="post">
							<div id="board_sug_search">
								검색 옵션 : <select id="boardSearch_select" name="searchCol">
									<option value="bTitle" selected="selected">제목</option>
									<option value="bName">작성자</option>
									<option value="bContent">내용</option>
								</select>&nbsp;검색 값 : <input type="text" name="searchVal"
									id="board_sug_search_text" value="${bSearchDto.searchVal }">
								<input type="submit" value="검색" id="listbutton">
							</div>
						</form>
					</td>
				</tr>
				<tr>
					<td>번호</td>
					<td>이름</td>
					<td>제목</td>
					<td>날짜</td>
					<td>조회수</td>
				</tr>

				<c:forEach items="${dtos}" var="dto">
					<tr>
						<td>${dto.bId }</td>
						<td>${dto.bName }</td>
						<td><c:forEach begin="1" end="${dto.bIndent }">--</c:forEach>
							<a
							href="bContentCommand?bId=${dto.bId }
									&page=${bSearchDto.currentPageNum }
									&searchCol=${bSearchDto.searchCol }
									&searchVal=${bSearchDto.searchVal }
									&pageDataCount=${bSearchDto.pageDataCount }">${dto.bTitle }</a></td>
						<td>${dto.bDate}</td>
						<td>${dto.bHit }</td>
					</tr>
				</c:forEach>

				<!--  
<tr>
	<td colspan="5"><a href="write_view.do">글쓰기</a></td>
</tr>
-->
				<tr>
					<td colspan="5" align="center"><a
						href="listSearch?page=${bSearchDto.firstPageNum }
		&pageDataCount=${bSearchDto.pageDataCount }
		&searchCol=${bSearchDto.searchCol }
		&searchVal=${bSearchDto.searchVal }">◀◀맨앞으로
					</a>&nbsp; <a
						href="listSearch?page=${bSearchDto.prevPageNum }
		&pageDataCount=${bSearchDto.pageDataCount }
		&searchCol=${bSearchDto.searchCol }
		&searchVal=${bSearchDto.searchVal }">◀앞으로</a>&nbsp; 
		
		<c:forEach var="i" begin="${bSearchDto.startPageNum }"
							end="${bSearchDto.endPageNum }" step="1">
							<c:choose>
								<c:when test="${i eq bSearchDto.currentPageNum }">
									<a style="color: blue;"
										href="listSearch?page=${i }
												&pageDataCount=${bSearchDto.pageDataCount }
												&searchCol=${bSearchDto.searchCol }
												&searchVal=${bSearchDto.searchVal }">${i }
									</a>&nbsp; 
								</c:when>
								<c:otherwise>
									<a
										href="listSearch?page=${i }
												&pageDataCount=${bSearchDto.pageDataCount }
												&searchCol=${bSearchDto.searchCol }
												&searchVal=${bSearchDto.searchVal }">${i } 
									</a>&nbsp;
								</c:otherwise>
							</c:choose>

						</c:forEach> <a
						href="listSearch?page=${bSearchDto.nextPageNum }
		&pageDataCount=${bSearchDto.pageDataCount }
		&searchCol=${bSearchDto.searchCol }
		&searchVal=${bSearchDto.searchVal }">뒤로▶
					</a>&nbsp; <a
						href="listSearch?page=${bSearchDto.lastPageNum }
		&pageDataCount=${bSearchDto.pageDataCount }
		&searchCol=${bSearchDto.searchCol }
		&searchVal=${bSearchDto.searchVal }">맨뒤로▶▶</a>
					</td>
				</tr>
			</table>

			<c:choose>
				<c:when test="${!empty loginAdmin}">
					<a id="listbutton" href="write_view">글쓰기</a>
				</c:when>
				<c:otherwise>

				</c:otherwise>
			</c:choose>

		</div>
	</div>

	<%@ include file="../footer.jsp"%>