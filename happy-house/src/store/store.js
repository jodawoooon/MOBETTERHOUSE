import Vue from 'vue';
import Vuex from 'vuex';
import createPersistedState from 'vuex-persistedstate';

Vue.use(Vuex);


import http from "@/common/axios.js";
import router from '@/routers/routers.js'

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
      isHome: false,
      title: 'Home',
      subTitle: '메인 페이지',
      desc: '뭔가 메인 페이지가 필요할 것 같다.',
    },
    board:{
      // list
      list: [],
      limit: 10,
      offset: 0,
      searchWord: '',

      // pagination
      listRowCount: 10,
      pageLinkCount: 10,
      currentPageIndex: 1,

      totalListItemCount: 0,

      // detail, update, delete
      boardId: 0,
      title: '',
      content: '',
      userName: '',
      regDt: {},
      readCount: 0,
      fileList: [],
      isOwner: false
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
      console.log("login success");
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
    SET_BOARD_LIST(state, list){
      state.board.list = list
    },

    SET_BOARD_TOTAL_LIST_ITEM_COUNT(state, count){
      state.board.totalListItemCount = count
    },

    SET_BOARD_MOVE_PAGE(state, pageIndex){
      state.board.offset = (pageIndex - 1) * state.board.listRowCount;
      state.board.currentPageIndex = pageIndex;
    },
    SET_BOARD_DETAIL(state, payload){
      state.board.boardId = payload.boardId
      state.board.title = payload.title;
      state.board.content = payload.content;
      state.board.userName = payload.userName;
      state.board.regDt = payload.regDt;
      state.board.fileList = payload.fileList;
      state.board.isOwner = payload.isOwner;
    },
  },
  actions: {
    boardList(context){
      http.get(
        "/boards",
        {
          // get query string
          params: {
            limit: this.state.board.limit,
            offset: this.state.board.offset,
            searchWord: this.state.board.searchWord
          }
        })
        .then(({ data }) => {
          console.log("BoardMainVue: data : ");
          console.log(data);
          if( data.result == 'login' ){
            router.push("/login")
          }else{
            context.commit( 'SET_BOARD_LIST', data.list );
            context.commit( 'SET_BOARD_TOTAL_LIST_ITEM_COUNT', data.count );
          }
      });
    }
  },
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
    getBoardList : function(state){
      return state.board.list;
    },
  },
  modules: {},
  plugins: [createPersistedState()],
});
