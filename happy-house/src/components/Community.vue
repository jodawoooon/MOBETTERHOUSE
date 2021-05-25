<template>
  <main class="content">
    <div class="row">
      <div class="col-12 mb-4">
        <div class="card border-light shadow-sm ">
          <div class="card-body">

    <!-- <h1>This is Community.vue</h1> -->
    <h4 class="text-center">게시판 - Community</h4>
    <div class="input-group mb-3">
    <!-- store 사용 -->
    <!-- <input v-model="searchWord" @keydown.enter="boardList" type="text" class="form-control"> -->
    <input v-model="$store.state.board.searchWord" @keydown.enter="boardList" type="text" class="form-control">
    <button @click="boardList" class="btn btn-success" type="button" >Search</button>
    </div>

    <table class="table table-hover">
      <thead>
        <tr>
          <th>#</th>
          <th>제목</th>
          <th>작성자</th>
          <th>작성일시</th>
          <th>조회수</th>
        </tr>
      </thead>
        <tbody>
          <!-- store 사용 -->

          <!-- 직접 store 에 접근해도 된다. -->
          <!-- <tr v-for="(board, index) in $store.state.board.list" @click="boardDetail(board.boardId)" v-bind:key="index"> -->
          
          <!-- getters 를 이용하는 코드 -->
          <!-- computed - listGetters - getBoardList  -->
          <tr v-for="(board, index) in listGetters" @click="boardDetail(board.boardId)" v-bind:key="index">
            <td>{{ board.boardId }}</td>
            <td>{{ board.title }}</td>
            <td>{{ board.userName }}</td>

            <!-- function 을 바로 사용하는 경우 -->
            <!-- <td>{{ makeDateStr(board.regDt.date.year, board.regDt.date.month, board.regDt.date.day, '.') }}</td> -->

            <!-- computed + index 를 사용하는 경우 -->
            <td>{{ formatDate[index] }}</td>
            
            <td>{{ board.readCount }}</td>
          </tr>
        </tbody>
      </table>

      <pagination v-on:call-parent="movePage"></pagination>

    <button class="btn btn-sm btn-primary" @click="showInsertModal">글쓰기</button>

    <insert-modal v-on:call-parent-insert="closeAfterInsert"></insert-modal>
    <!-- props 제거 -->
    <detail-modal v-on:call-parent-change-to-update="changeToUpdate" v-on:call-parent-change-to-delete="changeToDelete"></detail-modal>
    <update-modal v-on:call-parent-update="closeAfterUpdate"></update-modal>
  
          </div>
        </div>
      </div>
    </div>
  </main>
</template>

<script>
import InsertModal from './modals/InsertModal.vue';
import DetailModal from './modals/DetailModal.vue';
import UpdateModal from './modals/UpdateModal.vue';

import { Modal } from 'bootstrap';

import http from "@/common/axios.js";
import util from "@/common/util.js";

import Pagination from './Pagination2.vue';

// 삭제
import Vue from 'vue';
import VueAlertify from 'vue-alertify'; 
Vue.use(VueAlertify);

