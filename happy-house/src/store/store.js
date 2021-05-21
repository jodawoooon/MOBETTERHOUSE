import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

// import http from '@/common/axios.js';
// import router from '@/routers/routers.js';

export default new Vuex.Store({
  state: {
    userInfo: {
      isLogin: false,
      userEmail: 'ssafy@ssafy.com',
      userPassword: '1234',
      userName: '손동우',
      userProfileImageUrl: require('../assets/img/noProfile.png'),
    },
    breadCrumbInfo: {
      title: 'Home',
      subTitle: '메인 페이지',
      desc: '뭔가 메인 페이지가 필요할 것 같다.',
    },
    curPage: 'Home',
  },
  mutations: {
    SET_BREADCRUMB_INFO(state, breadCrumbInfo) {
      state.breadCrumbInfo = breadCrumbInfo;
    },
    SET_CUR_PAGE(state, curPage) {
      state.curPage = curPage;
    },
  },
  actions: {},
  getters: {
    getIsLogin(state) {
      return state.login.isLogin;
    },
    getCurPage(state) {
      return state.curPage;
    },
  },
});
