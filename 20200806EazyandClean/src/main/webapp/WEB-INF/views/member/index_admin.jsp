<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../header.jsp"%>
<body class="homepage">
	<!-- Banner -->
	<div id="banner">
		<div class="container">
			<section>
				<header class="major">

					<h2>Easy and Clean에 오신걸 환영합니다!</h2>
					<hr>
					<span class="byline">우리 기업은 바쁜 현대사회에서 고객님의 세탁에 대한 불편을
						해소해드립니다. <br> 지금 가입하시고 당일수거, 신속세탁 서비스를 받아보세요
					</span>
				</header>
				<ul id="button-ul">

					<li><a href="admin_mem.jsp" class="button-index-sign"
						target="_blank"> 회원관리</a></li>

					<li><a href="admin_res.jsp" class="button-index-login"
						target="_blank"> 예약관리</a></li>


				</ul>
				<hr>
			</section>
		</div>
	</div>
	<!-- Featured -->
	<div class="wrapper style2">
		<section class="container">
			<header class="major">

				<h2>Easy and Clean 서비스</h2>
				<!-- 유튜브에서 동영상 링크걸기 <iframe width="560" height="315" src="https://www.youtube.com/embed/Ysu_zcsLxvc" 
					frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; 
					picture-in-picture" allowfullscreen></iframe> -->
				<!-- 비디오 링크<video src="media/index_video.mp4" autoplay muted loop width="375"></video> -->

				<span class="byline"></span>
			</header>
			<div class="row no-collapse-1">
				<section class="4u">

					<a href="product.html" class="image feature"><img
						src="images/wash.jpg" alt=""></a>
					<p></p>
					<p>맡겨주신 세탁물의 종류와 소재에 맞게 전문가에 의한 세탁 서비스를 제공합니다</p>
				</section>
				<section class="4u">
					<a href="product_dry_1.html" class="image feature"><img
						src="images/dry.JPG" alt=""></a>
					<p>easy and clean은 무공해, 무독성 탄산세탁 드라이크리닝 방식으로 차별화된 서비스를 제공합니다</p>
				</section>
				<section class="4u">
					<a href="product_impo_wash" class="image feature"><img
						src="images/wash_info.JPG" alt=""></a>
					<p>easy and clean의 종류별 소재별 서비스 가격과 세탁과정, 취급 품목을 확인하세요</p>
				</section>

			</div>
		</section>
	</div>
	<div id="main" class="wrapper style1">
		<section class="container">
			<header class="major">
				<h2>EASY AND CLEAN 서비스 가능지역</h2>
				<p>ㅇ수원시 전체 및 화성, 오산, 의왕 일부 지역 (서비스 불가 지역에서 신청시 임의 취소될 수 있습니다.)</p>

			</header>
			<div id="map"
				style="width: 35em; height: 26em; align-content: center; margin: 0 auto;"></div>
			<script type="text/javascript"
				src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1cd65806bf4bc53c11dfb69c654a582b"></script>
			<script type="text/javascript"
				src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=services,clusterer,drawing"></script>
			<script>
				var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
				mapOption = {
					center : new kakao.maps.LatLng(37.26790415020807,
							127.00063699000602), // 지도의 중심좌표
					level : 9
				// 지도의 확대 레벨
				};
				var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

				// 지도에 표시할 원을 생성합니다
				var circle = new kakao.maps.Circle({
					center : new kakao.maps.LatLng(37.26790415020807,
							127.00063699000602), // 원의 중심좌표 입니다 
					radius : 10000, // 미터 단위의 원의 반지름입니다 
					strokeWeight : 1, // 선의 두께입니다 
					strokeColor : '#75B8FA', // 선의 색깔입니다
					strokeOpacity : 1, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
					strokeStyle : 'solid', // 선의 스타일 입니다
					fillColor : 'lightblue;', // 채우기 색깔입니다
					fillOpacity : 0.7
				// 채우기 불투명도 입니다   
				});

				// 지도에 원을 표시합니다 
				circle.setMap(map);

				// 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
				var mapTypeControl = new kakao.maps.MapTypeControl();

				// 지도 타입 컨트롤을 지도에 표시합니다
				map.addControl(mapTypeControl,
						kakao.maps.ControlPosition.TOPRIGHT);

				function getInfo() {
					// 지도의 현재 중심좌표를 얻어옵니다 
					var center = map.getCenter();

					// 지도의 현재 레벨을 얻어옵니다
					var level = map.getLevel();

					// 지도타입을 얻어옵니다
					var mapTypeId = map.getMapTypeId();

					// 지도의 현재 영역을 얻어옵니다 
					var bounds = map.getBounds();

					// 영역의 남서쪽 좌표를 얻어옵니다 
					var swLatLng = bounds.getSouthWest();

					// 영역의 북동쪽 좌표를 얻어옵니다 
					var neLatLng = bounds.getNorthEast();

					// 영역정보를 문자열로 얻어옵니다. ((남,서), (북,동)) 형식입니다
					var boundsStr = bounds.toString();

					var message = '지도 중심좌표는 위도 ' + center.getLat() + ', <br>';
					message += '경도 ' + center.getLng() + ' 이고 <br>';
					message += '지도 레벨은 ' + level + ' 입니다 <br> <br>';
					message += '지도 타입은 ' + mapTypeId + ' 이고 <br> ';
					message += '지도의 남서쪽 좌표는 ' + swLatLng.getLat() + ', '
							+ swLatLng.getLng() + ' 이고 <br>';
					message += '북동쪽 좌표는 ' + neLatLng.getLat() + ', '
							+ neLatLng.getLng() + ' 입니다';

					// 개발자도구를 통해 직접 message 내용을 확인해 보세요.
					// ex) console.log(message);
				}
			</script>

		</section>
	</div>


	<!-- Main -->
	<div id="main" class="wrapper style1">
		<section class="container">
			<header class="major">
				<h2>EASY AND CLEAN의 운영 방향</h2>
			</header>
			<div class="row">

				<!-- Content -->
				<div class="6u">
					<section>
						<ul class="style">
							<li></li>
							<li><span class="fa fa-shopping-cart"></span>
								<h3>대면없는 세탁 수거 및 배달</h3> <span>원하신 곳에서 수거 및 배달로 고객과 대면없는
									서비스 지원</span></li>
							<li><span class="fa fa-cogs"></span>
								<h3>전문적인 세탁 시스템 구축</h3> <span>세탁 시스템을 정밀화시켜 고객님이 경험해보지
									못하신 섬세한 세탁 제공</span></li>
						</ul>
					</section>
				</div>

				<div class="6u">
					<section>
						<ul class="style">
							<li></li>
							<li><span class="fa fa-users"></span>
								<h3>적극적 피드백 수용</h3> <span>고객 중심의 서비스를 중심으로 피드백에 대한 적극적인
									수용</span></li>
							<li><span class="fa fa-krw"></span>
								<h3>합리적인 가격</h3> <span>대리점 운영의 거품을 빼고 세탁 시스템을 단일화 시켜 합리적인
									가격 제공</span></li>
						</ul>
					</section>
				</div>
		</section>
	</div>

	<%@ include file="../footer.jsp"%>