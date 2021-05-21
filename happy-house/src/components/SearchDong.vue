<template>
  <main class="content">
    <div class="main bg-light p-4">
      <!-- selectbar start  -->
      <div class="col row">
        <div class="col">
          <select id="selectSido" class="form-select form-select-sm" aria-label="시">
            <option selected disabled>시/도</option>
          </select>
        </div>
        <div class="col">
          <select id="selectGugun" class="form-select form-select-sm" aria-label="구">
            <option selected disabled>구/군</option>
          </select>
        </div>
        <div class="col">
          <select id="selectDong" class="form-select form-select-sm" aria-label="동">
            <option selected disabled>동</option>
          </select>
        </div>
        <div class="col">
          <input type="button" id="btnSearch" class="btn btn-warning ml-3" value="검색" disabled />
        </div>
      </div>
      <!-- selectbar end  -->

      <div class="row m-1">
        <div class="col-4" id="apartInfo">
          <!-- tempInfo start -->
          <div v-for="(house, index) in houseList" :key="index" class="apart row" :id="apartInfo - (index + 1)">
            <div class="col-8">
              <h5>{{ house.aptName }}</h5>
              <p class="m-0">거래금액: {{ house.dealAmount }}</p>
              <p class="m-0">전용면적: {{ house.area }}</p>
              <p class="m-0">등록일: {{ house.dealDate }}</p>
            </div>
            <div class="col align-self-center" style="text-align: center">
              <i class="bi bi-star bookmarkStar" id="bookmarkStar' + (i + 1) + '" aria-hidden="true" style="color: rgb(255, 226, 95); font-size: 25px">
                <input type="hidden" value="' + dealNo + '" />
              </i>
            </div>
            <hr />
          </div>
          <!-- tempInfo end -->
        </div>
        <div id="map" class="col-8 border border-5" style="height: 550px">Map</div>
      </div>
    </div>
    <div id="paginationWrapper" class="align-self-center">PaginationWrapper</div>
    <div class="mt-4"></div>
  </main>
</template>

<script>
import http from '@/common/axios.js';
import router from '@/routers/routers.js';

export default {
  name: 'SearchDong',
  data() {
    return {
      houseList: [],
      houseListCount: 0,
      limit: 10,
      offset: 0,
      searchWord: '',
    };
  },
  methods: {
    searchList() {
      console.log('searchList() is called!!!!!!');
      if (this.searchWord == '') {
        console.log('searchWord is empty');
        http
          .get('/house', {
            params: {
              limit: this.limit,
              offset: this.offset,
            },
          })
          .then(({ data }) => {
            console.log('searchList : ');
            console.log(data);
            if (data.result == 'login') {
              router.push('/login');
            } else {
              this.houseList = data.list;
              this.houseListCount = data.count;
            }
          });
      }
    },
  },
  created() {
    this.searchList();
  },
  mounted() {
    this.$store.commit('SET_BREADCRUMB_INFO', {
      title: 'SearchDong',
      subTitle: '동으로 매물 / 거래정보 검색',
      desc: '원하는 지역의 매물정보를 확인해보세요.',
    });
    this.$store.commit('SET_CUR_PAGE', 'searchDong');
  },
};
</script>

<style></style>
