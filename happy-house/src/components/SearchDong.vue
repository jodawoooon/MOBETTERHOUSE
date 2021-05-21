<template>
  <main class="content">
    <div class="main bg-light p-4">
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
          <select v-model="selectedDongCode" class="form-select form-select-sm" aria-label="동">
            <option value="empty" selected disabled>동</option>
            <option v-for="(dong, index) in selectDongList" :key="index" :value="dong.DONG_CODE">{{ dong.DONG_NAME }}</option>
          </select>
        </div>
        <div class="col">
          <input type="button" class="btn btn-warning ml-3" value="검색" disabled />
        </div>
      </div>
      <!-- selectbar end  -->

      <div class="row m-1">
        <div class="col-4" id="apartInfo">
          <div v-if="loadingCount != 0" class="d-flex align-items-center justify-content-center" style="height:500px;">
            <pulse-loader :loading="loadingCount != 0"></pulse-loader>
          </div>
          <!-- aptInfo start -->
          <div v-else>
            <div v-for="(house, index) in houseList" :key="index" class="apart row" :id="'apartInfo' + (index + 1)">
              <div class="col-8">
                <h5>{{ house.aptName }}</h5>
                <p class="m-0">거래금액: {{ house.dealAmount }}</p>
                <p class="m-0">전용면적: {{ house.area }}</p>
                <p class="m-0">등록일: {{ house.dealDate }}</p>
              </div>
              <div class="col align-self-center" style="text-align: center">
                <font-awesome-icon :icon="['far', 'star']" :id="'bookmarkStar' + (index + 1)" aria-hidden="true" style="color: rgb(255, 226, 95); font-size: 25px">
                  <input type="hidden" value="' + dealNo + '" />
                </font-awesome-icon>
              </div>
              <hr />
            </div>
          </div>
          <!-- aptInfo end -->
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
import PulseLoader from 'vue-spinner/src/PulseLoader.vue';

export default {
  name: 'SearchDong',
  components: {
    PulseLoader,
  },
  data() {
    return {
      loadingCount: 0,

      houseList: [],
      houseListCount: 0,
      limit: 10,
      offset: 0,

      selectSidoList: [],
      selectGugunList: [],
      selectDongList: [],
      selectedSidoCode: 'empty',
      selectedGugunCode: 'empty',
      selectedDongCode: 'empty',
    };
  },
  methods: {
    loadingCountUp() {
      this.loadingCount++;
    },
    loadingCountDown() {
      this.loadingCount--;
    },
    searchList() {
      console.log('searchList() is called!!!!!!');
      if (this.selectedDongCode == 'empty') {
        console.log('this.selectedDongCode is empty');
        this.loadingCountUp();
        http
          .get('/house', {
            params: {
              limit: this.limit,
              offset: this.offset,
              searchWord: '',
            },
          })
          .then(({ data }) => {
            console.log('searchList : ');
            console.log(data);
            this.loadingCountDown();
            if (data.result == 'login') {
              router.push('/login');
            } else {
              this.houseList = data.list;
              this.houseListCount = data.count;
            }
          });
      }
    },
    sidoList() {
      console.log('sidoList() is called!!!!!!');
      this.loadingCountUp();
      http.get('/sido').then(({ data }) => {
        console.log('sidoList : ');
        console.log(data);
        this.loadingCountDown();
        if (data.result == 'login') {
          router.push('/login');
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
            router.push('/login');
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
            router.push('/login');
          } else {
            this.selectDongList = data;
          }
        });
    },
  },
  created() {
    this.searchList();
    this.sidoList();
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

<style scoped>
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
</style>
