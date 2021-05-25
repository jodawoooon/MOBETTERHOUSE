<template>
    <main class="content">
        
                
    <div class="main bg-light p-4">

        <div class="row">
            <div class="col-12 col-xl-8">
                <div class="card card-body shadow-sm mb-4 ">
                   
                    <form>
                        <div class="row mt-3">
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
                                    <div v-if="this.$store.state.userInfo.isKakao">

                                        <input :value="this.$store.state.userInfo.userPassword" v-on:input="updatePassword" class="form-control" 
                                            id="userPassword" type="password" placeholder="********" readonly
                                        >
                                        <p>KAKAO LOGIN 상태입니다.</p>
                                    </div>
                                    <div v-if="this.$store.state.userInfo.isKakao==false">

                                        <input :value="this.$store.state.userInfo.userPassword" v-on:input="updatePassword" class="form-control" 
                                            id="userPassword" type="password" placeholder="********" required
                                        >
                                    </div>
                                </div>
                            </div>
                            
                            <div class="col-md-6 mb-3">
                                <div class="form-group">
                                    <label for="userRank">Rank</label>
                                    <input :value="this.$store.state.userInfo.userRank" v-on:input="updateRank" class="form-control" id="userRank" type="text" readonly>
                                </div>
                            </div>
                        </div>
                       
                        <div class="row">
                            <div class="col-sm-12 mb-3">
                                <div class="form-group">
                                    <label for="userMessage">Profile Message</label>
                                    <textarea :value="this.$store.state.userInfo.userMessage" v-on:input="updateMessage" class="form-control" id="userMessage" row=4 placeholder="프로필 메세지...." required></textarea>
                                </div>
                            </div>
                            
                        </div>

                        <div class="row mb-3 mt-3">
                            
                            <div class="col">
                                <div class="form-group">
                                    <div class="btn-group" style="float:right;" >
                                    <button type="submit" id="successAlert" @click="saveInfo" class="btn btn-outline-dark"><font-awesome-icon :icon="['fas', 'user-edit']"/> 수정</button>
                                    </div>

                                </div>
                            </div>
                            
                        </div>
                        
                        
                    </form>

                    
                </div>

                <div class="card-body">
                    <div class="row">
                        <div class="form-group">
                            <div class="btn-group " style="float:right;" >
                            <button type="submit"  @click="showDeleteModal" class="btn btn-outline-danger"><font-awesome-icon :icon="['fas', 'eraser']"/> 탈퇴</button>
                            </div>
                        </div>   
                    </div>
                </div>
                
            </div>
            <div class="col-12 col-xl-4">
                <div class="row">
                    <div class="col-12 mb-4">
                        <div class="card shadow-sm text-center p-0">
                            <div class="profile-cover rounded-top" :style="{ backgroundImage: 'url(' + require('@/assets/img/profile-cover.jpg') + ')'} "></div>
                            <div class="card-body pb-5">
                                <img :src="this.$store.state.userInfo.userProfileImageUrl" class="user-avatar large-avatar rounded-circle mx-auto mt-n7 mb-4" alt="Neil Portrait">
                                <h4 class="h3">{{this.$store.state.userInfo.userName}}</h4>
                                
                                <p class="text-gray mb-4">{{this.$store.state.userInfo.userMessage}}</p>
                                
                            </div>
                         </div>
                    </div>
                    <div class="col-12">
                        <div class="card card-body shadow-sm mb-4">
                            <h2 class="h5 mb-4">Select profile photo</h2>
                            <div class="d-flex align-items-center mb-4">
                                <div class="me-3">
                                    <!-- Avatar -->
                                    <div class="user-avatar xl-avatar">
                                        <img class="rounded" v-if="imageUrl" :src="imageUrl" alt="change avatar">
                                    </div>
                                </div>
                                <div class="file-field">
                                    <div class="d-flex justify-content-xl-center ms-xl-3">
                                       <div class="d-flex">
                                          <span class="icon icon-md"><font-awesome-icon :icon="['fas', 'paperclip']" class="me-3"/></span> 
                                          <input ref="imageInput" type="file" hidden @change="onChangeImages" id="inputFileUploadInsert">
                                          <div class="d-md-block text-left">
                                             <!-- <div class="fw-normal text-dark mb-1">Choose Image</div> -->
                                             <div class="text-gray small">JPG, GIF or PNG. Max size of 800K</div>
                                          </div>
                                       </div>
                                       
                                    </div>
                                    <div class="btn-group mb-2" style="float:right;"  >
                                        <button type="submit" @click="onClickImageUpload" class="btn btn-outline-dark btn-sm"><font-awesome-icon :icon="['fas', 'image']"/> 사진 선택 </button>
                                        <button type="submit"  @click="onClickImageSend" class="btn btn-sm btn-outline-secondary"><font-awesome-icon :icon="['fas', 'upload']"/> 사진 업로드 </button>
                                    </div>
                                </div>                                        
                            </div>
                        </div>
                    </div>
                    
                </div>
            </div>
        </div>
    </div>

        
        <secession-modal v-on:call-parent-secession-close="closeAfterSecession" ></secession-modal>

    </main>