export default {
  name: 'Community',
  components: { InsertModal, DetailModal, UpdateModal, Pagination },
  data(){
    return {
      // modal
      insertModal : null,
      detailModal : null,
      updateModal : null,

      breadCrumbInfo: {
        title: 'Community',
        subTitle: '커뮤니티',
        desc: '커뮤니티에서 자유롭게 소통하세요.',
      },
      // 아래 data 사용 X
      // // list
      // list: [],
      // limit: 10,
      // offset: 0,
      // searchWord: '',

      // // pagination
      // listRowCount: 10,
      // pageLinkCount: 10,
      // currentPageIndex: 1,

      // totalListItemCount: 0,

      // // detail
      // boardId: 0,

      // // update
      // board: {
      //   boardId: 0,
      //   title: '',
      //   content: '',
      //   fileList: []
      // }
    }
  },
  computed :{
    // gttters 이용
    listGetters(){
      return this.$store.getters.getBoardList; // no getBoardList()
    },
    formatDate : function(){
      let $this = this;
      // store 사용
      return this.$store.state.board.list.map( function( board ){
        return $this.makeDateStr(board.regDt.date.year, board.regDt.date.month, board.regDt.date.day, '.')
      });
    }
  },
  methods : {

    // list
    // store actions 에 구현
    // 가능한 한 가지 방법
    boardList(){
      this.$store.dispatch('boardList');
    },

    // pagination
    movePage(pageIndex){
      console.log("BoardMainVue : movePage : pageIndex : " + pageIndex );

      // store commit 으로 변경
      // this.offset = (pageIndex - 1) * this.listRowCount;
      // this.currentPageIndex = pageIndex;
      this.$store.commit( 'SET_BOARD_MOVE_PAGE', pageIndex );


      this.boardList();
    },

    // util
    makeDateStr : util.makeDateStr,

    // insert
    showInsertModal(){
      this.insertModal.show();
    },

    closeAfterInsert(){
      this.insertModal.hide();
      this.boardList();
    },

    // detail
    // board-vue 와 다르게 구현해 봄
    // Detail Component 에서 Server 요청을 하지 않고 이곳에서 수행 후에 Detail 보여줌
    boardDetail(boardId){
      // store 변경
      // this.boardId = boardId;
      // this.$store.commit('mutateSetBoardBoardId', boardId);

      http.get(
      '/boards/' + boardId, // props variable
      )
      .then(({ data }) => {
        console.log("DetailModalVue: data : ");
        console.log(data);

        if( data.result == 'login' ){
          this.$router.push("/login")
        }else{
          this.$store.commit(
            'SET_BOARD_DETAIL',
            { 
              boardId: data.dto.boardId,
              title: data.dto.title,
              content: data.dto.content,
              regDt: this.makeDateStr(data.dto.regDt.date.year, data.dto.regDt.date.month, data.dto.regDt.date.day, '.'),
              fileList: data.dto.fileList,
              isOwner: data.isOwner, // not data.dto.isOwner

            }
          );

          this.detailModal.show();
        }
      })
      .catch((error) => {
        console.log("DetailModalVue: error ");
        console.log(error);
      });


    },

    // update
    // Detail 에서 board data 를 직접 변경
    // changeToUpdate( board ){
    //   this.board = board; 
    //   this.detailModal.hide();
    //   this.updateModal.show();
    // },
    changeToUpdate(){ // board parameter 필요 없음.
      // data update 사용 X
      // this.board = board; 
      this.detailModal.hide();
      this.updateModal.show();
    },

    closeAfterUpdate(){
      // boardId 초기화 필요 X watch 사용 X
      //this.boardId = 0;

      this.updateModal.hide();
      this.boardList();
    },

    // delete
    // $emit board 사용 X
    // changeToDelete(board){
    changeToDelete(){
      this.detailModal.hide();

      var $this = this; // alertify.confirm-function()에서 this 는 alertify 객체
      this.$alertify.confirm(
        //'삭제 확인', '이 글을 삭제하시겠습니까?', <- ???? title 추가하면 cancel이 ok 처럼 동작
        '이 글을 삭제하시겠습니까?',
        function(){
          // board.boardId 사용 X
          $this.boardDelete(); // $this 사용
        },
        function(){
          console.log('cancel');
        }
      );
    },
    boardDelete(){ // parameter 사용 X
      http.delete(
        "/boards/" + this.$store.state.board.boardId
        )
        .then(({ data }) => {
          console.log("BoardMainVue: data : ");
          console.log(data);
          if( data.result == 'login' ){
            this.$router.push("/login")
          }else{
            this.boardList();
          }
        })
        .catch( error => {
            console.log(error)
        });
      }
  },
  created() {
    
  },
  mounted() {
    this.insertModal = new Modal(document.getElementById('insertModal'));
    this.detailModal = new Modal(document.getElementById('detailModal'));
    this.updateModal = new Modal(document.getElementById('updateModal'));

    this.$store.commit('SET_BREADCRUMB_INFO', {
      title: 'Community',
      subTitle: '커뮤니티',
      desc: '커뮤니티에서 자유롭게 소통하세요.',
    });
    this.$store.commit('SET_CUR_PAGE', 'community');
    this.$store.dispatch("boardList");
  },

}
</script>

<style></style>
