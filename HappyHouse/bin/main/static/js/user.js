$("document").ready(function() {

	// register valid check
	// manually check
	$("#userName").blur(function() {
		if (validateUserName($(this))) {
			$(this).removeClass("is-invalid").addClass('is-valid');
		} else {
			$(this).removeClass("is-valid").addClass('is-invalid');
		}
	});

	$("#userPassword").blur(function() {
		if (validatePassword($(this))) {
			$(this).removeClass("is-invalid").addClass('is-valid');
		} else {
			$(this).removeClass("is-valid").addClass('is-invalid');
		}
	});

	$("#userPassword2").blur(function() {
		if (validatePassword2($(this))) {
			$(this).removeClass("is-invalid").addClass('is-valid');
		} else {
			$(this).removeClass("is-valid").addClass('is-invalid');
		}
	});

	$("#userEmail").blur(function() {
		if (validateEmail($(this))) {
			$(this).removeClass("is-invalid").addClass('is-valid');
		} else {
			$(this).removeClass("is-valid").addClass('is-invalid');
		}
	});

	$(':input').focus(function() {
		$(this).removeClass('is-valid is-invalid');
	});

	// register btn pressed
	$("#joinBtn").click(function() {
		if ($("form").find(".is-invalid").length > 0) {
			alert("입력이 올바르지 않습니다.")
		} else {
			register();
		}
	});

	// login btn pressed
	$("#loginBtn").click(function() {
		if (validate()) {
			login();
		} else {
			alert("회원정보가 없습니다.");
		}
	});

	// info btn pressed
	$("#info").click(function() {
		loadInfo();
	});

	// info window close
	$("#confirmBtn").click(function() {
		$('#info-modal').modal("hide");
		$('.modal-backdrop').remove();
	});

	// info edit btn
	$("#editBtn").click(function() {
		editInfo();
	});

	// password find btn pressed -> close login window
	$("#login_findBtn").click(function() {
		$('#login-modal').modal("hide");
		$('.modal-backdrop').remove();
	});

	// find btn pressed
	$("#find_findBtn").click(function() {
		findPassword();
		$('#find-modal').modal("hide");
		$('.modal-backdrop').remove();
	});

	// secession btn pressed
	$("#secessionBtn").click(function() {
		secession();
		$('#info-modal').modal("hide");
		$('.modal-backdrop').remove();
	});

	$("#area_confirmBtn").click(function() {
		alert($("#inputDong").val() + " 관심 지역이 등록되었습니다.");
	});

	$("#area_closeBtn").click(function() {
		$('#area-modal').modal("hide");
		$('.modal-backdrop').remove();
	});

	$("#logout").click(function() {

		logout();
		alert("로그아웃 되었습니다.");

		$("#logout").css("display", "none");
		$("#info").css("display", "none");
		$("#navItem3").css("display", "none");
		$("#navItem4").css("display", "none");
		$("#navItem5").css("display", "none");
		$("#signUp").css("display", "inline-block");
		$("#login").css("display", "inline-block");

	});

	//login_auto();
})

function validate() {
	var isUserEmailValid = false;
	var isUserPasswordValid = false;

	var userEmailValue = $("#loginEmail").val();
	var userEmailLength = userEmailValue.length;

	if (userEmailLength > 0) {
		isUserEmailValid = true;
	}

	var userPasswordValue = $("#loginPassword").val();
	var userPasswordLength = userPasswordValue.length;

	if (userPasswordLength > 0) {
		isUserPasswordValid = true;
	}

	if (isUserEmailValid && isUserPasswordValid) {
		return true;
	} else {
		return false;
	}
}

// pure javascript ajax
var httpRequest;
var httpRequestAuto;
var hostIndex = location.href.indexOf(location.host) + location.host.length;
var contextPath = location.href.substring(hostIndex, location.href.indexOf('/',
		hostIndex + 1));

function login_auto() {
	httpRequestAuto = new XMLHttpRequest();
	httpRequestAuto.onreadystatechange = loginAutoResult;

	httpRequestAuto.open('POST', contextPath + '/login', true);
	httpRequestAuto.setRequestHeader('Content-Type',
			'application/x-www-form-urlencoded');
	httpRequestAuto.send("loginAuto=true");
}

