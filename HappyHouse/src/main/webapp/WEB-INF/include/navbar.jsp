<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- navbar start  -->

<nav class="navbar navbar-expand-lg navbar-light bg-dark">
	<ul class="navbar-nav mr-auto">
	</ul>
	<span>

		<button id="signUp" data-toggle="modal" data-target="#join-modal"
			class="nav-item btn btn-secondary bg-dark">
			<i class="fa fa-user"></i> Sign Up
		</button>
		<button id="login" data-toggle="modal" data-target="#login-modal"
			class="nav-item btn btn-secondary bg-dark">
			<i class="fa fa-lock"></i> Login
		</button>
		<button id="logout" class="nav-item btn btn-secondary bg-dark"
			style="display: none;">
			<i class="fa fa-user"></i> Logout
		</button>
		<button id="info" data-toggle="modal" data-target="#info-modal"
			class="nav-item btn btn-secondary bg-dark" style="display: none;">
			<i class="fa fa-user"></i> 회원정보
		</button>
	</span>
</nav>


<nav class="navbar navbar-expand-lg navbar-light">
	<button id="btnSsafyLogo" class="navbar-brand btn">
		<img style="width: 100px; height: 100px;" src="./img/ssafy_logo.png"
			alt="">
	</button>

	<div class="collapse navbar-collapse d-flex justify-content-end"
		id="navbarSupportedContent">
		<div>

			<ul class="navbar-nav mr-auto p-4">
				<li class="nav-item active"><a class="nav-link"
					href="./notice.jsp">공지 사항<span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item active"><a class="nav-link" href="#">오늘의
						뉴스<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item active" style="display: none;" id="navItem3">
					<a class="nav-link" href="#">주변 탐방<span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item active" style="display: none;" id="navItem4">
					<a class="nav-link" href="#" data-toggle="modal"
					data-target="#area-modal">관심지역 설정<span class="sr-only">(current)</span></a>
				</li>

				<li class="nav-item dropdown" style="display: none;" id="navItem5">
					<a class="nav-link dropdown-toggle" href="#"
					id="navItem5 navbarDropdown" role="button" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> 관심지역 둘러보기<span
						class="sr-only">(current)</span>
				</a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item" href="./searchStore.jsp">관심지역
								상가정보</a></li>
						<li><a class="dropdown-item" href="./searchAir.jsp">관심지역
								대기오염정보</a></li>
					</ul>
				</li>

				<li class="nav-item active" id="navItem6"><a class="nav-link"
					href="./community.jsp">커뮤니티<span class="sr-only">(current)</span></a>
				</li>
			</ul>
		</div>
		<div>
			<ul class="navbar-nav mr-auto pl-2">
				<li class="nav-item active"><a id="btnSearchMap" class="nav-link"
					href="#"><i class="fa fa-search"></i><span
						class="sr-only">(current)</span></a></li>
			</ul>
		</div>
	</div>
</nav>

<div class="jumbotron jumbotron-fluid m-0"
	style="background-image: url(./img/bgg.png); background-size: cover;">
	<div class="container text-center text-white">
		<h2 class="text-white">HAPPY HOUSE</h2>
		<hr class="hr1">
		<p class="lead">행복한 우리 집</p>
	</div>
</div>

<script>
#(document).ready(function(){
	#("#btnSsafyLogo").on("click",function(){
		
	})
})
</script>