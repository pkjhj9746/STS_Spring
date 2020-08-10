<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page
	import="javax.xml.parsers.*, org.w3c.dom.*, java.net.URL, org.xml.sax.InputSource, javax.xml.xpath.*"%>

<!-- 댓글 다는곳   -->
<form name="frm" method="post" action="BCommentInsert.do">
	<input type="hidden" name="page" value="${bSearchDto.currentPageNum}" />
	<input type="hidden" name="pageDataCount"
		value="${bSearchDto.pageDataCount}" />
	<table id="CommentTable">
		<input type="hidden" name="comment_num">
		<input type="hidden" name="bId" value="${dto.bId}" readonly>
		<tr id="tabcontent_head">
			<td style="border: 1px solid lightgray"><img
				src="/web-project/project_hp/image/personvec1.png"></td>
			<td style="border: 1px solid lightgray"><c:if
					test="${!empty loginUser}">
					<input type="hidden" name="NOTICE_COMMENT_ID" value=${loginUser }>${loginUser }
					</c:if> <c:if test="${!empty loginAdmin}">
					<input type="hidden" name="NOTICE_COMMENT_ID" value=${loginAdmin }>${loginAdmin }
					</c:if> <c:if test="${(loginAdmin==null)&&(loginUser==null)}">
					<input type="hidden" name="NOTICE_COMMENT_ID" value="guest">guest
					</c:if> <%-- 				<input type="hidden" name="NOTICE_COMMENT_ID" value=${loginUser } >${loginUser }	 --%>

			</td>
			<td style="border: 1px solid lightgray">날짜</td>
		</tr>
		<tr>
			<td colspan="5" style="border: 1px solid lightgray"><textarea
					cols="100" rows="5" name="NOTICE_COMMENT_CONTENT"
					style="border: none"></textarea></td>
		</tr>
		<tr>
			<td><input type="submit" value="답글등록"></td>
		</tr>
	</table>
</form>
<!-- 댓글 보여주는 곳   -->
<c:choose>
	<c:when test="${empty bcommentDtoList}">
		<p>댓글이 없습니다</p>
	</c:when>
	<c:otherwise>
		<div>
			<c:forEach items="${bcommentDtoList}" var="bcommentDtoList">

				<table id="tabcontent">
					<tr id ="comIndent" >				
						<c:forEach begin="1" end="${bcommentDtoList.NOTICE_COMMENT_INDENT}">										
							<td rowspan="2"> &nbsp; </td>
						</c:forEach>
					
						
						<td id ="comContent">${bcommentDtoList.NOTICE_COMMENT_ID} &nbsp; :  &nbsp;${bcommentDtoList.NOTICE_COMMENT_CONTENT}</td>
				
					</tr>
					<tr id="tabcontent_head">
