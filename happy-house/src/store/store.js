import Vue from 'vue';
import Vuex from 'vuex';
// import createPersistedState from 'vuex-persistedstate';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    userInfo: {
      // isLogin: true,

      isKakao: false,
      isLogin: true,
      userEmail: 'daun@daun.net',
      userPassword: '1234',
      userName: 'dauen',

      userMessage: 'hihi',
      userRank: '1',
      userProfileImageUrl: '/img/noProfile.png',
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
    SET_LOGIN(state, payload) {
      state.userInfo.isLogin = true;
      state.userInfo.userPassword = payload.userPassword;
      state.userInfo.userName = payload.userName;
      state.userInfo.userEmail = payload.userEmail;
      state.userInfo.userMessage = payload.userMessage;

      state.userInfo.userRank = payload.userRank;
      state.userInfo.userProfileImageUrl = payload.userProfileImageUrl;
    },
    SET_LOGOUT(state) {
      state.userInfo.isLogin = false;
      state.userInfo.isKakao = false;
      state.userInfo.userPassword = '';
      state.userInfo.userName = '';
      state.userInfo.userEmail = '';
      state.userInfo.userMessage = '';

      state.userInfo.userProfileImageUrl = '';
    },
    SET_INFO(state, payload) {
      state.userInfo.userPassword = payload.userPassword;
      state.userInfo.userName = payload.userName;
      state.userInfo.userEmail = payload.userEmail;
      state.userInfo.userMessage = payload.userMessage;

      state.userInfo.userProfileImageUrl = payload.userProfileImageUrl;
    },
    SET_KAKAO(state) {
      state.userInfo.isKakao = true;
    },
  },
  actions: {},
  getters: {
    getIsLogin(state) {
      return state.userInfo.isLogin;
    },
    getCurPage(state) {
      return state.curPage;
    },
  },
  modules: {},
  // plugins: [createPersistedState()],
});
