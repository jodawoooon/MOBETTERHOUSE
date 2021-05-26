<template>
  <main class="content">
    <div class="row">
      <div class="col-12 mb-4">
        <div class="card border-light shadow-sm ">
          <div class="card-body">
            <div v-for="(select, index) in selectList" :key="index" class="row" style="cursor: pointer;">
              <div class="col text-underline" @click="clickSelect(select)">{{ select.sido.SIDO_NAME }} {{ select.gugun.GUGUN_NAME }} {{ select.dong.DONG_NAME }}</div>
              <div class="col align-self-center mb-3">
                <input
                  type="button"
                  :value="select.isBookmarked ? '관심 지역 해제' : '관심 지역 등록'"
                  class="btn btn-sm"
                  :class="select.isBookmarked ? 'btn-warning' : 'btn-outline-warning'"
                  @click="clickBookmarkArea(select)"
                />
              </div>
              <div class="col-6"></div>
              <hr />
            </div>
          </div>
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
      selectSidoList: [],
      selectGugunList: [],
      selectDongList: [],
      selectList: [],
    };
  },
  methods: {
    clickBookmarkArea(select) {
      console.log('clickBookmarkArea()!!!!');
      console.log('isBookmarked : ' + select.isBookmarked);
      if (select.isBookmarked) {
        http
          .delete('/bookmarkArea', {
            params: {
              userSeq: this.getUserSeq,
              dongCode: select.dong.DONG_CODE,
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
            dongCode: select.dong.DONG_CODE,
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
      select.isBookmarked = !select.isBookmarked;
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
            for (var i = 0; i < this.selectSidoList.length; i++) {
              this.gugunList(this.selectSidoList[i]);
            }
          }
        });
    },
    gugunList(sido) {
      console.log('gugunList() is called!!!!!!');
      http
        .get('/gugun', {
          params: {
            sidoCode: sido.SIDO_CODE,
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
            for (var i = 0; i < this.selectGugunList.length; i++) {
              this.dongList(sido, this.selectGugunList[i]);
            }
          }
        });
    },
    dongList(sido, gugun) {
      console.log('dongList() is called!!!!!!!');
      http
        .get('/dong', {
          params: {
            sidoCode: sido.SIDO_CODE,
            gugunCode: gugun.GUGUN_CODE,
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
            for (var i = 0; i < this.selectDongList.length; i++) {
              this.makeList(sido, gugun, this.selectDongList[i]);
            }
          }
        });
    },
    makeList(sido, gugun, dong) {
      this.selectList.push({
        sido: sido,
        gugun: gugun,
        dong: dong,
        isBookmarked: true,
      });
    },
    clickSelect(select) {
      console.log('before push : ');
      console.log(select.sido);
      this.$router.push({
        name: 'SearchDong',
        params: {
          select: select,
        },
      });
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
