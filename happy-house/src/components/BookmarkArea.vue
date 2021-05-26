<template>
  <main class="content">
    <div class="row ">
      <div class="col-8 mt-4 mb-4" style="margin:auto;">
        <div class="card border-light shadow-sm ">
          <div class="card-body">
            <hr class="m-0">
            <div v-for="(select, index) in selectList" :key="index" class="row cust_box" style="cursor: pointer;">
              
              <div class="col-8 p-2 mt-3 align-self-center  " style="text-align:center;">
                <h5>{{ select.sido.SIDO_NAME }} {{ select.gugun.GUGUN_NAME }} {{ select.dong.DONG_NAME }}</h5>
                </div>
              <div class="col p-2 align-self-center">
                <button class="btn btn-secondary mr-3 scale-up-2" style="margin-right:10px;"
                 @click="clickSelect(select)" >매물 보러 가기</button>
                <input
                  type="button"
                  :value="select.isBookmarked ? '해제' : '재등록'"
                  class="btn scale-up-2"
                  :class="select.isBookmarked ? 'btn-danger' : 'btn-outline-danger'"
                  @click="clickBookmarkArea(select)"
                />
              </div>
             <hr class="m-0">
             
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
      desc: '등록한 관심지역의 매물들을 비교해 보세요!',
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

.cust_box:hover{
  background-color: #f1f1f1
}
</style>
