

function loginCheck() {
	if (document.frm.memId.value.length == 0) {
		alert("아이디를 써주세요");
		frm.memId.focus();
		return false;
	}
	if (document.frm.memPwd.value == "") {
		alert("암호는 반드시 입력해야 합니다.");
		frm.memPwd.focus();
		return false;
	}
}

function productCheck() {
	if (document.frm.product_5.value != 0) {
		var url ="Productsuccess.jsp";
		window.screen.width;
		// 좌우 크기 반환 Ex) 1920

		window.screen.height;
		// 상하 크기 반환, Ex) 1080

		var popupWidth = 200;
		var popupHeight = 100;

		var popupX = (window.screen.width / 2) - (popupWidth / 2);
		// 만들 팝업창 width 크기의 1/2 만큼 보정값으로 빼주었음

		var popupY= (window.screen.height / 2) - (popupHeight / 2);
		// 만들 팝업창 height 크기의 1/2 만큼 보정값으로 빼주었음

		window.open(url, '', 'status=no, height=' + popupHeight  + ', width=' + popupWidth  + ', left='+ popupX + ', top='+ popupY);

	}
}


function idCheck() {
	if (document.frm.memId.value == "") {
		alert('아이디를 입력하여 주십시오.');
		document.frm.memId.focus();
		return;
	}
	var url = "idCheck.do?memId="+document.frm.memId.value;

	window.screen.width;
	// 좌우 크기 반환 Ex) 1920

	window.screen.height;
	// 상하 크기 반환, Ex) 1080

	var popupWidth = 500;
	var popupHeight = 250;

	var popupX = (window.screen.width / 2) - (popupWidth / 2);
	// 만들 팝업창 width 크기의 1/2 만큼 보정값으로 빼주었음

	var popupY= (window.screen.height / 2) - (popupHeight / 2);
	// 만들 팝업창 height 크기의 1/2 만큼 보정값으로 빼주었음

	window.open(url, '', 'status=no, height=' + popupHeight  + ', width=' + popupWidth  + ', left='+ popupX + ', top='+ popupY);
}

function modCheck() {
	if (document.frm.memName.value.length == 0) {
		alert("이름을 써주세요.");
		frm.memName.focus();
		return false;
	}
	if (document.frm.memPwd.value == "") {
		alert("암호는 반드시 입력해야 합니다.");
		frm.memPwd.focus();
		return false;
	}
	if (document.frm.memPwd.value != document.frm.memPwd_check.value) {
		alert("암호가 일치하지 않습니다.");
		frm.memPwd.focus();
		return false;
	}

	return true;
}


function idok(memId){
	opener.frm.memId.value = document.frm.memId.value;
	opener.frm.reid.value = document.frm.memId.value;
	self.close();
}



function bucketSuccess(){
	alert('장바구니에 담겼습니다.');	
	document.frm.action("ReserveServlet?command=reserve_insert");
	document.frm.submit();

}


function inbucket() {
	var url ="ProductServlet?command=product_list";
	window.screen.width;
	// 좌우 크기 반환 Ex) 1920

	window.screen.height;
	// 상하 크기 반환, Ex) 1080

	var popupWidth = 1000;
	var popupHeight = 600;

	var popupX = (window.screen.width / 2) - (popupWidth / 2);
	// 만들 팝업창 width 크기의 1/2 만큼 보정값으로 빼주었음

	var popupY= (window.screen.height / 2) - (popupHeight / 2);
	// 만들 팝업창 height 크기의 1/2 만큼 보정값으로 빼주었음

	window.open(url, '', 'status=no, height=' + popupHeight  + ', width=' + popupWidth  + ', left='+ popupX + ', top='+ popupY);
}




function joinCheck() {
	if (document.frm.memName.value.length == 0) {
		alert("이름을 써주세요.");
		frm.memName.focus();
		return false;
	}
	if (document.frm.memId.value.length == 0) {
		alert("아이디를 써주세요");
		frm.memId.focus();
		return false;
	}
	if (document.frm.memId.value.length < 4) {
		alert("아이디는 4글자이상이어야 합니다.");
		frm.memId.focus();
		return false;
	}
	if (document.frm.memPwd.value == "") {
		alert("암호는 반드시 입력해야 합니다.");
		frm.memPwd.focus();
		return false;
	}
	if (document.frm.memPwd.value != document.frm.memPwd_check.value) {
		alert("암호가 일치하지 않습니다.");
		frm.memPwd.focus();
		return false;
	}
	if (document.frm.reid.value.length == 0) {
		alert("중복 체크를 하지 않았습니다.");
		frm.memId.focus();
		return false;
	}

	return true;
}



