<template>
    <main class="content">
        <div class="row">
            <div class="col-12 mb-4">
                <div class="card border-light shadow-sm ">
                    <div class="card-body">


                        <!-- selectbar start  -->
                    <div class="d-flex justify-content-center mb-3" style=" height:100px;">
                            
                        <div class="row">
                            <div class="col align-self-center">
                            <select v-model="selectedSidoCode" @change="gugunList" class="form-select" aria-label="시">
                                <option value="empty" selected disabled>시/도</option>
                                <option v-for="(sido, index) in selectSidoList" :key="index" :value="sido.SIDO_CODE">{{ sido.SIDO_NAME }}</option>
                            </select>
                            </div>
                            <div class="col align-self-center">
                            <select v-model="selectedGugunCode" @change="dongList" class="form-select" aria-label="구">
                                <option value="empty" selected disabled>구/군</option>
                                <option v-for="(gugun, index) in selectGugunList" :key="index" :value="gugun.GUGUN_CODE">{{ gugun.GUGUN_NAME }}</option>
                            </select>
                            </div>
                            <div class="col align-self-center">
                            <select v-model="selectedDongName" class="form-select" aria-label="동">
                                <option value="empty" selected disabled>동</option>
                                <option v-for="(dong, index) in selectDongList" :key="index" :value="dong.DONG_NAME">{{ dong.DONG_NAME }}</option>
                            </select>
                            </div>
                            <div class="col align-self-center">
                            <input type="button" class="btn btn-warning ml-3" value="검색" @click="searchMap" :disabled="selectedDongName == 'empty'" />
                            </div>
                        </div>
                        </div>
                        <!-- selectbar end  -->
                        
                        <!-- searchBar start -->
                        <!-- <div class="row mb-3">
                            <div class="col-3"></div>
                            <div class="col-4">
                                <div class="input-group">
                                    <span class="input-group-text" id="basic-addon1">
                                        <font-awesome-icon :icon="['fas', 'search']"/>
                                    </span>
                                    <input
                                        v-model="searchDong"
                                        type="text"
                                        class="form-control me-2"
                                        id="dong"
                                        placeholder="동 이름을 입력하세요"
                                        aria-label="Search"></div>
                                </div>
                                <div class="col-2">
                                    <button class="btn btn-secondary" @click="searchMap">검색</button>
                                </div>
                                <div class="col-3"></div>
                            </div> -->
                            <!-- searchBar end -->

                            <p> ddddd {{latlngTestMsg}} {{latlng}}</p>
                            <div v-if="totalSchoolCnt"  style="text-align:center" >
                                    <strong>{{searchDong}}</strong>의 학교 검색 결과는 총 <strong>{{totalSchoolCnt}}</strong>건 입니다.
                                </div>  
                            <div class="row"> 
                                  
                                    <div v-if="totalSchoolCnt" class="col-4">
                                        <div style="overflow:scroll; height:400px;" >

                                            결과를어떻게띄울까
                                            test
                                             검색결과
                                            <div v-for="(item, index) in schoolList" :key="index" >
                                                <p>학교명 : {{ item.schoolName }}</p>
                                                <p>분류 : {{item.schoolType}}</p>
                                                <p>도로명주소 : {{item.schoolAddress1}}</p>
                                                <p>전화번호 : {{item.schoolPhone}}</p>
                                                <p>설립일자 : {{item.schoolEstDate}}</p>
                                                <hr>
                                            </div>
                                        </div>
                                </div>
                           
                                
                                
                                
                                <div id="map" class="map col border" @click="mapClick"></div>
                                
                            </div>
                                
                            
                            
                            
                            
                                
                        </div>

                    </div>
                </div>
                
            </div>
        </main>
</template>

