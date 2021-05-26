<template>
  <main class="content">
    <div class="row">
      <div class="col-12 mb-4">
        <div class="card border-light shadow-sm ">
          <div class="card-body"></div>
        </div>
      </div>
    </div>
  </main>
</template>

<script>
import http from '@/common/axios.js';
import router from '@/routers/routers.js';
import { mapGetters } from 'vuex';

export default {
  name: 'BookmarkArea',
  components: {},
  data() {
    return {
      houseList: [],
      houseListCount: 0,
      limit: 10,
      offset: 0,

      selectSidoList: [],
      selectGugunList: [],
      selectDongList: [],
    };
  },
  methods: {
    clickBookmarkArea() {
      console.log('clickBookmarkArea()!!!!');
      console.log('isBookmarked : ' + this.isBookmarked);
      if (this.isBookmarked) {
        http
          .delete('/bookmarkArea', {
            params: {
              userSeq: this.getUserSeq,
              dongCode: this.selectedDongCode,
            },
          })
          .then(({ data }) => {
            console.log('deleteBookmark!!!!!!');
            console.log(data);
            if (data.result == 'login') {
              router.push('/login');
            }
          })
          .catch((error) => {
            console.log(error);
          });
      } else {
        http
          .post('/bookmarkArea', {
            userSeq: this.getUserSeq,
            dongCode: this.selectedDongCode,
          })
          .then(({ data }) => {
            console.log('insertBookmark!!!!!!');
            console.log(data);
            if (data.result == 'login') {
              router.push('/login');
            }
          })
          .catch((error) => {
            console.log(error);
          });
      }
      this.isBookmarked = !this.isBookmarked;
    },

    sidoList() {
      console.log('sidoList() is called!!!!!!');
      http
        .get('/sido', {
          params: {
            userSeq: this.getUserSeq,
          },
        })
        .then(({ data }) => {
          console.log('sidoList : ');
          console.log(data);
          if (data.result == 'login') {
            router.push('/login');
          } else {
            this.selectSidoList = data;
            this.gugunList();
          }
        });
    },
    gugunList() {
      console.log('gugunList() is called!!!!!!');
      http
        .get('/gugun', {
          params: {
            sidoCode: this.selectedSidoCode,
            userSeq: this.getUserSeq,
          },
        })
        .then(({ data }) => {
          console.log('gugunList : ');
          console.log(data);
          if (data.result == 'login') {
            router.push('/login');
          } else {
            this.selectGugunList = data;
            this.dongList();
          }
        });
    },
    dongList() {
      console.log('dongList() is called!!!!!!!');
      http
        .get('/dong', {
          params: {
            sidoCode: this.selectedSidoCode,
            gugunCode: this.selectedGugunCode,
            userSeq: this.getUserSeq,
          },
        })
        .then(({ data }) => {
          console.log('dongList : ');
          console.log(data);
          if (data.result == 'login') {
            router.push('/login');
          } else {
            this.selectDongList = data;
            this.makeList();
          }
        });
    },
    makeList() {
      for (var i = 0; i < this.selectSidoList.length; i++) {
        for (var j = 0; j < this.selectGugunList.length; j++) {
          for (var k = 0; k < this.selectDongList.length; k++) {}
        }
      }
    },
  },
  computed: {
    ...mapGetters(['getUserSeq']),
  },

  created() {
    this.sidoList();
  },
  mounted() {
    this.$store.commit('SET_BREADCRUMB_INFO', {
      isHome: false,
      title: '관심 지역 모아 보기',
      subTitle: '관심 지역 모아 보기',
      desc: '관심 지역의 매물을 확인하세요.',
    });
    this.$store.commit('SET_CUR_PAGE', 'bookmarkArea');
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

.select {
  width: 200px;
}
</style>
