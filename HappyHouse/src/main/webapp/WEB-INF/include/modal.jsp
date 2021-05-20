<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- join--> <!-- backend 수정 완료 -->
	<div class="modal fade" id="join-modal" data-bs-backdrop="static"
		data-bs-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered modal-lg">
			<div class="modal-content p-5">

				<h3 class="modal-title" id="staticBackdropLabel">회원가입</h3>
				<div class="mb-3 row mt-3">
					<label for="userEmail" class="col-sm-2 col-form-label">이메일
						주소</label>
					<div class="col-sm-10">
						<input type="email" class="form-control" id="userEmail" placeholder="Email-address">
					</div>
				</div>
				<div class="mb-3 row">
					<label for="userPassword" class="col-sm-2 col-form-label">Password</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="userPassword"
							placeholder="영문 숫자 포함 6자리 이상">
					</div>
				</div>
				<div class="mb-3 row">
					<label for="userPassword2" class="col-sm-2 col-form-label">Password check</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="userPassword2"
							placeholder="영문 숫자 포함 6자리 이상">
					</div>
				</div>
				<div class="mb-3 row">
					<label for="userName" class="col-sm-2 col-form-label">이름</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="userName"
							placeholder="User Name">
					</div>
				</div>
				<div class=" d-flex justify-content-center">
					<button type="button" id="joinBtn" class="btn btn-warning col-2">
						등록<i class="fa fa-check"></i>
					</button>
				</div>


			</div>
		</div>
	</div>

	<!--login--> <!-- backend 수정 완료 -->
	<div class="modal fade" id="login-modal" data-bs-backdrop="static"
		data-bs-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content p-5">
				<div class="card">
					<article class="card-body">
						<h4 class="card-title text-center mb-4 mt-1">로그인</h4>
						<hr>
						<form>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text"> <i class="fa fa-user"></i>
										</span>
									</div>
									<input id="loginEmail" class="form-control" placeholder="Email"
										type="email">
								</div>
								<!-- input-group.// -->
							</div>
							<!-- form-group// -->
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text"> <i class="fa fa-lock"></i>
										</span>
									</div>
									<input id="loginPassword" class="form-control"
										placeholder="******" type="password">
								</div>
								<!-- input-group.// -->
							</div>
							<!-- form-group// -->
							<div class="form-group">
								<button type="button" id="loginBtn"
									class="btn btn-primary btn-block">로그인</button>
							</div>
							<!-- form-group// -->
							<p class="text-center">
								<a href="#" class="btn" id="login_findBtn" data-toggle="modal"
									data-target="#find-modal">비밀번호 찾기</a>
							</p>
						</form>
					</article>
				</div>
				<!-- card.// -->
			</div>
		</div>
	</div>

	<!-- info --> <!-- backend 수정 완료 -->
	<div class="modal fade" id="info-modal" data-bs-backdrop="static"
		data-bs-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered modal-lg">
			<div class="modal-content p-5">
				<form action="" id="info">

				<h3 class="modal-title" id="staticBackdropLabel">회원 정보 확인</h3>
				<div class="mb-3 row mt-3">
					<div class="col-sm-2">
						이메일
					</div>
					<div class="col-sm-10">
						<p id="infoEmail"></p>
					</div>
				</div>
				
				<div class="mb-3 row">
					<div class="col-sm-2">
						이름
					</div>
					<div class="col-sm-10">
						<textarea id="infoName" rows="1" cols="23" style="resize: none;"></textarea>
						<!--<input type="text" id="infoName" name="infoName" placeholder="">-->
					</div>
				</div>
				
				<div class="mb-3 row">
					<div class="col-sm-2">
						Password
					</div>
					<div class="col-sm-10">
						<input type="password" id="infoPassword" name="infoPassword" placeholder="">
					</div>
				</div>
				
				<div class=" d-flex justify-content-center">
					<button type="button" id="confirmBtn"
						class="btn btn btn-info col-2 mr-1">
						확인<i class="fa fa-check"></i>
					</button>
					<button type="button" id="editBtn" class="btn btn btn-info col-2 mr-1">
						수정<i class="fa fa-check"></i>
					</button>
					<button type="button" id="secessionBtn" class="btn btn btn-info col-2">
						탈퇴<i class="fa fa-check"></i>
					</button>
				</div>
				</form>
			</div>
		</div>
	</div>

	<!-- find --> <!-- backend 수정 완료 -->
	<div class="modal fade" id="find-modal" data-bs-backdrop="static"
		data-bs-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered modal-lg">
			<div class="modal-content p-5">

				<h3 class="modal-title" id="staticBackdropLabel">비밀번호 찾기</h3>
				<div class="mb-3 row mt-3">
					<label for="inputName" class="col-sm-2 col-form-label">이메일</label>
					<div class="col-sm-10">
						<input type="email" class="form-control" id="findEmail">
					</div>
				</div>
				<div class="mb-3 row">
					<label for="inputId" class="col-sm-2 col-form-label">이름</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="findName">
					</div>
				</div>
				<div class=" d-flex justify-content-center">
					<button type="button" id="find_findBtn" class="btn btn-info col-3">
						비밀번호 찾기<i class="fa fa-check"></i>
					</button>
				</div>


			</div>
		</div>
	</div>

	<!-- 관심지역 -->
	<div class="modal fade" id="area-modal" data-bs-backdrop="static"
		data-bs-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered modal-lg">
			<div class="modal-content p-5">

				<h3 class="modal-title" id="staticBackdropLabel">관심지역</h3>
				<div class="mb-3 row mt-3">
					<label for="inputDo" class="col-sm-3 col-form-label">관심 지역
						설정</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" id="inputDo"
							placeholder="도/광역시">
					</div>
				</div>
				<div class="mb-3 row">
					<label for="inputSi" class="col-sm-3 col-form-label"></label>
					<div class="col-sm-9">
						<input type="text" class="form-control" id="inputSi"
							placeholder="시/구/군">
					</div>
				</div>
				<div class="mb-3 row">
					<label for="inputDong" class="col-sm-3 col-form-label"></label>

					<div class="col-sm-9">
						<input type="text" class="form-control" id="inputDong"
							placeholder="동">
					</div>
				</div>
				<div class=" d-flex justify-content-center">
					<button type="button" id="area_closeBtn"
						class="text-secondary btn btn btn-warning col-2 mr-1">
						닫기<i class="fa fa-check"></i>
					</button>
					<button type="button" id="area_confirmBtn"
						class="btn btn btn-warning col-2">
						등록<i class="fa fa-check"></i>
					</button>
				</div>


			</div>
		</div>
	</div>