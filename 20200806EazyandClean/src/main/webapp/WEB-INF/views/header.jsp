<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="image" value= "${pageContext.request.contextPath}/resource" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Easy and Clean</title>


<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />


<script src="${path}/resources/js/jquery.min.js"></script>
<script src="${path}/resources/js/jquery.dropotron.min.js"></script>
<script src="${path}/resources/js/skel.min.js"></script>
<script src="${path}/resources/js/skel-layers.min.js"></script>
<script src="${path}/resources/js/init.js"></script>

<script src="${path}/resources/js/post.js"></script>
<script src="${path}/resources/js/board.js"></script>

<script type="text/javascript" src="${path}/resources/js/member.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<script src="${path}/resources/jquery/jquery-3.3.1.min.js"></script>
<script src="http://code.jquery.com/jquery-1.10.1.js"></script>



<noscript>
	<link rel="stylesheet" href="${path}/resources/css/skel.css" />
	<link rel="stylesheet" href="${path}/resources/css/style.css" />
</noscript>
<link rel="stylesheet" href="${path}/resources/css/skel.css" />
<link rel="stylesheet" href="${path}/resources/css/style.css" />

</head>
<!--  2020.07.03 15:37 헤더 강혜성 수정  -->

<body class="homepage">
	<c:if test="${empty loginUser && empty loginAdmin}">
		<div id="header">
			<div class="container">
				<nav id="nav">
				<ul>
					<img src="${path}/resources/images/MARK.jpg">
					<br>
					<br>
					<li><a href="index">Home</a></li>
					<li><a href="login">Laundry</a>
						<ul>
							<li><a href="login">세탁 예약</a></li>
						</ul></li>
					<li><a href="listSearch">Service Menu</a>
						<ul>
							<li><a href="listSearch">공지사항 & 할인/이벤트</a></li>
							<li><a href="login">건의사항 & 불만족 신고</a></li>
						</ul></li>
					<li><a href="login.do">Mypage</a>
						<ul>
							<li><a href="login">개인정보 수정</a></li>
							<li><a href="login">나의 예약</a></li>
							<li><a href="login">장바구니</a></li>
						</ul></li>
					<li><a href="login.do">Login</a>
						<ul>
							<li><a href="login">로그인</a></li>
							<li><a href="MemberServlet?command=member_join_form">회원가입</a></li>
						</ul></li>
				</ul>
				</nav>
			</div>
		</div>
	</c:if>



	<c:if test="${!empty loginUser}">
		<%
			String id = (String) session.getAttribute("loginUser");
		if (id == null) {

			response.sendRedirect("login");
		}
		%>
		<div id="header">
			<div class="container">
				<nav id="nav">
				<ul>
					<img src="${path}/resources/images/MARK.jpg">
					<br>
					<br>
					<li><a href="index_member.jsp">Home</a></li>
					<li><a href="product_buy_0.jsp">Laundry</a>
						<ul>
							<li><a href="product_buy_0.jsp">세탁 예약</a></li>
						</ul></li>
					<li><a href="listSearch">Service Menu</a>
						<ul>
							<li><a href="listSearch">공지사항 & 할인/이벤트</a></li>
							<li><a href="board_sug.do">건의사항 & 불만족 신고</a></li>
						</ul></li>
					<li><a href="mypage.jsp">mypage</a>
						<ul>
							<li><a
								href="MemberServlet?command=member_update_form&memId=<%=id%>">개인정보
									수정</a></li>
							<li><a
								href="ReserveServlet?command=reserve_list&memId=<%=id%>">나의
									예약</a></li>
							<li><a
								href="ReserveServlet?command=reserve_bucket&memId=<%=id%>">장바구니</a></li>
						</ul></li>
					<li><a href="logout.do">Logout</a></li>
				</ul>
				</nav>
			</div>
		</div>
	</c:if>


	<c:if test="${!empty loginAdmin}">
		<%
			String id = (String) session.getAttribute("loginAdmin");
		if (id == null) {

			response.sendRedirect("login");
		}
		%>
		<div id="header">
			<div class="container">
				<nav id="nav">
				<ul>
					<img src="${path}/resources/images/MARK.jpg">
					<br>
					<br>
					<li><a href="index_admin">Home</a></li>
					<li><a href="product_buy_0.jsp">Laundry</a>
						<ul>
							<li><a href="product_buy_0.jsp">세탁 예약</a></li>
						</ul></li>
					<li><a href="listSearch">Service Menu</a>
						<ul>
							<li><a href="listSearch">공지사항 & 할인/이벤트</a></li>
							<li><a href="board_sug.do">건의사항 & 불만족 신고</a></li>
						</ul></li>
					<li><a href="mypage.jsp">mypage</a>
						<ul>
							<li><a
								href="ReserveServlet?command=admin_update_form&memId=<%=id%>">개인정보
									수정</a></li>
							<li><a
								href="ReserveServlet?command=reserve_list&memId=<%=id%>">나의
									예약</a></li>
							<li><a
								href="ReserveServlet?command=reserve_bucket&memId=<%=id%>">장바구니</a></li>
						</ul></li>
					<li><a href="admin.jsp">admin page</a>
						<ul>
							<li><a href="MemberServlet?command=admin_join_form">관리자계정추가</a></li>
							<li><a href="memberListSearchAll.do">회원 관리</a></li>
							<li><a href="reserveListSearchAll.do">예약 관리</a></li>
						</ul></li>
					<li><a href="logout.do">Logout</a></li>
				</ul>
				</nav>
			</div>
		</div>
	</c:if>