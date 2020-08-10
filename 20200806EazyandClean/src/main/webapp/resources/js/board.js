var int = 1;
function attachAddr4(id){		
	  console.log(id);
	  if (int == 2){
		  return true;
	  }
	  const str = `<td colspan="5" style="border: 1px solid lightgray">
						<textarea cols="100" rows="5" name="NOTICE_COMMENT_CONTENT" style="border:none"></textarea>
					</td>
					<td><input type="submit" value="답글등록"></td>`;
	   
	  $("#".concat(id)).append(str); // JQuery를 이용해서 juso24라는 id값을 가져와서 그곳에 append 시킨다.
	  
	  int = int + 1;
	  return true;
}

/*function loginCheck() {
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
	return true;
}


function attachAddr3(id){		
	  console.log(id);
	   
	   const str = `<td colspan="5" style="border: 1px solid lightgray">
						<textarea cols="100" rows="5" name="NOTICE_COMMENT_CONTENT" style="border:none"></textarea>
					</td>
					<td><input type="submit" value="답글등록" onclick="attachAddr4(${bcommentDtoList.NOTICE_COMMENT_NUM}></td>`;
	   
	  $("#".concat(id)).append(str); // JQuery를 이용해서 juso24라는 id값을 가져와서 그곳에 append 시킨다.
}
*/


/*$(function(){
	$("button").click(function(){
		// $.ajax()메소드 , 아작스 메서드를 쓸때 주의할점은 브레이스를 잘 다는것이다.
		$.ajax({
			url:"../text/005.json",
			type:"post",
			data:"",
			dataType:"json",
			timeout:30000,
			cache:false,
			success:function(json){
				var subjects=json.school.subject;
	
				var div=$("<div>");
				for(var i=0; i<subjects.length; i++){
					var title=subjects[i].title;
					var time=subjects[i].time;
					var teacher=subjects[i].teacher;
					var p1=$("<p>").jsp(title);
					var p2=$("<p>").jsp(time);
					var p3=$("<p>").jsp(teacher);
					alert(title);
					$("#result").append(div.append(p1).append(p2).append(p3));
				}

			},		
				error:function(xhr,textStatus, errorThrown){
				$(".console").html("<div>"+textStatus+"(HTTP-"+xhr.status+"/" + errorThrown + ")</div>");
			}
		});
	});	
});*/