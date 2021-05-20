<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.ssafy.happyhouse.dto.*, java.util.*"%>
<%
	String contextPath = request.getContextPath();
	UserDto userDto = (UserDto)session.getAttribute("userDto");
	int userSeq = 0;
	if(userDto != null){
		userSeq = userDto.getUserSeq();
		System.out.println(userSeq);
}
%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>HAPPY HOUSE</title>
<style>
.hr1 {
	border: 0;
	height: 1px;
	background-image: linear-gradient(to right, rgba(255, 255, 255, 0),
		rgba(255, 255, 255, 0.75), rgba(255, 255, 255, 0));
}

.hr2 {
	border: 0;
	height: 1px;
	background-image: linear-gradient(90deg, black, transparent);
}

#apartInfo {
	height: 550px;
	overflow: auto;
}

#apartInfo::-webkit-scrollbar {
	width: 10px;
}

#apartInfo::-webkit-scrollbar-thumb {
	background-color: rgb(219, 227, 233);
}

#apartInfo::-webkit-scrollbar-track {
	background-color: white;
}

.choiceOption select {
	border-radius: 50px;
}
</style>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/alertify.min.js"></script>
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/css/alertify.min.css" />
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/css/themes/default.min.css" />
<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=aaa45e9e6e094d6ac107aadbc728ff10"></script>
</head>

