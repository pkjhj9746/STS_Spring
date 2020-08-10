<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta http-equiv="content-type" content="text/html; charset=utf-8" />


<c:if test="${empty loginUser && empty loginAdmin}">
	<!-- Footer -->
	<div id="footer">
		<div class="footer-mid">
			<ul>
				<li><a href="#">개인정보취급방침&nbsp;|&nbsp;</a> <span><a
						href="#">스팸관리정책&nbsp;|&nbsp;</a></span> <span><a href="#">이용약관&nbsp;|&nbsp;</a></span>
					<span><a href="#">법적고지</a></span></li>
				<li>상호&nbsp;:&nbsp;(주)이지앤클린&nbsp;|&nbsp;주소&nbsp;:&nbsp;경기 수원시 팔달구 덕영대로 905 아이메카 상가 7층 702호&nbsp;|&nbsp;대표전화&nbsp;:&nbsp;1234-5674</li>
				<li>사업자번호&nbsp;:&nbsp;123-45-6789&nbsp;&nbsp;|&nbsp;<span>이메일&nbsp;:&nbsp;easyandcleanadmin@gamil.or.kr</span>
				</li>
				<li class="Copyright">Copyright ⓒ esay and clean All rights
					reserved</li>
			</ul>
		</div>
	</div>
</c:if>



<c:if test="${(!empty loginUser) && empty loginAdmin}">
		<!-- Footer -->
	<div id="footer">
		<div class="footer-mid">
			<ul>
				<li><a href="#">개인정보취급방침&nbsp;|&nbsp;</a> <span><a
						href="#">스팸관리정책&nbsp;|&nbsp;</a></span> <span><a href="#">이용약관&nbsp;|&nbsp;</a></span>
					<span><a href="#">법적고지</a></span></li>
				<li>상호&nbsp;:&nbsp;(주)이지앤클린&nbsp;|&nbsp;주소&nbsp;:&nbsp;경기 수원시 팔달구 덕영대로 905 아이메카 상가 7층 702호&nbsp;|&nbsp;대표전화&nbsp;:&nbsp;1234-5674</li>
				<li>사업자번호&nbsp;:&nbsp;123-45-6789&nbsp;&nbsp;|&nbsp;<span>이메일&nbsp;:&nbsp;easyandcleanadmin@gamil.or.kr</span>
				</li>
				<li class="Copyright">Copyright ⓒ esay and clean All rights
					reserved</li>
			</ul>
		</div>
	</div>
</c:if>



<c:if test="${!empty loginAdmin && empty loginUser}">
		<!-- Footer -->
	<div id="footer">
		<div class="footer-mid">
			<ul>
				<li><a href="#">개인정보취급방침&nbsp;|&nbsp;</a> <span><a
						href="#">스팸관리정책&nbsp;|&nbsp;</a></span> <span><a href="#">이용약관&nbsp;|&nbsp;</a></span>
					<span><a href="#">법적고지</a></span></li>
				<li>상호&nbsp;:&nbsp;(주)이지앤클린&nbsp;|&nbsp;주소&nbsp;:&nbsp;경기 수원시 팔달구 덕영대로 905 아이메카 상가 7층 702호&nbsp;|&nbsp;대표전화&nbsp;:&nbsp;1234-5674</li>
				<li>사업자번호&nbsp;:&nbsp;123-45-6789&nbsp;&nbsp;|&nbsp;<span>이메일&nbsp;:&nbsp;easyandcleanadmin@gamil.or.kr</span>
				</li>
				<li class="Copyright">Copyright ⓒ esay and clean All rights
					reserved</li>
			</ul>
		</div>
	</div>
</c:if>

<!-- 2020.07.03 15:40 풋쳐 강혜성 수정 -->
</body>
</html>