<%-- 						<td style="board:100px #000 solid;">
						<c:forEach begin="1" end="${bcommentDtoList.NOTICE_COMMENT_INDENT}">										
							→
						</c:forEach>
						</td> --%>
						<td><img src="/web-project/project_hp/image/personvec1.png"> &nbsp;
						<%-- 	${bcommentDtoList.NOTICE_COMMENT_ID} &nbsp; --%>
							 ${bcommentDtoList.NOTICE_COMMENT_DATE} &nbsp;
							<input id="tabcontent_btn" type="button" value="답글달기"
							onclick="attachAddr4(${bcommentDtoList.NOTICE_COMMENT_NUM});">
						</td>
						<%-- <td>${bcommentDtoList.NOTICE_COMMENT_ID} &nbsp;
							 ${bcommentDtoList.NOTICE_COMMENT_DATE} &nbsp;
						<input id="tabcontent_btn" type="button" value="답글달기"
							onclick="attachAddr4(${bcommentDtoList.NOTICE_COMMENT_NUM});"></td> --%>
						<%-- <td>${bcommentDtoList.NOTICE_COMMENT_DATE}</td>
						<td><input id="tabcontent_btn" type="button" value="답글달기"
							onclick="attachAddr4(${bcommentDtoList.NOTICE_COMMENT_NUM});">
						</td> --%>
					</tr>		
							
			<%-- 	<tr id="tabcontent_btn">
						<td><input id="button" type="button" value="답글달기"
							onclick="attachAddr4(${bcommentDtoList.NOTICE_COMMENT_NUM});">
						</td>
					</tr> --%>
				</table>


				<form name="frm" method="post" action="BCommentReplyInsert.do">
					<input type="hidden" name="page" value="${bSearchDto.currentPageNum}" />
					<input type="hidden" name="pageDataCount"
						value="${bSearchDto.pageDataCount}" />
						
					<input type="hidden" value="${bcommentDtoList.NOTICE_COMMENT_GROUPID}" name = "NOTICE_COMMENT_GROUPID"/>
					<input type="hidden" value="${bcommentDtoList.NOTICE_COMMENT_STEP}" name = "NOTICE_COMMENT_STEP"/>
					<input type="hidden" value="${bcommentDtoList.NOTICE_COMMENT_INDENT}" name = "NOTICE_COMMENT_INDENT"/>
					<!--<input  type = "hidden" id="forAdd_num" value="${bcommentDtoList.NOTICE_COMMENT_NUM}"/> -->
					<input type="hidden" name="comment_num"> <input
						type="hidden" name="bId" value="${dto.bId}" readonly>

					<table id="CommentTable">



						<tr id="tabcontent_head" style="border: none;">
							<td>
								<!-- <img src="/web-project/project_hp/image/personvec1.png"> -->
							</td>

							<td><c:if test="${!empty loginUser}">
									<input type="hidden" name="NOTICE_COMMENT_ID"
										value=${loginUser }>
								</c:if> <c:if test="${!empty loginAdmin}">
									<input type="hidden" name="NOTICE_COMMENT_ID"
										value=${loginAdmin }>
								</c:if> <c:if test="${(loginAdmin==null)&&(loginUser==null)}">
									<input type="hidden" name="NOTICE_COMMENT_ID" value="guest">
								</c:if> <%-- 				<input type="hidden" name="NOTICE_COMMENT_ID" value=${loginUser } >${loginUser }	 --%>

							</td>
							<td><input type="hidden" style="border: 1px solid lightgray"></td>
						</tr>
						<tr id="${bcommentDtoList.NOTICE_COMMENT_NUM}">



							<!--     <td  colspan="5" style="border: 1px solid lightgray">
						<textarea cols="100" rows="5" name="NOTICE_COMMENT_CONTENT" style="border:none"></textarea>
					</td>
					<td><input type="submit" value="답글등록"></td>    
 				-->
						</tr>

					</table>
				</form>
			</c:forEach>
			<table style="margin: 0 auto">
				<tr>
					<td colspan="5"><a
						href="bContentCommand.do?bId=${dto.bId }
									&pageCo=${bComPageDto.firstCoPageNum }
									&pageCoDataCount=${bComPageDto.pageCoDataCount }
									&page=${bSearchDto.currentPageNum }
									&searchCol=${bSearchDto.searchCol }
									&searchVal=${bSearchDto.searchVal }
									&pageDataCount=${bSearchDto.pageDataCount }">◀◀맨앞으로</a>&nbsp;
						<a
						href="bContentCommand.do?bId=${dto.bId }
									&pageCo=${bComPageDto.prevCoPageNum }
									&pageCoDataCount=${bComPageDto.pageCoDataCount }
									&page=${bSearchDto.currentPageNum }
									&searchCol=${bSearchDto.searchCol }
									&searchVal=${bSearchDto.searchVal }
									&pageDataCount=${bSearchDto.pageDataCount }">◀앞으로</a>&nbsp;

						<%-- ${bComPageDto.startCoPageNum }&nbsp; 
									${bComPageDto.endCoPageNum } --%> <c:forEach var="i"
							begin="${bComPageDto.startCoPageNum }"
							end="${bComPageDto.endCoPageNum }" step="1">

							<c:choose>
								<c:when test="${i eq bComPageDto.currentCoPageNum }">
									<a style="color: blue;"
										href="bContentCommand2.do?bId=${dto.bId }
										&pageCo=${i }
										&pageCoDataCount=${bComPageDto.pageCoDataCount }
										&page=${bSearchDto.currentPageNum }
										&searchCol=${bSearchDto.searchCol }
										&searchVal=${bSearchDto.searchVal }
										&pageDataCount=${bSearchDto.pageDataCount }">${i }
									</a>&nbsp; 
								</c:when>
								<c:otherwise>
									<a
										href="bContentCommand2.do?bId=${dto.bId }
										&pageCo=${i }
										&pageCoDataCount=${bComPageDto.pageCoDataCount }
										&page=${bSearchDto.currentPageNum }
										&searchCol=${bSearchDto.searchCol }
										&searchVal=${bSearchDto.searchVal }
										&pageDataCount=${bSearchDto.pageDataCount }">${i }
									</a>&nbsp;
								</c:otherwise>
							</c:choose>

						</c:forEach> <a
						href="bContentCommand.do?bId=${dto.bId }
									&pageCo=${bComPageDto.nextCoPageNum }
									&pageCoDataCount=${bComPageDto.pageCoDataCount }
									&page=${bSearchDto.currentPageNum }
									&searchCol=${bSearchDto.searchCol }
									&searchVal=${bSearchDto.searchVal }
									&pageDataCount=${bSearchDto.pageDataCount }">뒤로▶</a>&nbsp;
						<a
						href="bContentCommand.do?bId=${dto.bId }
									&pageCo=${bComPageDto.lastCoPageNum }
									&pageCoDataCount=${bComPageDto.pageCoDataCount }
									&page=${bSearchDto.currentPageNum }
									&searchCol=${bSearchDto.searchCol }
									&searchVal=${bSearchDto.searchVal }
									&pageDataCount=${bSearchDto.pageDataCount }">맨뒤로▶▶</a>
					</td>
				</tr>
			</table>

		</div>
	</c:otherwise>
</c:choose>

