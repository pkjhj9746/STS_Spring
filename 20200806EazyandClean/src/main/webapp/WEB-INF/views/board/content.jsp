<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../header.jsp"%>

<body>
	<form method="post" action="listSearch"	enctype="multipart/form-data" name="frm">
		<input type="hidden" name="page" value="${bSearchDto.currentPageNum}" /> 
		<input type="hidden" name="pageDataCount" value="${bSearchDto.pageDataCount}" />
		<input type="hidden" name = "nonmakeimg" value="${dto.bFile}">

		<div id="main" class="wrapper style1">
			<div class="container">
				<h3 id="notice_text">공지사항 & 할인/이벤트 게시글</h3>
				<table align="center" id="content-table"">
					<tr>
						<td>이름</td>
						<td>${dto.bName }</td>
						<td>번호</td>
						<td>${dto.bId }</td>
						<td>날짜</td>
						<td>${dto.bDate }</td>
						<td>조회수</td>
						<td>${dto.bHit }</td>
					</tr>
					<tr>
						<td>제목</td>
						<td colspan=7;>${dto.bTitle }</td>
					</tr>
					<tr>
						<td style="border-right: 1px solid lightgray; ">내용</td>
						<td colspan=7;>${dto.bContent }</td>
					</tr>
		
					<tr>
						<td colspan=8;>
							<c:choose>
								<c:when test = "${empty dto.bFile}">
									<img src = ".//images/MARK.jpg">
								</c:when>
								<c:otherwise>
								<%-- <img src = "${path}/dt.bFile">
									${path}/dto.bFile --%>
					<%-- 				<img src = "${path}/resources/boardImage/${dto.bFile}"> --%>
				<%-- 	D:/SPRING/springSTS2020/Workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/20200806EazyandClean/image/${dto.bFile} --%>
									 <img src ="/img/${dto.bFile}">
								</c:otherwise>
							</c:choose>
						</td>
					</tr>

					<tr>
						<td colspan=8>
							<!--
		<h1>page= ${bSearchDto.currentPageNum }</h1>
		<h1>pageDataCount= ${bSearchDto.pageDataCount }</h1>
--> <c:choose>
								<c:when test="${!empty loginAdmin}">
									<!--  삭제,수정,목록보기  -->
									<%-- 			<a href="reply_view.do?bId=${dto.bId }
			&page=${bSearchDto.currentPageNum }
			&pageDataCount=${bSearchDto.pageDataCount }
			&searchCol=${bSearchDto.searchCol }
			&searchVal=${bSearchDto.searchVal }">답글</a> --%>
									<a
										href="delete.do?bId=${dto.bId }
			&page=${bSearchDto.currentPageNum }
			&pageDataCount=${bSearchDto.pageDataCount }&
			searchCol=${bSearchDto.searchCol }
			&searchVal=${bSearchDto.searchVal }"  id="listbutton">삭제</a>
									<a
										href="modefy_view.do?bId=${dto.bId }
			&page=${bSearchDto.currentPageNum }
			&pageDataCount=${bSearchDto.pageDataCount }
			&searchCol=${bSearchDto.searchCol }
			&searchVal=${bSearchDto.searchVal }"  id="listbutton">수정</a>
									<a
										href="listSearch?page=${bSearchDto.currentPageNum }
			&pageDataCount=${bSearchDto.pageDataCount }
			&searchCol=${bSearchDto.searchCol }
			&searchVal=${bSearchDto.searchVal }"  id="listbutton">목록</a>
								</c:when>
								<c:otherwise>
		
									<a
										href="listSearch?page=${bSearchDto.currentPageNum }
			&pageDataCount=${bSearchDto.pageDataCount }
			&searchCol=${bSearchDto.searchCol }
			&searchVal=${bSearchDto.searchVal }">목록보기</a>
								</c:otherwise>
							</c:choose>

						</td>
					</tr>
				</table>
			</div>
		</div>
	</form>
	<!-- D:\JSP\work\공지사항 댓글부분.txt -->
	<%@ include file="./NoticeComment.jsp"%>	
	<%@ include file="../footer.jsp"%>