<script>

        // import axios2 from 'axios'; axios2.defaults.baseURL =
        // 'http://api.data.go.kr/'; axios2.defaults.headers.post['Content-Type'] =
        // 'application/json;charset=utf-8';
        // axios2.defaults.headers.post['Access-Control-Allow-Origin'] = '*';

        import http from '@/common/axios.js';

        import axios from 'axios';

        axios.defaults.baseURL = 'https://dapi.kakao.com/';
        axios
            .defaults
            .headers
            .post['Content-Type'] = 'application/json;charset=utf-8';
        axios
            .defaults
            .headers
            .post['Access-Control-Allow-Origin'] = '*';

        export default {
            name: 'SchoolZone',
            data() {
                return {
                    loadingCount: 0,

                    totalSchoolCnt: '',
                    searchDong: '',
                    
                    dongLat: '37.566426542005416',
                    dongLng: '126.9779060206625',
                    map: null,
                    marker: null,
                    schoolList: [],


                    latlng : '',
                    latlngTestMsg : 'test',
                    markerPositions : [],

                    selectSidoList: [],
                    selectGugunList: [],
                    selectDongList: [],
                    selectedSidoCode: 'empty',
                    selectedGugunCode: 'empty',
                    selectedDongName: 'empty',



                }
            },
            mounted() {
                this
                    .$store
                    .commit('SET_BREADCRUMB_INFO', {
                        title: 'SchoolZone',
                        subTitle: '주변 학군 정보',
                        desc: '관심있는 동을 선택하거나, 원하는 지역을 지도에서 클릭해보세요!'
                    });
                this
                    .$store
                    .commit('SET_CUR_PAGE', 'schoolZone');

                if (window.kakao && window.kakao.maps) {
                    this.initMap();
                } else {
                    const script = document.createElement('script');
                    /* global kakao */
                    script.onload = () => kakao
                        .maps
                        .load(this.initMap);
                    script.src = "http://dapi.kakao.com/v2/maps/sdk.js?appkey=6b6db1abf1494d99829a0aceb281502f";
                    document
                        .head
                        .appendChild(script);
                }

                this.sidoList();

            },
            methods: {
                initMap() {
                    var container = document.getElementById('map');
                    var options = {
                        center: new kakao
                            .maps
                            .LatLng(this.dongLat, this.dongLng),
                        level: 10
                    };

                    this.map = new kakao
                        .maps
                        .Map(container, options);

                    this.marker = new kakao
                        .maps
                        .Marker({
                            position: this
                                .map
                                .getCenter()
                        });

                    this
                        .marker
                        .setMap(this.map);

                },
                searchSchool() {
                    // var url = '/v2/local/search/category.json?category_group_code=SC4&x=' + this.dongLng +
                    //         '&y=' + this.dongLat + '&radius=2000&sort=distance'
                    // axios
                    //     .get(url, {
                    //         headers: {
                    //             Authorization: 'KakaoAK f4c6ef3414193da426ed5d863808c7d4'
                    //         }
                    //     })
                    //     .then((response) => {
                    //         console.log(response.data);
                    //     })
                    //     .catch((error) => {
                    //         this.$swal(
                    //             {icon: 'error', title: '검색에 실패했습니다', text: '검색어를 확인해주세요.', footer: '관심있는 지역의 동 이름을 입력해주세요'}
                    //         );
                    //         console.log(error);
                    //     });
                },
                
                searchMap() {
                    // axios2.get('/openapi/tn_pubr_public_elesch_mskul_lc_api?serviceKey=ZR710L6m
                    // yodEEDwC%2FRmFJaTcGb0PckbFCt9LB6nNRAi6%2BLL2j%2FtXCMT%2FDv%2BM9%2BRJwkpyeR8
                    // Ji2RDYiui2Nfbmg%3D%3D&type=json') .then((response)=> {
                    // console.log(response); }).catch((error)=>{    console.log(error); });

                    


                this.searchDong = this.selectedDongName;

                http
                .get("/school/"+this.searchDong
                )
                .then(({data}) => {
                    console.log("SchoolZone List - data : ");
                    console.log(data);

                    if (data.result == 'login') {
                        this.$router.push('/login');
                    } else{

                        this.totalSchoolCnt = data.cnt;
                        this.schoolList = data.list;

                        console.log(this.schoolList);

                        this.$swal(
                        {icon: 'success', title: '학군 정보 검색에 성공했습니다!', text : this.searchDong+' 검색결과 : '+this.totalSchoolCnt+'개', showConfirmButton: false, timer: 1500}

                        
                        
                    
                    );
                    
                    
                    this.findLatLng();
                    

                    

                    }})
                .catch((error) => {
                    console.log("SchoolZone List - error : ");
                    console.log(error);
                    if (error.response.status == "404") {
                       this.$swal(
                                {icon: 'error', title: '검색에 실패했습니다', text: '검색어를 확인해주세요.', footer: '서울특별시 내의 정보만을 제공하고 있습니다.'}
                             );
                    } else {
                        this
                            .$alertify
                            .error("Opps!! 서버에 문제가 발생했습니다.");
                    }
                });

                },

                findLatLng(){

                    var container = document.getElementById('map');
                    
                    var options = {
                        center: new kakao
                            .maps
                            .LatLng(this.dongLat, this.dongLng),
                        level: 5
                    };

                    var map = new kakao
                        .maps
                        .Map(container, options);
                    
                    // 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
                    var mapTypeControl = new kakao.maps.MapTypeControl();

                    // 지도에 컨트롤을 추가해야 지도위에 표시됩니다
                    // kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
                    map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

                    // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
                    var zoomControl = new kakao.maps.ZoomControl();
                    map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
                    console.log(map);

                    this.schoolList.forEach(function(school){
                            var address = school.schoolAddress1;
                            axios
                        .get('/v2/local/search/address.json?query=' + address, {
                            headers: {
                                Authorization: 'KakaoAK f4c6ef3414193da426ed5d863808c7d4'
                            }
                        })
                        .then((response) => {
                            
                            var lat = response
                                .data
                                .documents[0]
                                .y;
                            var lng = response
                                .data
                                .documents[0]
                                .x;

                            console.log(lat+" "+lng);

                            var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
    

                            // 마커 이미지의 이미지 크기 입니다
                            var imageSize = new kakao.maps.Size(24, 35); 
                            
                            // 마커 이미지를 생성합니다    
                            var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
                            
                            // 마커를 생성합니다
                            var marker = new kakao.maps.Marker({
                            
                                position: new kakao.maps.LatLng(lat,lng), // 마커를 표시할 위치
                                title : school.schoolName, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
                                image : markerImage // 마커 이미지 
                            });

                            marker.setMap(map);

                            var infowindow = new kakao.maps.InfoWindow({zIndex:1});

                            kakao.maps.event.addListener(marker, 'mouseover', function() {
                                // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
                                infowindow.setContent('<div style="padding:5px;font-size:12px;">' + 
                                school.schoolName + '</div>');
                                infowindow.open(map, marker);
                            });
                            //this.setMarkers(school.schoolName, lat, lng);
                            // 마커에 마우스아웃 이벤트를 등록합니다
                            kakao.maps.event.addListener(marker, 'mouseout', function() {
                                // 마커에 마우스아웃 이벤트가 발생하면 인포윈도우를 제거합니다
                                infowindow.close();
                            });

                            var moveLatLon = new kakao.maps.LatLng(lat, lng);
    
                            // 지도 중심을 부드럽게 이동시킵니다
                            // 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다
                            map.panTo(moveLatLon); 

                        })
                        .catch((error) => {
                            
                            console.log(error);
                        });
                        }



                    )
                    
                    
                },


                
                mapClick(){
                    
                    var $this = this;

                    kakao.maps.event.addListener(this.map, 'click', function(mouseEvent) {        
    
                    $this.latlng = mouseEvent.latLng;
                    console.log("click latlng : "+mouseEvent.latLng);
                   
                    $this.latlngTestMsg = '클릭한 위치의 위도는 ' + $this.latlng.getLat() + ' 이고, 경도는 ' + $this.latlng.getLng() + ' 입니다';
                    console.log($this.latlngTestMsg);

                });

                    
                    

                },

                

                sidoList() {
                    console.log('sidoList() is called!!!!!!');
                    this.loadingCountUp();
                    http.get('/sido').then(({ data }) => {
                        console.log('sidoList : ');
                        console.log(data);
                        this.loadingCountDown();
                        if (data.result == 'login') {
                        this.$router.push('/login');
                        } else {
                        this.selectSidoList = data;
                        }
                    });
                },
                gugunList() {
                    console.log('gugunList() is called!!!!!!');
                    this.loadingCountUp();
                    http
                    .get('/gugun', {
                    params: {
                        sidoCode: this.selectedSidoCode,
                    },
                    })
                    .then(({ data }) => {
                    console.log('gugunList : ');
                    console.log(data);
                    this.loadingCountDown();
                    if (data.result == 'login') {
                        this.$router.push('/login');
                    } else {
                        this.selectGugunList = data;
                    }
                    });
                },
                dongList() {
                    console.log('dongList() is called!!!!!!!');
                    this.loadingCountUp();
                    http
                    .get('/dong', {
                    params: {
                        sidoCode: this.selectedSidoCode,
                        gugunCode: this.selectedGugunCode,
                    },
                    })
                    .then(({ data }) => {
                    console.log('dongList : ');
                    console.log(data);
                    this.loadingCountDown();
                    if (data.result == 'login') {
                        this.$router.push('/login');
                    } else {
                        this.selectDongList = data;
                    }
                    });
                },
                loadingCountUp() {
                    this.loadingCount++;
                },
                loadingCountDown() {
                    this.loadingCount--;
                },
            }
        }
</script>
<style>
        .map {
            width: 100%;
            height: 400px;
        }
</style>