//0706 탭 메뉴 활성화 
$(document).ready(function(){

	$('ul.tabs li').click(function(){
		var tab_id = $(this).attr('data-tab');

		$('ul.tabs li').removeClass('current');
		$('.tab-content').removeClass('current');

		$(this).addClass('current');
		$("#"+tab_id).addClass('current');
	})

})


//0713 게시글 삭제시 비밀번호 확인
function passCheck() {
	if (document.frm.pass.value.length == 0) {
		alert("비밀번호를 입력하세요.");
		return false;
	}
	return true;
}


//0714 이미 결제 진행중인 상품 팝업
function reserved(){

	if(document.frm.resData.value.equlas("배송중")){
		var url ="reserved.jsp";
		window.screen.width;
		// 좌우 크기 반환 Ex) 1920

		window.screen.height;
		// 상하 크기 반환, Ex) 1080

		var popupWidth = 500;
		var popupHeight = 250;

		var popupX = (window.screen.width / 2) - (popupWidth / 2);
		// 만들 팝업창 width 크기의 1/2 만큼 보정값으로 빼주었음

		var popupY= (window.screen.height / 2) - (popupHeight / 2);
		// 만들 팝업창 height 크기의 1/2 만큼 보정값으로 빼주었음

		window.open(url, '', 'status=no, height=' + popupHeight  + ', width=' + popupWidth  + ', left='+ popupX + ', top='+ popupY);
		
		return false;

	}else if(document.frm.resData.equlas("배송완료")){
		var url ="reserved.jsp";
		window.screen.width;
		// 좌우 크기 반환 Ex) 1920

		window.screen.height;
		// 상하 크기 반환, Ex) 1080

		var popupWidth = 500;
		var popupHeight = 250;

		var popupX = (window.screen.width / 2) - (popupWidth / 2);
		// 만들 팝업창 width 크기의 1/2 만큼 보정값으로 빼주었음

		var popupY= (window.screen.height / 2) - (popupHeight / 2);
		// 만들 팝업창 height 크기의 1/2 만큼 보정값으로 빼주었음

		window.open(url, '', 'status=no, height=' + popupHeight  + ', width=' + popupWidth  + ', left='+ popupX + ', top='+ popupY);
		
		return false;
	}
	
	return true;	
}

//0716 개인정보수정 완료 팝업
function mypage_mod_pop(){
	var url ="mypage_mod_pop.jsp";
	window.screen.width;
	// 좌우 크기 반환 Ex) 1920

	window.screen.height;
	// 상하 크기 반환, Ex) 1080

	var popupWidth = 500;
	var popupHeight = 180;

	var popupX = (window.screen.width / 2) - (popupWidth / 2);
	// 만들 팝업창 width 크기의 1/2 만큼 보정값으로 빼주었음

	var popupY= (window.screen.height / 2) - (popupHeight / 2);
	// 만들 팝업창 height 크기의 1/2 만큼 보정값으로 빼주었음

	window.open(url, '', 'status=no, height=' + popupHeight  + ', width=' + popupWidth  + ', left='+ popupX + ', top='+ popupY);
}

function bucketRes() {
	var url ="bucketRes.jsp";
	window.screen.width;
	// 좌우 크기 반환 Ex) 1920

	window.screen.height;
	// 상하 크기 반환, Ex) 1080

	var popupWidth = 500;
	var popupHeight = 180;

	var popupX = (window.screen.width / 2) - (popupWidth / 2);
	// 만들 팝업창 width 크기의 1/2 만큼 보정값으로 빼주었음

	var popupY= (window.screen.height / 2) - (popupHeight / 2);
	// 만들 팝업창 height 크기의 1/2 만큼 보정값으로 빼주었음

	window.open(url, '', 'status=no, height=' + popupHeight  + ', width=' + popupWidth  + ', left='+ popupX + ', top='+ popupY);

}

function detail() {
	var url ="mypage_res_detail.jsp";
	
	window.screen.width;
	// 좌우 크기 반환 Ex) 1920

	window.screen.height;
	// 상하 크기 반환, Ex) 1080

	var popupWidth = 500;
	var popupHeight = 180;

	var popupX = (window.screen.width / 2) - (popupWidth / 2);
	// 만들 팝업창 width 크기의 1/2 만큼 보정값으로 빼주었음

	var popupY= (window.screen.height / 2) - (popupHeight / 2);
	// 만들 팝업창 height 크기의 1/2 만큼 보정값으로 빼주었음

	window.open(url, '', 'status=no, height=' + popupHeight  + ', width=' + popupWidth  + ', left='+ popupX + ', top='+ popupY);
	
	return true;

}