<template>
    <main class="content">
        <div class="row">
            <div class="col-12 mb-4">
                <div class="card border-light shadow-sm ">
                    <div class="card-body">


                        <!-- selectbar start  -->
                    <div class="d-flex justify-content-center mb-2" style=" height:100px;">
                            
                        <div class="row">
                            <div class="col align-self-center">
                                <select v-model="selectedSidoCode" @change="gugunList" class="form-select select" aria-label="시" >
                                    <option value="empty" selected disabled>시/도</option>
                                    <option v-for="(sido, index) in selectSidoList" :key="index" :value="sido.SIDO_CODE">{{ sido.SIDO_NAME }}</option>
                                </select>
                            </div>
                            <div class="col align-self-center">
                                <select v-model="selectedGugunCode" @change="dongList" class="form-select select" aria-label="구">
                                    <option value="empty" selected disabled>구/군</option>
                                    <option v-for="(gugun, index) in selectGugunList" :key="index" :value="gugun.GUGUN_CODE" >{{ gugun.GUGUN_NAME }}</option>
                                </select>
                            </div>
                            <div class="col align-self-center">
                                <select v-model="selectedDongName" class="form-select select" aria-label="동">
                                    <option value="empty" selected disabled>동</option>
                                    <option v-for="(dong, index) in selectDongList" :key="index" :value="dong.DONG_NAME">{{ dong.DONG_NAME }}</option>
                                </select>
                            </div>
                            <div class="col align-self-center">
                                <input type="button" class="btn btn-secondary ml-3" value="검색" @click="searchByDong" :disabled="selectedDongName == 'empty'" />
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
                            <div v-if="totalSchoolCnt==''&&selectPointSchoolCnt==''"  style="text-align:center; font-size:16pt" class="mt-1 mb-4">
                                관심 있는 지역을 검색하거나, 지도 위에 마우스를 올려 클릭해보세요!
                            </div>

                            
                            <div v-if="totalSchoolCnt"  style="text-align:center; font-size:16pt" class="mt-1 mb-4">
                                    <strong>{{selectPointAddress}}</strong><br>
                                    <strong>{{searchDong}}</strong>의 학교 검색 결과는 총 <strong>{{totalSchoolCnt}}</strong>건 입니다.
                            </div> 
                            

                            <div v-if="selectPointSchoolCnt"  style="text-align:center; font-size:16pt" class="mt-1 mb-4">
                                
                                반경 1km 이내의 학교 검색 결과는 총 <strong>{{selectPointSchoolCnt}}</strong>건 입니다.
                            </div> 
                            <div class="row mt-3">                                   
                                    <div v-if="totalSchoolCnt" class="col-4 m-2">

                                        <div scroll=auto style="overflow-x:hidden; height:550px; font-size:14pt" class="scroll_set" >

                                            
                                            
                                            <div v-for="(item, index) in schoolList" :key="index" :id="item.schoolName"> 
                                                <h4><strong>{{ item.schoolName }}</strong></h4>
                                                <p class="m-0">도로명주소 : {{item.schoolAddress1}}</p>
                                                <p class="m-0">전화번호 : {{item.schoolPhone}}</p>
                                                <p class="m-0">설립일자 : {{item.schoolEstDate}}</p>
                                                <div style="text-align:right;">
                                                    <p class="m-0"> <a class="btn btn-secondary btn" :href="item.schoolWebAdd">상세보기</a></p>
                                                </div>
                                                <hr>
                                            </div>
                                        </div>
                                    </div>

                                    <!-- <div v-if="selectPointSchoolCnt" class="col-4 m-2">
                                        
                                        <div scroll=auto style="overflow-x:hidden; height:550px; font-size:14pt" class="scroll_set">

                                            
                                            
                                            <div v-for="(item, index) in selectPointSchoolList" :key="index" :id="item.place_name" >
                                                <h4 style="font-size:16pt;"><strong>{{ item.place_name }}</strong></h4>
                                                <p class="m-0">도로명주소 : {{item.road_address_name}}</p>
                                                <p class="m-0">전화번호 : {{item.phone}}</p>
                                                <div style="text-align:right;">
                                                    <p class="m-0"> <a class="btn btn-secondary btn" :href="item.place_url">상세보기</a></p>
                                                </div>
                                                <hr>
                                            </div>
                                        </div>
                                    </div> -->
                           
                                
                                
                                
                                <div id="map" class="map col border mb-3" @click="searchByClick"></div>
                                
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
                    

                    isMapClick : false,
                    totalSchoolCnt: '',
                    searchDong: '',
                
                    dongLat: '37.50141840988349',
                    dongLng: '127.03965383784762',
                    
                    circle : null,
                    map: null,
                    marker : null,

                    schoolList: [],

                    selectPointAddress : '',
                    selectPointDong : '',
                    selectPointSchoolCnt : '',
                    selectPointSchoolList : [],
                    latlng : '',
                    latlngTestMsg : 'test',

                    markerList : [],
                    circleList : [],

                    selectSidoList: [],
                    selectGugunList: [],
                    selectDongList: [],
                    selectedSidoCode: 'empty',
                    selectedGugunCode: 'empty',
                    selectedSidoName: 'empty',
                    selectedGugunName: 'empty',
                    selectedDongName: 'empty',



                }
            },
            mounted() {
                this
                    .$store
                    .commit('SET_BREADCRUMB_INFO', {
                        title: 'SchoolZone',
                        subTitle: '주변 학군 정보',
                        desc: '서울특별시 내의 학교 정보를 확인해 보세요!'
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

                if(this.$store.state.userInfo.isLogin==false){
                        this.$router.push('/');
                    }

            },
            methods: {
                initMap() {
                    var container = document.getElementById('map');
                    var options = {
                        center: new kakao
                            .maps
                            .LatLng(this.dongLat, this.dongLng),
                        level: 5
                    };

                    

                    this.map = new kakao
                        .maps
                        .Map(container, options);


                    // 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
                    var mapTypeControl = new kakao.maps.MapTypeControl();

                    // 지도에 컨트롤을 추가해야 지도위에 표시됩니다
                    // kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
                    this.map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

                    // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
                    var zoomControl = new kakao.maps.ZoomControl();
                    this.map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);


                },
                
                
                searchByDong() {
                    //this.circleInit();
                    this.markerInit();

                   
                    this.selectPointAddress ='';
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
                            this.selectPointSchoolCnt = '';

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

                    var $this = this;
                    
                    
                   
                    console.log($this.map);
                   
                    $this.schoolList.forEach(function(school){
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
                            
                            
                            
                            $this.setMarker(school.schoolName, lat, lng);
                            //console.log($this.markerPositions);

                            

                        })
                        .catch((error) => {
                            
                            console.log(error);
                        });

                        
                        }


                        
                    )
                    
                    
                },

                setMarker(school,lat,lng){
                            var $this = this;
                            var imageSrc = require('@/assets/img/school.png');
    
                            
                            // 마커 이미지의 이미지 크기 입니다
                            var imageSize = new kakao.maps.Size(24, 35); 
                            
                            // 마커 이미지를 생성합니다    
                            var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
                            
                            
                            // 마커를 생성합니다
                            var marker = new kakao.maps.Marker({
                            
                                position: new kakao.maps.LatLng(lat,lng), // 마커를 표시할 위치
                                title : school, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
                                image : markerImage // 마커 이미지 
                            });
                            
                            $this.markerList.push(marker);
                            marker.setMap($this.map);

                            var infowindow = new kakao.maps.InfoWindow({zIndex:1, removable : true});

                            kakao.maps.event.addListener(marker, 'mouseover', function() {
                                // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
                                var windowDiv = '<div class="m-4">' + document.getElementById(school).innerHTML + "</div>";
                                infowindow.setContent(windowDiv);
                             
                                infowindow.open($this.map, marker);
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
                            $this.map.panTo(moveLatLon); 

                            
                },
                
                searchByClick(){
                    
                    var $this = this;

                    
                    $this.markerInit();

                   

                    
                    kakao.maps.event.addListener(this.map, 'click', function(mouseEvent) {        
    
                    $this.latlng = mouseEvent.latLng;
                    console.log("click latlng : "+mouseEvent.latLng);
                   
                    $this.map.panTo($this.latlng); 

                    var marker = new kakao
                        .maps
                        .Marker({
                            position: $this.latlng
                        });

                    marker.setMap($this.map);
                    $this.markerList.push(marker);
                    
                    $this.latlngTestMsg = '클릭한 위치의 위도는 ' + $this.latlng.getLat() + ' 이고, 경도는 ' + $this.latlng.getLng() + ' 입니다';
                    console.log($this.latlngTestMsg);

                    axios
                        .get('/v2/local/geo/coord2regioncode.json?x=' + $this.latlng.getLng() + '&y=' +$this.latlng.getLat(), {
                            headers: {
                                Authorization: 'KakaoAK f4c6ef3414193da426ed5d863808c7d4'
                            }
                        })
                        .then((response) => {
                            
                            $this.selectPointAddress = response
                                .data
                                .documents[0].address_name;

                            $this.searchDong = response
                                .data
                                .documents[0]
                                .region_3depth_name;
                            

                            http
                            .get("/school/"+$this.searchDong
                            )
                            .then(({data}) => {
                                console.log("SchoolZone List - data : ");
                                console.log(data);

                            if (data.result == 'login') {
                                $this.$router.push('/login');
                            } else{

                                $this.totalSchoolCnt = data.cnt;
                                $this.schoolList = data.list;
                                $this.selectPointSchoolCnt = '';

                                console.log($this.schoolList);

                                $this.$swal(
                                {icon: 'success', title: '학군 정보 검색에 성공했습니다!', text : $this.searchDong+' 검색결과 : '+$this.totalSchoolCnt+'개', showConfirmButton: false, timer: 1500}

                                
                                
                            
                            );
                            
                            
                            $this.findLatLng();
                            

                            

                            }})
                            .catch((error) => {
                                console.log("SchoolZone List - error : ");
                                console.log(error);
                                if (error.response.status == "404") {
                                $this.$swal(
                                            {icon: 'error', title: '검색에 실패했습니다', text: '검색어를 확인해주세요.', footer: '서울특별시 내의 정보만을 제공하고 있습니다.'}
                                        );
                                } else {
                                    $this
                                        .$alertify
                                        .error("Opps!! 서버에 문제가 발생했습니다.");
                                }
                            });
                            
                            

                        })
                        .catch((error) => {
                            
                            console.log(error);
                        });
                    
                    
                        

                    //$this.searchSelectPointSchool($this.latlng.getLat(),$this.latlng.getLng());
                });

                    
                    

                },
                // searchSelectPointSchool(lat, lng) {
                   
                   
                //     var url = '/v2/local/search/category.json?category_group_code=SC4&x=' + lng +
                //             '&y=' + lat + '&radius=1000&sort=distance'
                //     axios
                //         .get(url, {
                //             headers: {
                //                 Authorization: 'KakaoAK f4c6ef3414193da426ed5d863808c7d4'
                //             }
                //         })
                //         .then((response) => {
                //             console.log(response.data.documents);
                //             this.selectPointSchoolList = response.data.documents;
                //             this.selectPointSchoolCnt = response.data.meta.total_count;
                //             this.totalSchoolCnt = '';

                //             //좌표 매핑
                //             var $this = this;

                            

                //             this.selectPointSchoolList.forEach(function(school){
                                
                //                 var lng = school.x;
                //                 var lat = school.y;
                //                 console.log(school.place_name);

                //                 $this.setMarker(school.place_name, lat, lng);
                //             });

                //             var circle = new kakao.maps.Circle({
                //                 center: new kakao.maps.LatLng(lat, lng),
                //                 radius: 1000, // 미터 단위의 원의 반지름입니다 
                //                 strokeWeight: 1, // 선의 두께입니다 
                //                 strokeColor: '#75B8FA', // 선의 색깔입니다
                //                 strokeOpacity: 1, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
                                
                //                 fillColor: '#CFE7FF', // 채우기 색깔입니다
                //                 fillOpacity: 0.4  // 채우기 불투명도 입니다   
                //             }); 

                //             // 지도에 원을 표시합니다 
                            
                //             circle.setMap($this.map); 
                //             $this.circleList.push(circle);
                //         })
                //         .catch((error) => {
                //             this.$swal(
                //                 {icon: 'error', title: '검색에 실패했습니다', text: '검색어를 확인해주세요.', footer: '관심있는 지역의 동 이름을 입력해주세요'}
                //             );
                //             console.log(error);
                //         });


                        
                // },

                

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
                markerInit(){
                    if(this.markerList.length!=0){
                        this.markerList.forEach(function(e){
                            e.setMap(null);
                        });
                    }
                },
                circleInit(){
                     if(this.circleList.length!=0){
                        this.circleList.forEach(function(e){
                            e.setMap(null);
                        });
                    }
                }
            }
        }
</script>
<style>
        .map {
            width: 100%;
            height: 550px;
        }

        .scroll_set {
    -ms-overflow-style: none; /* IE and Edge */
    scrollbar-width: none; /* Firefox */
}

.scroll_set::-webkit-scrollbar {
    display: none; /* Chrome, Safari, Opera*/
}

.select {
    width:200px;
    
}
</style>