<body>
	<div class="container">
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

		<!-- selectbar start  -->
        <div class="choicePlace d-flex justify-content-center bg-dark" >
        	<div class="row container text-center">
           		<div class="form-check col align-self-center">
           			<input class="form-check-input" type="radio" id="radioDong" name="radioSearch" value="dong">
                   	<label class="form-check-label text-white" for="radioDong">동 검색</label>
				</div>
				<div class="form-check col align-self-center">
					<input class="form-check-input " type="radio" id="radioApt" name="radioSearch" value="apt">
                   	<label class="form-check-label text-white" for="radioApt">아파트 검색</label>
				</div>
				<div class="form-check col align-self-center">
					<input class="form-check-input " type="radio" id="radioBookmark" name="radioSearch" value="bookmark">
                   	<label class="form-check-label text-white" for="radioBookmark">관심 매물 보기</label>
				</div>
			</div>
		</div>
        <div class="choicePlace d-flex justify-content-center bg-dark pt-3 pb-3">
			<div class="row" id="divSearch">

			</div>
        </div>
        <!-- selectbar end  -->
		<!-- main start-->
        <div class="main bg-light p-4">
            <div class="row m-1">
                <div class="col-4" id="apartInfo">
                </div>
                <div id="map" class="col-8" style="height: 550px;"></div>
            </div>
        </div>
        <div id="paginationWrapper"></div>
        <div class="mt-4"></div>
        <!--main end-->

		<div class="row mt-2 p-3">
			<div class="col-4 pt-3"
				style="box-sizing: border-box; background-color: rgb(224, 208, 245);">
				<h4>SSAFY 고지서 신청하고 포인트 받으세요!</h4>
				<span class="text-info">#100만원 당첨기회</span>
				<p class="text-info">#재산세 #주민세</p>
				<div class=" text-right mt-1 pb-2">
					<img style="width: 130px" src="./img/tax.png">
				</div>

			</div>
			<div class="col-4">
				<h4>지혜롭게 내집 마련하기</h4>
				<hr class="hr2">
				<i class="fa fa-krw" style="width: 20px;"></i> <a class="text-dark"
					href="">가용자금 확인 및 대출계획</a><br> <i class="fa fa-home"
					style="width: 20px;"></i> <a class="text-dark" href="">집 종류 및
					지역 선택</a><br> <i class="fa fa-signal" style="width: 20px;"></i> <a
					class="text-dark" href="">정보 수집 &amp; 시세파악</a><br> <i
					class="fa fa-search" style="width: 20px;"></i> <a class="text-dark"
					href="">부동산 방문 &amp; 집구경</a><br> <i class="fa fa-edit"
					style="width: 20px;"></i> <a class="text-dark" href="">계약 및 잔금
					치르기</a><br> <i class="fa fa-file" style="width: 20px;"></i> <a
					class="text-dark" href="">소유권 이전등기</a><br> <i
					class="fa fa-cog" style="width: 20px;"></i> <a class="text-dark"
					href="">인테리어 공사</a><br>
				<hr class="hr2">
			</div>
			<div class="col-4">
				<h4>오늘의 뉴스</h4>
				<hr class="hr2">
				<h6>서울 아파트, 매매전세 다른양상.. 상승.. 아시아경제</h6>
				<ul style="font-size: 13px;">
					<li><a href="">서울 입주 2년차 아파트 전셋값 1억400만원 올라</a> 한겨레</li>
					<li><a href="">12.16發 거래한파.. 매수자가 사라졌다</a> 아시아경제</li>
					<li><a href="">재건축 대안 뜨는 수직증축 리모델링... 추진 속..</a> 동아일보</li>
					<li><a href="">고가기준 9억, 서울 아파트 중간값 됐다</a> 동아일보</li>
				</ul>
			</div>
		</div>


		<!-- footer start-->
		<div class="row mt-2">
			<div class="col-1 d-flex justify-content-center">
				<img style="width: 50px; height: 50px;" src="./img/ssafy_logo.png"
					alt="">
			</div>
			<div class="col-11">
				<div class="row">
					<div style="width: 50%;">
						<h4 class="font-weight-normal">Find Us</h4>
						<hr class="hr2">
					</div>
				</div>
				<div class="row">
					<i class="fa fa-map-marker d-flex justify-content-center"
						style="width: 30px;"></i>
					<h6>(SSAFY) 서울시 강남구 테헤란로 멀티스퀘어</h6>
				</div>
				<div class="row">
					<i class="fa fa-phone d-flex justify-content-center"
						style="width: 30px;"></i>
					<h6>1544-9001</h6>
				</div>
				<div class="row">
					<i class="fa fa-envelope d-flex justify-content-center"
						style="width: 30px;"></i>
					<h6>
						<a href="#">admin@ssafy.com</a>
					</h6>
				</div>
			</div>
		</div>
	</div>
	<!--footer end-->

	<!-- Modal start-->
	
	<%@ include file="./include/modal.jsp"%>

	<!-- Modal end -->


	<script>
		var LIST_ROW_COUNT = 10;	//limit
		var OFFSET = 0;
		var SEARCH_WORD = "";
		var SEARCH_TYPE = "apt";
		
		var SIDO_NAME = "";
		var GUGUN_NAME = "";
		
		$(document).ready(function(){

			dealList(SEARCH_TYPE);
			
			$("#btnSsafyLogo").on("click", function(){
				$("#selectBar").html('<h1>안녕하세요.</h1>')
			})
			
			$(document).on('change','input:radio[name="radioSearch"]', function() {
		        if ($(this).is(':checked') && $(this).val() == 'dong'){
		        	SEARCH_TYPE = 'dong'
					$("#divSearch").html('<div class="col row">' +
							                '<div class="col align-self-center">' +
							                    '<select id="selectSido" class="form-select p-2 bg-dark text-light" aria-label="시">' +
							                        '<option selected disabled>시/도</option>' +
							                    '</select>' +
							                '</div>' +
							                '<div class="col align-self-center">' +
							                    '<select id="selectGugun" class="form-select p-2 bg-dark text-light" aria-label="구">' +
							                        '<option selected disabled>구/군</option>' +
							                    '</select>' +
							                '</div>' +
							                '<div class="col align-self-center">' +
							                    '<select id="selectDong" class="form-select p-2 bg-dark text-light" aria-label="동">' +
							                        '<option selected disabled>동</option>' +
							                    '</select>' +
							                '</div>' +
						                '</div>' +
						                '<div class="align-self-center">' +
						                	'<input type="button" id="btnSearch" class="btn btn-warning ml-3" value="검색" disabled/>' +
						                '</div>');
					sidoList();
		        } else if($(this).is(':checked') && $(this).val() == 'apt'){
		        	SEARCH_TYPE = 'apt'
		        	$("#divSearch").html('<div class="col row">' +
						        			'<div>' +
					    						'<input type="text" class="form-control" id="searchText"/>' +
					            			'</div>' +
						                '</div>' +
						                '<div class="align-self-center">' +
						                	'<input type="button" id="btnSearch" class="btn btn-warning ml-3" value="검색"/>' +
						                '</div>');
		        } else if($(this).is(':checked') && $(this).val() == 'bookmark'){
		        	SEARCH_TYPE = 'bookmark'
		        	$("#divSearch").html('<div class="align-self-center"></div>');
		        	dealList(SEARCH_TYPE);
	// 	       		$("#divSearch").html('<div class="align-self-center">' +
	// 					                	'<input type="button" id="btnSearch" class="btn btn-warning ml-3" value="보기"/>' +
	// 						               '</div>'); 	
		        }
			});
			
		});
		
		$(document).on("change", "#selectSido", function(){
			SIDO_NAME = this.value;
			gugunList();
		})
		
		$(document).on("change", "#selectGugun", function(){
			GUGUN_NAME = this.value;
			dongList();
		})
		
		$(document).on("change", "#selectDong", function(){
			if ($("#btnSearch").prop("disabled") == true) {
				$("#btnSearch").attr("disabled", false);
			}
		})
		
		$(document).on("propertychange change keyup paste input", "#searchText", function() {
			if ($("#btnSearch").prop("disabled") == true) {
				$("#btnSearch").attr("disabled", false);
			}
		});
		
		$(document).on("click", "#btnSearch", function(){
			if(SEARCH_TYPE == 'dong'){
				SEARCH_WORD = $("#selectDong option:selected").val();
			} else if(SEARCH_TYPE == 'apt'){
				SEARCH_WORD = $("#searchText").val();
			}		
			dealList(SEARCH_TYPE);
		})
		
		$(document).on("click", ".bookmarkStar", function(){
			if ($(this).hasClass("fa-star-o")){
				$(this).removeClass("fa-star-o");
				$(this).addClass("fa-star");
				console.log("userSeq : " + <%=userSeq%>);
				console.log("dealNo : " + $(this).children().val());
				insertBookmark($(this).children().val());
			} else {
				$(this).removeClass("fa-star");
				$(this).addClass("fa-star-o");
				console.log("userSeq : " + <%=userSeq%>);
				console.log("dealNo : " + $(this).children().val());
				deleteBookmark($(this).children().val());
			}
		})
	    
		function insertBookmark(dealNo) {
			$.ajax(
				{
					type : 'post',
					url : '<%=contextPath%>/bookmark/bookmarkInsert',
					dtatType : 'json',
					data : {
	                	userSeq: <%=userSeq%>,
	                	dealNo: dealNo
	                },
					success : function(data, status, xhr) {
						console.log('insert bookmark success');
					},
					error : function(jqXHR, textStatus, errorThrown){
						console.log(textStatus);
	                	
	                	alertify.notify(
	               			'Opps!! 북마크 추가 과정에 문제가 생겼습니다.', 
	               			'error', //'error','warning','message'
	               			3, //-1
	               			function(){
	               				console.log(jqXHR.responseText); 
	               			}
	               		);
					}
				}		
			);
		}
		
		function deleteBookmark(dealNo) {
			$.ajax(
				{
					type : 'post',
					url : '<%=contextPath%>/bookmark/bookmarkDelete',
					dtatType : 'json',
					data : {
	                	userSeq: <%=userSeq%>,
	                	dealNo: dealNo
	                },
					success : function(data, status, xhr) {
						console.log('delete bookmark success');
					},
					error : function(jqXHR, textStatus, errorThrown){
						console.log(textStatus);
	                	
	                	alertify.notify(
	               			'Opps!! 북마크 추가 과정에 문제가 생겼습니다.', 
	               			'error', //'error','warning','message'
	               			3, //-1
	               			function(){
	               				console.log(jqXHR.responseText); 
	               			}
	               		);
					}
				}		
			)
		}
		
		function sidoList(){
			$.ajax(
			    	{
			            type : 'GET',
			            url : '<%=contextPath%>/search',
		                dataType : 'json',
		                success : function(data, status, xhr) { 
		                	console.log("sidoList success")
		                	makeSidoListHtml(data);
		                }, 
		                error: function(jqXHR, textStatus, errorThrown) 
		                { 
		                	console.log(textStatus);
		                	
		                	alertify.notify(
		               			'Opps!! 시 정보 조회 과정에 문제가 생겼습니다.', 
		               			'error', //'error','warning','message'
		               			3, //-1
		               			function(){
		               				console.log(jqXHR.responseText); 
		               			}
		               		);
		                }
		            });
			
			function makeSidoListHtml(list){
				$("#selectSido").empty();
				$("#selectSido").append("<option selected disabled>시/도</option>");
				for( var i=0; i<list.length; i++){
					var sidoName = list[i].sidoName;
					var listHtml = 
					'<option value="' + sidoName + '">' + sidoName + '</option>'; 
		    		$("#selectSido").append(listHtml);
		    	}
			}
		}
		
		function gugunList(){
			$.ajax(
			    	{
			            type : 'GET',
			            url : '<%=contextPath%>/search/' + SIDO_NAME,
		                success : function(data, status, xhr) { 
		                	console.log("gugunList success")
		                	console.log(SIDO_NAME)
		                	makeGugunListHtml(data);
		                }, 
		                error: function(jqXHR, textStatus, errorThrown) 
		                { 
		                	console.log(textStatus);
		                	
		                	alertify.notify(
		               			'Opps!! 구군 정보 조회 과정에 문제가 생겼습니다.', 
		               			'error', //'error','warning','message'
		               			3, //-1
		               			function(){
		               				console.log(jqXHR.responseText); 
		               			}
		               		);
		                }
		            });
			
			function makeGugunListHtml(list){
				$("#selectGugun").empty();
				$("#selectGugun").append("<option selected disabled>구/군</option>");
				for( var i=0; i<list.length; i++){
					var gugunName = list[i].gugunName;
					var listHtml = 
					'<option value="' + gugunName + '">' + gugunName + '</option>'; 
		    		$("#selectGugun").append(listHtml);
		    	}
			}
		}
		
		function dongList(){
			$.ajax(
			    	{
			            type : 'GET',
			            url : '<%=contextPath%>/search/' + SIDO_NAME + '/' + GUGUN_NAME,
		                success : function(data, status, xhr) {
		                	console.log("dongList success")
		                	console.log(data)
		                	makeDongListHtml(data);
		                }, 
		                error: function(jqXHR, textStatus, errorThrown) 
		                { 
		                	console.log(textStatus);
		                	
		                	alertify.notify(
		               			'Opps!! 동 정보 조회 과정에 문제가 생겼습니다.', 
		               			'error', //'error','warning','message'
		               			3, //-1
		               			function(){
		               				console.log(jqXHR.responseText); 
		               			}
		               		);
		                }
		            });
			
			function makeDongListHtml(list){
				$("#selectDong").empty();
				$("#selectDong").append("<option selected disabled>동</option>");
				for( var i=0; i<list.length; i++){
					var dongName = list[i].dongName;
					var listHtml = 
					'<option value="' + dongName + '">' + dongName + '</option>'; 
		    		$("#selectDong").append(listHtml);
		    	}
			}
		}
	
	    function dealList(searchType){
	    	$.ajax(
	    	{
	            type : 'get',
	            url : '<%=contextPath%>/deal',
                dataType : 'json',
                data : 
        		{
                	limit: LIST_ROW_COUNT,
        			offset: OFFSET,
        			searchWord: SEARCH_WORD,
        			userSeq: <%=userSeq%>,
        			searchType: searchType
        		},
                success : function(data, status, xhr) { 
                	console.log(data)
                	makeListHtml(data, searchType);
                }, 
                error: function(jqXHR, textStatus, errorThrown) 
                { 
                	console.log(textStatus);
                	
                	alertify.notify(
               			'Opps!! 아파트 거래 조회 과정에 문제가 생겼습니다.', 
               			'error', //'error','warning','message'
               			3, //-1
               			function(){
               				console.log(jqXHR.responseText); 
               			}
               		);
                }
            });
        }
	
	        function makeListHtml(list, searchType){
	
	        	$("#apartInfo").empty();
	
	        	for( var i=0; i<list.length; i++){
	        		var dealNo = list[i].dealNo;
	        		var aptName = list[i].aptName;
	        		var dealAmount = list[i].dealAmount;
	        		var area = list[i].area;
	        		var dealYear = list[i].dealYear;
	        		var dealMonth = list[i].dealMonth;
	        		var dealDay = list[i].dealDay;
	        		var dealDate = makeDateStr(dealYear, dealMonth, dealDay, '.');
	        		var listHtml = 
	        			// ' <i class="fas fa-star"  style="color:rgb(255, 226, 95);font-size:25px;"></i>
	        		'<div class="apart row" id="apartInfo-' + (i + 1) + '">'
	                +'<div class="col-8">'
	                +'<h5>' + aptName + '</h5>' 
	                +'<p class="m-0">거래금액: ' + dealAmount + '</p>'
	                +'<p class="m-0">전용면적: ' + area + '</p>'
					+'<p class="m-0">등록일: ' + dealDate +'</p>'
	                +'</div>'
	                +'<div class="col align-self-center" style="text-align:center;">'
	            	+'<i class="fa fa-star-o bookmarkStar" id="bookmarkStar' + (i + 1) + '" aria-hidden="true" style="color: rgb(255, 226, 95); font-size: 25px;">'
	            	+'<input type="hidden" value="' + dealNo + '"/>'
	            	+'</i>'
	                +'</div>'
	            	+'</div>'
	            	+'<hr>'
	
	        		$("#apartInfo").append(listHtml);
<%-- 	            	checkBookmark(<%=userSeq%>,$("#bookmarkStar"+(i+1)).children().val(), i + 1); --%>
	        	}
	        	
	        	dealListTotalCnt(searchType, list);
	        	
	//         	if(cnt > 0){
	//         		kakaoMap(list);
	//         	} else {
	//         		alert("검색 결과가 없습니다.");
	//         	}
	        }
	        
	        function checkBookmark(userSeq, dealNo, bookmarkStarNum){
	        	$.ajax(
	        			{
	        				type : 'post',
	        				url : '<%=contextPath%>/bookmark/bookmarkCheck',
	        				dtatType : 'json',
	        				data : {
	                        	userSeq: userSeq,
	                        	dealNo: dealNo
	                        },
	        				success : function(data, status, xhr) {
	        					if(data == 'true'){
	        						$("#bookmarkStar"+bookmarkStarNum).removeClass("fa-star-o");
	        						$("#bookmarkStar"+bookmarkStarNum).addClass("fa-star");
	        					}
	        				},
	        				error : function(jqXHR, textStatus, errorThrown){
	        					console.log(textStatus);
	                        	
	                        	alertify.notify(
	                       			'Opps!! 북마크 추가 과정에 문제가 생겼습니다.', 
	                       			'error', //'error','warning','message'
	                       			3, //-1
	                       			function(){
	                       				console.log(jqXHR.responseText); 
	                       			}
	                       		);
	        				}
	        			}		
	        		);
	        }
	
	        var PAGE_LINK_COUNT = 10;	// pagination link 갯수
	        var TOTAL_LIST_ITEM_COUNT = 0;
	        var CURRENT_PAGE_INDEX = 1;
	
	        function dealListTotalCnt(searchType, list){
	        	
	        	$.ajax(
	        	{
	                type : 'get',
	                url : '<%=contextPath%>/deal/dealListTotalCnt',
	            	dataType : 'json',
	            	data : 
	    			{
	    				searchWord: SEARCH_WORD,
	    				userSeq: <%=userSeq%>,
	    				searchType: searchType
	    			},
		           	success : function(data, status, xhr) {
		            	TOTAL_LIST_ITEM_COUNT = data;
		            	addPagination();
		            	if (TOTAL_LIST_ITEM_COUNT > 0){
		            		console.log(data)
		            		kakaoMap(list);
		            	} else {
		            		alertify.message('검색 결과가 없습니다.');
		            	}
		            }, 
		            error: function(jqXHR, textStatus, errorThrown) 
		            { 
		            	alertify.notify(
		           			'Opps!! 아파트 거래 전체 갯수 조회 과정에 문제가 생겼습니다.', 
		           			'error', //'error','warning','message'
		           			3, //-1
		           			function(){
		           				console.log(jqXHR.responseText); 
		           			}
		           		);
		            }
	        	});
	    }
	
	    function addPagination(){
	    	makePaginationHtml(LIST_ROW_COUNT, PAGE_LINK_COUNT, CURRENT_PAGE_INDEX, TOTAL_LIST_ITEM_COUNT, "paginationWrapper" );
	    }
	
	    function movePage(pageIndex){
	    	OFFSET = (pageIndex - 1) * LIST_ROW_COUNT;
	    	CURRENT_PAGE_INDEX = pageIndex;
	    	dealList(SEARCH_TYPE);
	    }
	
		
	    function kakaoMap(list) {
		     var tatget = {}
		     var mapContainer = document.querySelector("#map");
		     var options = {
		         center: new kakao.maps.LatLng(list[1].lat, list[1].lng),
		         level: 4
		     };
		
		     var map = new kakao.maps.Map(mapContainer, options);
		     // 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
		     var mapTypeControl = new kakao.maps.MapTypeControl();
		
		     // 지도에 컨트롤을 추가해야 지도위에 표시됩니다
		     // kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
		     map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
		
		     // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
		     var zoomControl = new kakao.maps.ZoomControl();
		     map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
		
		     var positions = [];
		    	for( var i=0; i<list.length; i++){
		    		positions.push(
		    		{
		             content: document.getElementById('apartInfo-'+ String(i+1)).innerHTML,
		             latlng: new kakao.maps.LatLng(list[i].lat, list[i].lng)
		    		}		
		    		);
		    	}
		     
		     for (var i = 0; i < positions.length; i++) {
		         var marker = new kakao.maps.Marker({
		             map: map,
		             position: positions[i].latlng, // 마커를 표시할 위치
		         });
		
		         var infowindow = new kakao.maps.InfoWindow({
		             content: positions[i].content // 인포윈도우에 표시할 내용
		         });
		
		         kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
		         kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
		     }
		
		     // 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
		     function makeOverListener(map, marker, infowindow) {
		         return function () {
		             infowindow.open(map, marker);
		         };
		     }
		     
		     // 인포윈도우를 닫는 클로저를 만드는 함수입니다 
		     function makeOutListener(infowindow) {
		         return function () {
		             infowindow.close();
		         };
		     }
	    }
	</script>
	<script src="<%=contextPath%>/js/user.js"></script>
	<script src="<%=contextPath%>/js/util.js"></script>
	
</body>

</html>