</template>

<script>

import Vue from "vue";
import VueAlertify from "vue-alertify";


import SecessionModal from './modals/SecessionModal.vue';

import { Modal } from 'bootstrap';

Vue.use(VueAlertify);

import http from "@/common/axios.js";

export default {
    name: 'MyPage',
    components: {
        SecessionModal
    },
    data() {
        return {

            secessionModal: null,
            name: this.$store.state.userInfo.userName,
            password: this.$store.state.userInfo.userPassword,
            rank: this.$store.state.userInfo.userRank,
            message: this.$store.state.userInfo.userMessage,
            file: '',
            imageUrl: null
        }
    },
    methods: {
        onClickImageSend() {
            var formData = new FormData();

            // file upload
            var attachFiles = document.querySelector("#inputFileUploadInsert");
            console.log("InsertImg: data 1 : ");
            console.log(attachFiles);

            var cnt = attachFiles.files.length;
            for (var i = 0; i < cnt; i++) {
                formData.append("file", attachFiles.files[i]);
            }

            http
                .post('/user/profile/' + this.$store.state.userInfo.userEmail, formData, {
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                })
                .then(({data}) => {
                    console.log("UserProfileImageSend: data : ");
                    console.log(data);
                    if (data.result == 'login') {
                        this
                            .$router
                            .push("/login")
                    } else {
                        // info 데이터 가져오기
                        this
                            .$store
                            .commit('SET_INFO', {
                                userPassword: data.userPassword,
                                userName: data.userName,
                                userEmail: data.userEmail,
                                userMessage: data.userMessage,
                               
                                userProfileImageUrl: data.userProfileImageUrl

                                
                            });

                        this.$swal(
                            {icon: 'success', title: '성공적으로 등록되었습니다.', showConfirmButton: false, timer: 1500}
                        );
                        setTimeout(function() {
                            window.location.reload();
                        }, 2000);


                    }
                })
                .catch((error) => {
                    console.log("UserProfileImageSend: error ");
                    console.log(error);
                });


        },
        onClickImageUpload() {
            this
                .$refs
                .imageInput
                .click();
        },
        onChangeImages(e) {
            console.log(e.target.files)
            const file = e
                .target
                .files[0];
            this.imageUrl = URL.createObjectURL(file);
        },
        updateName: function (event) {
            var updatedText = event.target.value;
            this.name = updatedText;
        },
        updatePassword: function (event) {
            var updatedText = event.target.value;
            this.password = updatedText;
        },
        updateRank: function (event) {
            var updatedText = event.target.value;
            this.rank = updatedText;
        },
        updateMessage: function (event) {
            var updatedText = event.target.value;
            this.message = updatedText;
        },
        showDeleteModal() {
            this
                .secessionModal
                .show();
        },
        closeAfterSecession() {
            this
                .secessionModal
                .hide();
        },

        saveInfo() {

            http
                .post("/user/" + this.$store.state.userInfo.userEmail, {
                    userName: this.name,
                    userEmail: this.$store.state.userInfo.userEmail,
                    userPassword: this.password,
                   
                    userMessage: this.message
                })
                .then(({data}) => {
                    console.log("UserVue Info Edit - data : ");
                    console.log(data);

                    // info 데이터 가져오기
                    this
                        .$store
                        .commit('SET_INFO', {
                            userPassword: data.userPassword,
                            userName: data.userName,
                            userEmail: data.userEmail,
                            userMessage: data.userMessage,
                            
                            userProfileImageUrl: data.userProfileImageUrl
                        });

                    this.$swal(
                        {icon: 'success', title: '성공적으로 수정되었습니다.', showConfirmButton: false, timer: 1500}
                    );

                })
                .catch((error) => {
                    console.log("UserVue Info Edit - error : ");
                    console.log(error);
                    if (error.response.status == "404") {
                        this
                            .$alertify
                            .error("정보확인에 실패했습니다.");
                    } else {
                        this
                            .$alertify
                            .error("Opps!! 서버에 문제가 발생했습니다.");
                    }
                });
        }
    },

    computed: {
        requireImg: function () {

            if (this.$store.state.userInfo.userProfileImageUrl == '') {
                return require('../assets/img/noProfile.png')
            } else {
                return '..'+ this.$store.state.userInfo.userProfileImageUrl;  
            }
        }
    },
    created(){
        this
            .$store
            .commit('SET_BREADCRUMB_INFO', {
                isHome : true,
                title: 'MyPage',
                subTitle: '개인 정보 조회/수정/탈퇴',
                desc: '개성있는 프로필 사진을 등록해보세요.'
            });
        this
            .$store
            .commit('SET_CUR_PAGE', 'MyPage');
    },
    mounted() {

        this.secessionModal = new Modal(document.getElementById('secessionModal'));

        
    },
    watch : {
        requireImg: function () {

            if (this.$store.state.userInfo.userProfileImageUrl == '') {
                return require('../assets/img/noProfile.png')
            } else {
                return '..'+ this.$store.state.userInfo.userProfileImageUrl;  
            }
        }
    }
}
</script>

<style>

</style>