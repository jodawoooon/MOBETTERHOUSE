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
                                        placeholder="Search"
                                        aria-label="Search"></div>
                                </div>
                                <div class="col-2">
                                    <button class="btn btn-secondary" @click="searchSchool">검색</button>
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

    export default {
        name: 'SchoolZone',
        data() {
            return {searchDong: ''}
        },
        mounted() {
            this
                .$store
                .commit('SET_BREADCRUMB_INFO', {
                    title: 'SchoolZone',
                    subTitle: '학군 정보 확인',
                    desc: '관심있는 지역의 학교 정보를 확인 해 보세요!'
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
                        .LatLng(33.450701, 126.570667),
                    level: 3
                };

                var map = new kakao.maps.Map(container, options);
                var marker = new kakao.maps.Marker({ position: map.getCenter() }); 
                marker.setMap(map);


            },


            searchSchool() {
                
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