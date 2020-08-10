<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<!DOCTYPE HTML>
<html>

<head>
<title>회원가입</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
<script src="/js/jquery.min.js"></script>
<script src="/js/jquery.dropotron.min.js"></script>
<script src="/js/skel.min.js"></script>
<script src="/js/skel-layers.min.js"></script>
<script src="/js/init.js"></script>
<script src="/js/post.js"></script>
<script src="/js/member.js"></script>


<link rel="stylesheet" href="/css/skel.css" />
<link rel="stylesheet" href="/css/style.css" />

<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
</head>

<body class="no-sidebar">
	<!-- Main -->

	<div id="main" class="wrapper style1">
		<div class="container">
			<section>
				<header class="major">
					<h2></h2>
					<span class="byline"></span>
				</header>
				<center>
					<h1 id="board-text-1">EASY AND CLEAN</h1>
									<p>${message}</p>
				</center>

				<br> <br>
				<form action="login.do" method="post" name="frm">
					<fieldset>
						<td>
							<center>
								<input type="text" name="memId" value="${memid}" id="user_id"
									placeholder="아이디" style="width: 500px; height: 50px">
							</center> <br>
							<center>
								<input type="password" name="memPwd" id="user_pw"
									placeholder="패스워드" style="width: 500px; height: 50px">

							</center>
					</fieldset>
					<fieldset>
						<center>
							<input type="submit" class="login-btn-1" value="로그인"
								onclick="return loginCheck()">
						</center>
					</fieldset>
				</form>

			</section>
		</div>
	</div>

	<%@ include file="../footer.jsp"%>
</body>

</html>