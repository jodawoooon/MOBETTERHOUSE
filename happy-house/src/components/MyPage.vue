<template>
    <main class="content">
    <div class="main bg-light p-4">
        <div class="row">
            <div class="col-12 col-xl-8">
                <div class="card card-body shadow-sm mb-4">
                   
                    <form>
                        <div class="row">
                            <div class="col-md-12 mb-3">
                                <div>
                                    <label for="userName">Name</label>
                                    <input :value="this.$store.state.userInfo.userName" v-on:input="updateName" class="form-control" id="userName" type="text" placeholder="Enter your name" required>
                                </div>
                            </div>
                            
                        </div>
                        <div class="row">
                            <div class="col-md-12 mb-3">
                                <div class="form-group">
                                    <label for="userEmail">Email</label>
                                    <input :value="this.$store.state.userInfo.userEmail"  class="form-control" id="userEmail" type="email" placeholder="ssafy@ssafy.com" readonly>
                                </div>
                            </div>
                            
                        </div>
                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <div class="form-group">
                                    <label for="userPassword">Password</label>
                                    <input :value="this.$store.state.userInfo.userPassword" v-on:input="updatePassword" class="form-control" id="userPassword" type="password" placeholder="********" required>
                                </div>
                            </div>
                            <div class="col-md-6 mb-3">
                                <div class="form-group">
                                    <label for="userRank">Rank</label>
                                    <input :value="this.$store.state.userInfo.userRank" v-on:input="updateRank" class="form-control" id="userRank" type="text" placeholder="일반회원" required>
                                </div>
                            </div>
                        </div>
                       
                        <div class="row">
                            <div class="col-sm-12 mb-3">
                                <div class="form-group">
                                    <label for="userMessage">Profile Message</label>
                                    <input :value="this.$store.state.userInfo.userMessage" v-on:input="updateMessage" class="form-control" id="userMessage" type="text" placeholder="프로필 메세지...." required>
                                </div>
                            </div>
                            
                        </div>

                        <div class="row">
                            <div class="col-md-3">
                                <div class="form-group">
                                   
                                    <button type="submit" @click="saveInfo" class="btn btn-dark"><font-awesome-icon :icon="['fas', 'user-edit']"/> 수정</button>
                                    
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="form-group">
                                    
                                    <button type="submit"  @click="deleteInfo" class="btn btn-danger"><font-awesome-icon :icon="['fas', 'eraser']"/> 탈퇴</button>
                                    
                                </div>
                            </div>
                        </div>
                        
                        
                    </form>

                    
                </div>

                <div class="card-body mb-4">
                    <div class="row">
                        <div class="form-group">
                            
                        </div>   
                    </div>
                </div>
                
            </div>
            <div class="col-12 col-xl-4">
                <div class="row">
                    <div class="col-12 mb-4">
                        <div class="card shadow-sm text-center p-0">
                            <div class="profile-cover rounded-top" data-background="../assets/img/profile-cover.jpg"></div>
                            <div class="card-body pb-5">
                                <img :src="requireImg" class="user-avatar large-avatar rounded-circle mx-auto mt-n7 mb-4" alt="Neil Portrait">
                                <h4 class="h3">{{this.$store.state.userInfo.userName}}</h4>
                                
                                <p class="text-gray mb-4">{{this.$store.state.userInfo.userMessage}}</p>
                                
                            </div>
                         </div>
                    </div>
                    <div class="col-12">
                        <div class="card card-body shadow-sm mb-4">
                            <h2 class="h5 mb-4">Select profile photo</h2>
                            <div class="d-flex align-items-center">
                                <div class="me-3">
                                    <!-- Avatar -->
                                    <div class="user-avatar xl-avatar">
                                        <img class="rounded" :src="requireImg" alt="change avatar">
                                    </div>
                                </div>
                                <div class="file-field">
                                    <div class="d-flex justify-content-xl-center ms-xl-3">
                                       <div class="d-flex">
                                          <span class="icon icon-md"><span class="fas fa-paperclip me-3"></span></span> <input type="file">
                                          <div class="d-md-block text-left">
                                             <div class="fw-normal text-dark mb-1">Choose Image</div>
                                             <div class="text-gray small">JPG, GIF or PNG. Max size of 800K</div>
                                          </div>
                                       </div>
                                    </div>
                                 </div>                                        
                            </div>
                        </div>
                    </div>
                    
                </div>
            </div>
        </div>
    </div>
    </main>
</template>

<script>
import Vue from "vue";
import VueAlertify from "vue-alertify";
Vue.use(VueAlertify);

import http from "@/common/axios.js";

export default {
    name : 'MyPage',
    data(){
        return{
            name : this.$store.state.userInfo.userName,
            password : this.$store.state.userInfo.userPassword,
            rank : this.$store.state.userInfo.userRank,
            message : this.$store.state.userInfo.userMessage
        }
    },
    methods: 
    {
        updateName : function(event){
            var updatedText = event.target.value;
            this.name = updatedText;
        },
        updatePassword : function(event){
            var updatedText = event.target.value;
            this.password = updatedText;
        },
        updateRank : function(event){
            var updatedText = event.target.value;
            this.rank = updatedText;
        },
        updateMessage : function(event){
            var updatedText = event.target.value;
            this.message = updatedText;
        },
        deleteInfo(){
            //회원삭제 기능구현
        },
        
      saveInfo(){
      
      http.post(
          "/user/"+ this.$store.state.userInfo.userEmail, 
          {
          userName : this.name,
          userEmail: this.$store.state.userInfo.userEmail,
          userPassword: this.password,
          userRank : this.rank,
          userMessage : this.message,
        }

        )
        .then(({ data }) => {
          console.log("UserVue Info Edit - data : ");
          console.log(data);

          // info 데이터 가져오기
          this.$store.commit('SET_INFO', {
            userPassword : data.userPassword,
            userName: data.userName,
            userEmail : data.userEmail,
            userMessage : data.userMessage,
            
            userProfileImageUrl: data.userProfileImageUrl,
          });
          
        })
        .catch((error) => {
          console.log("UserVue Info Edit - error : ");
          console.log(error);
          if (error.response.status == "404") {
            this.$alertify.error("정보확인에 실패했습니다.");
          } else {
            this.$alertify.error("Opps!! 서버에 문제가 발생했습니다.");
          }
        });
    },
    
    },
    
    computed : {
        requireImg : function(){
      
            if( this.$store.state.userInfo.userProfileImageUrl == '' ) {
                return require('../assets/img/noProfile.png')
            }else{
                return require('../assets' + this.$store.state.userInfo.userProfileImageUrl);
            }
        },
        
    },
    mounted() {
    this.$store.commit('SET_BREADCRUMB_INFO', {
       title: 'MyPage',
        subTitle: '개인 정보 조회/수정/탈퇴',
        desc: '개성있는 프로필 사진을 등록해보세요.',
    });
    this.$store.commit('SET_CUR_PAGE', 'MyPage');
  },
}
</script>

<style>

</style>