<template>
    <main class="content">
        <div class="row">
            <div class="col-12 mb-4">
                <div class="card border-light shadow-sm ">
                    <div class="card-body">


                        <!-- selectbar start  -->
      <div class="col row">
        <div class="col">
          <select v-model="selectedSidoCode" @change="gugunList" class="form-select form-select-sm" aria-label="시">
            <option value="empty" selected disabled>시/도</option>
            <option v-for="(sido, index) in selectSidoList" :key="index" :value="sido.SIDO_CODE">{{ sido.SIDO_NAME }}</option>
          </select>
        </div>
        <div class="col">
          <select v-model="selectedGugunCode" @change="dongList" class="form-select form-select-sm" aria-label="구">
            <option value="empty" selected disabled>구/군</option>
            <option v-for="(gugun, index) in selectGugunList" :key="index" :value="gugun.GUGUN_CODE">{{ gugun.GUGUN_NAME }}</option>
          </select>
        </div>
        <div class="col">
          <select v-model="selectedDongName" class="form-select form-select-sm" aria-label="동">
            <option value="empty" selected disabled>동</option>
            <option v-for="(dong, index) in selectDongList" :key="index" :value="dong.DONG_NAME">{{ dong.DONG_NAME }}</option>
          </select>
        </div>
        <div class="col">
          <input type="button" class="btn btn-warning ml-3" value="검색" @click="searchMap" :disabled="selectedDongName == 'empty'" />
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
                            
                            <div v-if="totalSchoolCnt"><strong>{{searchDong}}</strong>의 학교 검색 결과는 총 <strong>{{totalSchoolCnt}}</strong>건 입니다.
                                <div>
                                검색결과
                                    <div v-for="(item, index) in schoolList" :key="index" >
                                        <p>{{ item.schoolName }}</p>
                                    </div>

                                </div>
                            
                            </div>
                            
                            
                            <div id="map" class="map"></div>
                                
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
                    dongLat: '33.450701',
                    dongLng: '126.570667',
                    map: null,
                    marker: null,
                    schoolList: [],



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
                        desc: '학교정보  -> 동이름 -> 위도경도변환 -> 반경 1km내의 학교 찾기 성공 //// 근데 반경 ~~~km는 가능한데 그 중심점이 애매해서' +
                                ' 동의 범주를 넘어감 => 그냥 백엔드로 공공데이터 가져오기'
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
                        level: 3
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
                drawMap(lat, lng) {
                    var container = document.getElementById('map');
                    var options = {
                        center: new kakao
                            .maps
                            .LatLng(lat, lng),
                        level: 3
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

                searchMap() {
                    // axios2.get('/openapi/tn_pubr_public_elesch_mskul_lc_api?serviceKey=ZR710L6m
                    // yodEEDwC%2FRmFJaTcGb0PckbFCt9LB6nNRAi6%2BLL2j%2FtXCMT%2FDv%2BM9%2BRJwkpyeR8
                    // Ji2RDYiui2Nfbmg%3D%3D&type=json') .then((response)=> {
                    // console.log(response); }).catch((error)=>{    console.log(error); });

                    // axios
                    //     .get('/v2/local/search/address.json?query=서울 ' + this.searchDong, {
                    //         headers: {
                    //             Authorization: 'KakaoAK f4c6ef3414193da426ed5d863808c7d4'
                    //         }
                    //     })
                    //     .then((response) => {
                    //         console.log(response.data.documents[0].address);

                    //         this.dongLat = response
                    //             .data
                    //             .documents[0]
                    //             .y;
                    //         this.dongLng = response
                    //             .data
                    //             .documents[0]
                    //             .x;

                    //         this.drawMap(this.dongLat, this.dongLng);

                    //         this.searchSchool();

                    //     })
                    //     .catch((error) => {
                    //         this.$swal(
                    //             {icon: 'error', title: '검색에 실패했습니다', text: '검색어를 확인해주세요.', footer: '관심있는 지역의 동 이름을 입력해주세요'}
                    //         );
                    //         console.dir(error);
                    //     });


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
                        {icon: 'success', title: '학군 정보 검색에 성공했습니다!', showConfirmButton: false, timer: 1500}

                        
                        
                    
                    );
                    
                    this.setMarker();
                        // this.schoolList.forEach(){

                        // }
                    }
                    

                    

                })
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

                setMarker(){



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