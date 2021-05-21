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
          <input type="button" class="btn btn-warning ml-3" value="검색" @click="searchList" :disabled="selectedDongCode == 'empty'" />
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
    <div class="mt-4" v-if="loadingCount == 0">
      <pagination :listRowCount="listRowCount" :pageLinkCount="pageLinkCount" :currentPageIndex="currentPageIndex" :houseListcount="houseListCount" @call-parent="movePage"></pagination>
    </div>
  </main>
</template>

<script>
import http from '@/common/axios.js';
import router from '@/routers/routers.js';
import PulseLoader from 'vue-spinner/src/PulseLoader.vue';
import Pagination from './Pagination.vue';

export default {
  name: 'SearchDong',
  components: {
    PulseLoader,
    Pagination,
  },
  data() {
    return {
      loadingCount: 0,

      houseList: [],
      houseListCount: 0,
      limit: 10,
      offset: 0,

      // pagination
      listRowCount: 10,
      pageLinkCount: 10,
      currentPageIndex: 1,

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
              searchType: '',
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
              // this.kakaoMap(list);
            }
          });
      } else {
        console.log('this.selectedDongCode is not empty');
        this.loadingCountUp();
        http
          .get('/house', {
            params: {
              limit: this.limit,
              offset: this.offset,
              searchWord: this.selectedDongCode,
              searchType: 'dong',
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
    // kakaoMap(list) {
    //   var mapContainer = document.querySelector('#map');
    //   var options = {
    //     center: new kakao.maps.LatLng(list[1].lat, list[1].lng),
    //     level: 4,
    //   };

    //   var map = new kakao.maps.Map(mapContainer, options);
    //   // 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
    //   var mapTypeControl = new kakao.maps.MapTypeControl();

    //   // 지도에 컨트롤을 추가해야 지도위에 표시됩니다
    //   // kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
    //   map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

    //   // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
    //   var zoomControl = new kakao.maps.ZoomControl();
    //   map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

    //   var positions = [];
    //   for (var i = 0; i < list.length; i++) {
    //     positions.push({
    //       content: document.getElementById('apartInfo-' + String(i + 1)).innerHTML,
    //       latlng: new kakao.maps.LatLng(list[i].lat, list[i].lng),
    //     });
    //   }

    //   for (var i = 0; i < positions.length; i++) {
    //     var marker = new kakao.maps.Marker({
    //       map: map,
    //       position: positions[i].latlng, // 마커를 표시할 위치
    //     });

    //     var infowindow = new kakao.maps.InfoWindow({
    //       content: positions[i].content, // 인포윈도우에 표시할 내용
    //     });

    //     kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
    //     kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
    //   }

    //   // 인포윈도우를 표시하는 클로저를 만드는 함수입니다
    //   function makeOverListener(map, marker, infowindow) {
    //     return function() {
    //       infowindow.open(map, marker);
    //     };
    //   }

    //   // 인포윈도우를 닫는 클로저를 만드는 함수입니다
    //   function makeOutListener(infowindow) {
    //     return function() {
    //       infowindow.close();
    //     };
    //   }
    // },

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
    // pagination
    movePage(pageIndex) {
      console.log('SearchDong.vue : movePage : pageIndex : ' + pageIndex);
      this.offset = (pageIndex - 1) * this.listRowCount;
      this.currentPageIndex = pageIndex;

      this.searchList();
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
