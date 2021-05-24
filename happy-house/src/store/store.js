import Vue from 'vue';
import Vuex from 'vuex';
import createPersistedState from 'vuex-persistedstate';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    userInfo: {
      // isLogin: true,

      isKakao: false,
      isLogin: false,
      userSeq: 0,
      userEmail: '',
      userPassword: '',
      userName: '',

      userMessage: '',
      userRank: '',
      userProfileImageUrl: '',
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
      state.userInfo.userSeq = payload.userSeq;
      state.userInfo.userPassword = payload.userPassword;
      state.userInfo.userName = payload.userName;
      state.userInfo.userEmail = payload.userEmail;
      state.userInfo.userMessage = payload.userMessage;

      state.userInfo.userRank = payload.userRank;
      state.userInfo.userProfileImageUrl = payload.userProfileImageUrl;
    },
    SET_LOGOUT(state) {
      state.userInfo.userSeq = 0;
      state.userInfo.isLogin = false;
      state.userInfo.isKakao = false;
      state.userInfo.userPassword = '';
      state.userInfo.userName = '';
      state.userInfo.userEmail = '';
      state.userInfo.userMessage = '';

      state.userInfo.userProfileImageUrl = '';
    },
    SET_INFO(state, payload) {
      state.userInfo.userSeq = payload.userSeq;
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
    getUserSeq(state) {
      return state.userInfo.userSeq;
    },
  },
  modules: {},
  plugins: [createPersistedState()],
});