function login() {

	let jsonData = JSON.stringify({
		userEmail : $("#loginEmail").val(),
		userPassword : $("#loginPassword").val()
	});

	$.ajax({
		type : 'post',
		url : contextPath + '/login',
		dataType : 'json',
		data : jsonData,
		contentType : "application/json; charset=UTF-8",
		success : function(data, userDto) { // alertify or another welcome
			// page 이동
			// console.log(data);
			// console.log(data.result);

				// console.log(userDto);
				console.log("login Success");
				$("#signUp").css("display", "none");
				$("#login").css("display", "none");
				$("#logout").css("display", "inline-block");
				$("#info").css("display", "inline-block");
				$("#navItem3").css("display", "inline-block");
				$("#navItem4").css("display", "inline-block");
				$("#navItem5").css("display", "inline-block");
				$("#login-modal").modal('hide');
			
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert("서버에 문제가 발생했습니다.");
		}
	});

}

function loginAutoResult() {
	if (httpRequestAuto.readyState === XMLHttpRequest.DONE) {
		if (httpRequestAuto.status === 200) {
			// Before Learn JSON
			// var result = httpRequestAuto.responseText;

			// After Learn JSON
			var dataAuto = JSON.parse(httpRequestAuto.responseText);
			if (dataAuto.result == "success") {
				console.log("Autologin Success");
				$("#signUp").css("display", "none");
				$("#login").css("display", "none");
				$("#logout").css("display", "inline-block");
				$("#info").css("display", "inline-block");
				$("#navItem3").css("display", "inline-block");
				$("#navItem4").css("display", "inline-block");
				$("#navItem5").css("display", "inline-block");
			} else if (dataAuto.result == "fail") {
				console.log("Autologin Fail");
			}
		} else {
			alert("서버에 문제가 발생했습니다.");
		}
	}
}

function logout() {
	
	$.ajax({
		type : 'post',
		url : contextPath + '/logout',
		success : function(data) { // alertify or another welcome
			//location.reload(true);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			//location.reload(true);
		}
	});
	
//	httpRequest = new XMLHttpRequest();
//
//	httpRequest.open('POST', contextPath + '/login', true);
//	httpRequest.setRequestHeader('Content-Type',
//			'application/x-www-form-urlencoded');
//	httpRequest.send("logout=true");
//	location.reload(true);
}

function validateEmail(Email) {
	// ^ 시작일치, $ 끝 일치
	// {2, 3} 2개 ~ 3개
	// * 0회 이상, + 1회 이상
	// [-_.] - 또는 _ 또는 .
	// ? 없거나 1회
	let regexp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	if (regexp.test(Email))
		return true;
	else
		return false;
}

function validateUserName(Name) {
	if (Name.length >= 4)
		return true;
	else
		return false;
}

function validatePassword(Password) {
	let userPasswordValue = Password;

	var patternEngAtListOne = new RegExp(/[a-zA-Z]+/);// + for at least one
	var patternNumAtListOne = new RegExp(/[0-9]+/);// + for at least one

	if (patternEngAtListOne.test(userPasswordValue)
			&& patternNumAtListOne.test(userPasswordValue)
			&& userPasswordValue.length >= 6) {
		return true;
	} else
		return false;
}

function validatePassword2(Password2) {
	if (Password2 == $("#userPassword").val())
		return true;
	else
		return false;
}

function register() {
	$.ajax({
		type : 'post',
		url : contextPath + '/user',
		dataType : 'json',
		data : {
			register : "true",
			userName : $("#userName").val(),
			userEmail : $("#userEmail").val(),
			userPassword : $("#userPassword").val()
		},
		success : function(data, status, xhr) { // alertify or another welcome
			// page 이동
			if(data != null){
				autoLogin(data);
				alert("Welcome! 회원가입을 축하합니다.");
				$('#join-modal').modal("hide");
				$('.modal-backdrop').remove();
				
			}
				
			
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alertify.notify('Oops!! 회원가입에 문제가 생겼습니다.', 'error', // 'error','warning','message'
			3, // -1
			function() {
				// console.log(jqXHR.responseText);
			});
		}
	});

}

