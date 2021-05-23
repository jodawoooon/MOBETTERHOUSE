<template>
    <main class="content">
        <div class="row">
            <div class="col-12 mb-4">
                <div class="card border-light shadow-sm ">
                    <div class="card-body">

                        <!-- searchBar start -->
                        <div class="row mb-3">
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
                            </div>
                            <!-- searchBar end -->

                            <div id="map" class="map"></div>
                            <div id="clickLatlng"></div>
                        </div>
                    </div>

                </div>
            </div>
        </main>
</template>

<script>

//import axios2 from 'axios';
//axios2.defaults.baseURL = 'http://api.data.go.kr/';
//axios2.defaults.headers.post['Content-Type'] = 'application/json;charset=utf-8';
//axios2.defaults.headers.post['Access-Control-Allow-Origin'] = '*';



import axios from 'axios';

axios.defaults.baseURL = 'https://dapi.kakao.com/';
axios.defaults.headers.post['Content-Type'] = 'application/json;charset=utf-8';
axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';




    export default {
        name: 'SchoolZone',
        data() {
            return {
                totalSchoolCnt : '',
                searchDong: '',
                dongLat :'33.450701',
                dongLng : '126.570667',
                map : null,
                marker : null,
                schoolList : [],
                }
        },
        mounted() {
            this
                .$store
                .commit('SET_BREADCRUMB_INFO', {
                    title: 'SchoolZone',
                    subTitle: '주변 학군 정보',
                    desc: '학교정보  -> 동이름 -> 위도경도변환 -> 반경 1km내의 학교 찾기 성공 //// 근데 반경 ~~~km는 가능한데 그 중심점이 애매해서 동의 범주를 넘어감'
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

                this.map = new kakao.maps.Map(container, options);
                this.marker = new kakao.maps.Marker({ position: this.map.getCenter() }); 
                this.marker.setMap(this.map);


            },
            searchSchool(){
                var url = '/v2/local/search/category.json?category_group_code=SC4'
                + '&x=' + this.dongLng + '&y=' + this.dongLat + '&radius=2000&sort=distance'
                axios.get(url,{
                    headers : {
                        Authorization: 'KakaoAK f4c6ef3414193da426ed5d863808c7d4'
                    }
                }).then((response)=>{
                    console.log(response.data);
                }).catch((error) => {
                    this.$swal(
                        {icon: 'error',
                title: '검색에 실패했습니다',
                text: '검색어를 확인해주세요.',
                footer: '관심있는 지역의 동 이름을 입력해주세요'}
                    );
                    console.log(error);
                });
            },
            drawMap(lat,lng){
                var container = document.getElementById('map');
                var options = {
                    center: new kakao
                        .maps
                        .LatLng(lat, lng),
                    level: 3
                };

                
                this.map = new kakao.maps.Map(container, options);
                this.marker = new kakao.maps.Marker({ position: this.map.getCenter() }); 
                this.marker.setMap(this.map);

            },



            searchMap() {
                //axios2.get('/openapi/tn_pubr_public_elesch_mskul_lc_api?serviceKey=ZR710L6myodEEDwC%2FRmFJaTcGb0PckbFCt9LB6nNRAi6%2BLL2j%2FtXCMT%2FDv%2BM9%2BRJwkpyeR8Ji2RDYiui2Nfbmg%3D%3D&type=json')
                //.then((response)=> {
                //    console.log(response);
                //}).catch((error)=>{
                //    console.log(error);
                //});

                axios
        .get('/v2/local/search/address.json?query='+'서울 '+this.searchDong,{
            headers : {
                Authorization: 'KakaoAK f4c6ef3414193da426ed5d863808c7d4'
            }
        }
        )
        .then((response) => {
          console.log(response.data.documents[0].address);

          this.dongLat = response.data.documents[0].y;
          this.dongLng = response.data.documents[0].x;

                this.drawMap(this.dongLat, this.dongLng);

                this.searchSchool();
          
        })
        .catch((error) => {
            this.$swal(
                        {icon: 'error',
                title: '검색에 실패했습니다',
                text: '검색어를 확인해주세요.',
                footer: '관심있는 지역의 동 이름을 입력해주세요'}
                    );
          console.dir(error);
        });


            }
        }
    }
</script>
<style>
.map {
  width: 100%;
  height: 400px;
}
</style>