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
                                        <select v-model="selectedGugunName" class="form-select select" aria-label="구">
                                            <option value="empty" selected disabled>구/군</option>
                                            <option v-for="(gugun, index) in selectGugunList" :key="index" :value="gugun.GUGUN_NAME" >{{ gugun.GUGUN_NAME }}</option>
                                        </select>
                                    </div>
                                    
                                    <div class="col align-self-center">
                                        <input type="button" class="btn btn-secondary ml-3" value="검색" @click="searchInfo" :disabled="selectedGugunName == 'empty'" />
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div v-if="infoData" class="col-3 chartDiv">
                                    <h3>인구수</h3>
                                    <info-chart :chart-data="popCollection"></info-chart>
                                </div>
                                <div v-if="infoData" class="col-3 chartDiv">
                                    <h3>인구밀도</h3>
                                    <info-chart :chart-data="popDenCollection"></info-chart>
                                </div>
                                <div v-if="infoData" class="col-3 chartDiv">
                                    <h3>시장</h3>
                                    <info-chart :chart-data="storeCollection"></info-chart>
                                </div>
                                <div v-if="infoData" class="col-3 chartDiv">
                                    <h3>보육시설</h3>
                                    <info-chart :chart-data="nurCollection"></info-chart>
                                </div>
                                
                            
                            </div>
                            <div class="row">
                                    <div v-if="infoData" class="col-3 chartDiv">
                                        <h3>노인복지시설</h3>
                                        <info-chart :chart-data="careCollection"></info-chart>
                                    </div>
                                    <div v-if="infoData" class="col-3 chartDiv">
                                        <h3>공원</h3>
                                        <info-chart :chart-data="parkCollection"></info-chart>
                                    </div>
                                    <div v-if="infoData" class="col-3 chartDiv">
                                        <h3>공공도서관</h3>
                                        <info-chart :chart-data="libCollection"></info-chart>
                                    </div>
                                    <div v-if="infoData" class="col-3 chartDiv">
                                        <h3>주차장</h3>
                                        <info-chart :chart-data="parkingCollection"></info-chart>
                                    </div>
                            </div>
                            
                            
                            
                        </div>

                    </div>
                </div>
                
            </div>
        </main>
</template>

<script>

import http from '@/common/axios.js';
import InfoChart from './InfoChart.vue';

export default {
    name : 'GuInfo',
    components : {InfoChart},
    data(){
        return{
            loadingCount: 0,
            selectSidoList: [],
            selectGugunList: [],

            selectedSidoCode: 'empty',
            selectedGugunCode: 'empty',
            selectedSidoName: 'empty',
            selectedGugunName: 'empty',

            infoData : null,
            avgData : null,
            dataCollection : null,
        }
    },
    mounted(){
        this
                    .$store
                    .commit('SET_BREADCRUMB_INFO', {
                        title: 'AreaInfo',
                        subTitle: '자치구별 정보',
                        desc: '서울특별시 각 자치구별 정보를 확인해 보세요!'
                    });
                this
                    .$store
                    .commit('SET_CUR_PAGE', 'info');

        this.sidoList();
        if(this.$store.state.userInfo.isLogin==false){
                        this.$router.push('/');
                    }
    },
    methods : {
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
                loadingCountUp() {
                    this.loadingCount++;
                },
                loadingCountDown() {
                    this.loadingCount--;
                },
        searchInfo(){
           
                    http
                    .get("/info/"+this.selectedGugunName
                    )
                    .then(({data}) => {
                        console.log("GuINfo - data : ");
                        console.log(data);

                        if (data.result == 'login') {
                            this.$router.push('/login');
                        } else{

                            console.log(data.info);
                            console.log(data.avg);

                            this.$swal(
                            {icon: 'success', title: '정보 검색에 성공했습니다!', text : this.selectedGugunName, showConfirmButton: false, timer: 1500});

                            
                            this.infoData = data.info;
                            this.avgData = data.avg;

                            this.fillData();
    
                        

                        }})
                    .catch((error) => {
                        console.log("GuINfo - error : ");
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
        fillData(){
            this.popCollection = {
                labels : [this.selectedGugunName, '서울시 평균'],
                datasets : [
                    {
                        label: '인구 수',
                        backgroundColor: '#262b40',
                        data : [this.infoData.popNum, this.avgData.popNum],
                    }
                ]
            },
            this.popDenCollection = {
                labels : [this.selectedGugunName, '서울시 평균'],
                datasets : [
                    {
                        label: '인구밀도',
                        backgroundColor: '#262b40',
                        data : [this.infoData.popDensity, this.avgData.popDensity],
                    }
                ]
            },
            this.storeCollection = {
                labels : [this.selectedGugunName, '서울시 평균'],
                datasets : [
                    {
                        label: '시장 수',
                        backgroundColor: '#262b40',
                        data : [this.infoData.storeNum, this.avgData.storeNum],
                    }
                ]
            },
            this.nurCollection = {
                labels : [this.selectedGugunName, '서울시 평균'],
                datasets : [
                    {
                        label: '보육시설 수',
                        backgroundColor: '#262b40',
                        data : [this.infoData.nurseryNum, this.avgData.nurseryNum],
                    }
                ]
            },
            this.careCollection = {
                labels : [this.selectedGugunName, '서울시 평균'],
                datasets : [
                    {
                        label: '노인복지시설 수',
                        backgroundColor: '#262b40',
                        data : [this.infoData.careNum, this.avgData.careNum],
                    }
                ]
            },

            this.parkCollection = {
                labels : [this.selectedGugunName, '서울시 평균'],
                datasets : [
                    {
                        label: '공원 수',
                        backgroundColor: '#262b40',
                        data : [this.infoData.parkNum, this.avgData.parkNum],
                    }
                ]
            },
            this.libCollection = {
                labels : [this.selectedGugunName, '서울시 평균'],
                datasets : [
                    {
                        label: '도서관 수',
                        backgroundColor: '#262b40',
                        data : [this.infoData.libNum, this.avgData.libNum],
                    }
                ]
            },
            this.parkingCollection = {
                labels : [this.selectedGugunName, '서울시 평균'],
                datasets : [
                    {
                        label: '주차장 수',
                        backgroundColor: '#262b40',
                        data : [this.infoData.parkingNum, this.avgData.parkingNum],
                    }
                ]
            },


            this.dataCollection = {
                labels: ['인구 수', '인구 밀도', '시장 수', '보육 시설 수', '노인 복지시설 수', '공원 수', '도서관 수', '주차장 수', 
                    ],
                datasets: [
                    {
                    label: '자치구별 정보',
                    backgroundColor: '#262b40',
                    // Data for the x-axis of the chart
                    data: [this.infoData.popNum, this.infoData.popDensity, this.infoData.storeNum, this.infoData.nurseryNum, this.infoData.careNum, this.infoData.parkNum, this.infoData.libNum, this.infoData.parkingNum],

                    }
                ]
            }
        }
    }
}
</script>

<style>

</style>