function autoLogin(info){
	console.log(info);
	
	let jsonData = JSON.stringify({
		userEmail : info.userEmail,
		userPassword : info.userPassword
	});

	console.log(jsonData);
	$.ajax({
		type : 'post',
		url : contextPath + '/login',
		dataType : 'json',
		data : jsonData,
		contentType:"application/json; charset=UTF-8",
	     
		success : function(data) { // alertify or another welcome
			// page 이동
			// console.log(data);
			// console.log(data.result);
			if(data!=null){
				console.log(data);
				console.log("login Success");
				$("#signUp").css("display", "none");
				$("#login").css("display", "none");
				$("#logout").css("display", "inline-block");
				$("#info").css("display", "inline-block");
				$("#navItem3").css("display", "inline-block");
				$("#navItem4").css("display", "inline-block");
				$("#navItem5").css("display", "inline-block");
				$("#login-modal").modal('hide');
			}else{
				alert("로그인에 실패했습니다.");
			}
				
			
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert("로그인에 실패했습니다.");
		}
	});
	
}
function loadInfo() {
	
//	$.ajax({
//		type : 'get',
//		url : contextPath + '/user',
//		dataType : 'json',
//		success : function(data, status, xhr) { // alertify or another welcome
//			// page 이동
//			var data = JSON.parse(httpRequestLoadInfo.responseText);
//			$("#infoEmail").html(data.Email);
//			$("#infoName").val(data.Name);
//		},
//		error : function(jqXHR, textStatus, errorThrown) {
//			alert("서버에 문제가 발생했습니다.");
//		}
//	});

	
	httpRequestLoadInfo = new XMLHttpRequest();
	httpRequestLoadInfo.onreadystatechange = loadInfoResult;

	httpRequestLoadInfo.open('GET', contextPath + '/user', true);
	httpRequestLoadInfo.setRequestHeader('Content-Type',
			'application/x-www-form-urlencoded');
	httpRequestLoadInfo.send("loadInfo=true");
}

function login_auto() {
	httpRequestAuto = new XMLHttpRequest();
	httpRequestAuto.onreadystatechange = loginAutoResult;

	httpRequestAuto.open('POST', contextPath + '/login', true);
	httpRequestAuto.setRequestHeader('Content-Type',
			'application/x-www-form-urlencoded');
	httpRequestAuto.send("loginAuto=true");
}


function loadInfoResult() {
	if (httpRequestLoadInfo.readyState === XMLHttpRequest.DONE) {
		if (httpRequestLoadInfo.status === 200) {

			// Before Learn JSON
			// var result = httpRequest.responseText;

			// After Learn JSON
			var data = JSON.parse(httpRequestLoadInfo.responseText);
			$("#infoEmail").html(data.userEmail);
			$("#infoName").val(data.userName);
		} else {
			alert("서버에 문제가 발생했습니다.");
		}
	}
}

function editInfo() {

	var infoName = document.getElementById("infoName").value;
	var infoPassword = document.getElementById("infoPassword").value;

	if (!validatePassword(infoPassword)) {
		alert("비밀번호는 영문, 숫자 포함 6자리 이상이어야 합니다.");
		return;
	}
	if (!validateUserName(infoName)) {
		alert("이름길이가 너무 짧습니다.");
		return;
	}

	$.ajax({
		type : 'put',
		url : contextPath + '/user',
		dataType : 'json',
		data : {
			register : "true",
			userName : $("#infoName").val(),
			userEmail : $("#infoEmail").val(),
			userPassword : $("#infoPassword").val()
		},
		success : function(data, status, xhr) { // alertify or another welcome
			// page 이동

			//console.log(data.result);

			if (data != null) {
				alert($("#infoName").val() + "님의 회원정보가 수정되었습니다.");
				$("#info-modal").modal('hide');
			} else {
				alert("해당하는 회원정보가 없습니다.");
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert("해당하는 회원정보가 없습니다.");
		}
	});
}

function findPassword() {
	
	$.ajax({
		type : 'get',
		url : contextPath + '/user/find',
		dataType : 'json',
		data : {
			userName : $("#findName").val(),
			userEmail : $("#findEmail").val(),
		},
		success : function(data) {

			if(data != null){
				alert($("#findName").val() + "님의 비밀번호는 '" + data.userPassword
						+ "' 입니다.");
			} else {
				alert("해당하는 회원정보가 없습니다.");
			}
		},
		error : function() {
			alert("해당하는 회원정보가 없습니다.");
		}
	});
	
	
}

function secession() {
	$.ajax({
		type : 'delete',
		url : contextPath + '/user',
		dataType : 'json',
		data : {
			secession : "true",
			userName : $("#infoName").val(),
			userEmail : $("#infoEmail").val(),
			userPassword : $("#infoPassword").val()
		},
		success : function(data) {

			if(data != null){
				alert("탈퇴되었습니다.");
				location.replace(contextPath);
			} else {
				alert("탈퇴하는 과정에 문제가 발생했습니다.");
			}
		},
		error : function() {
			alert("탈퇴하는 과정에 문제가 발생했습니다.");
		}
	});
}
