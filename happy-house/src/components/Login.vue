<template>
  <div class="container">
      <!-- Section -->
     <section class="d-flex align-items-center my-5 mt-lg-6 mb-lg-5">
        <div class="container">
            <p class="text-center"><router-link to="/" class="text-gray-700"><font-awesome-icon :icon="['fas', 'angle-left']"/> 이전 페이지로</router-link></p>
            <div class="row justify-content-center form-bg-image" :style="{ backgroundImage: 'url(' + require('@/assets/img/illustrations/signin.svg') + ')' }">
                <div class="col-12 d-flex align-items-center justify-content-center">
                    <div class="bg-white shadow-soft border rounded border-light p-4 p-lg-5 w-100 fmxw-500">
                        <div class="text-center text-md-center mb-4 mt-md-0">
                            <h1 class="mb-0 h3">Sign in</h1>
                        </div>
                        <form action="#" class="mt-4">
                            <!-- Form -->
                            <div class="form-group mb-4">
                                <label for="email">Email</label>
                                <div class="input-group">
                                    <span class="input-group-text" id="basic-addon1"><font-awesome-icon :icon="['fas', 'envelope']"/></span>
                                    <input type="email" class="form-control" v-model="userEmail" placeholder="example@company.com" id="email" autofocus required>
                                </div>  
                            </div>
                            <!-- End of Form -->
                            <div class="form-group">
                                <!-- Form -->
                                <div class="form-group mb-4">
                                    <label for="password">Password</label>
                                    <div class="input-group">
                                        <span class="input-group-text" id="basic-addon2"><font-awesome-icon :icon="['fas', 'key']"/></span>
                                        <input type="password" placeholder="Password" v-model="userPassword" class="form-control" id="password" required>
                                    </div>  
                                </div>
                                <!-- End of Form -->
                                <div class="d-flex justify-content-between align-items-top mb-4">
                                    <div class="form-check">
                                       
                                    </div>
                                    <div><button class="btn btn-sm text-right">비밀번호 찾기</button></div>
                                </div>
                            </div>
                            <div class="d-grid">
                                <button class="btn btn-dark"  @click="login">Sign in</button>
                            </div>
                            <div class="mt-3 mb-4 text-center">
                                <span class="fw-normal">or</span>
                            </div>
                            <div class="d-flex justify-content-center my-4">
                              <img @click="KakaoLogin" class="btn" src="../assets/img/kakao_login_medium_wide.png">
                                <!-- <a href="#" class="btn btn-icon-only btn-pill btn-outline-gray-400 text-facebook me-2" type="button" aria-label="kakao button" title="kakao button">
                                    <font-awesome-icon :icon="['fas', 'facebook']"/> 
                                    
                                </a> -->
                                
                            </div>
                        </form>
                        
                        <div class="d-flex justify-content-center align-items-center mt-4">
                            <span class="fw-normal">
                                가입된 계정이 없습니까?
                                <router-link to="/join" class="fw-bold">
                                      Sign up
                                    </router-link>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

   
   </div>
</template>

<script>
import Vue from "vue";
import VueAlertify from "vue-alertify";


Vue.use(VueAlertify);

import http from "@/common/axios.js";

export default {

    name: "Login",

    data() {
        return {userEmail: "daun@daun.net", userPassword: "1234", userName: "", userProfileImageUrl: "", userRank: '3' // 일반회원 default 
        };
    },
    methods: {
        login() {
            http
                .post("/login", {
                    userEmail: this.userEmail,
                    userPassword: this.userPassword
                })
                .then(({data}) => {
                    console.log("LoginVue: data : ");
                    console.log(data);

                    // login 성공 전달
                    this
                        .$store
                        .commit('SET_LOGIN', {
                            isLogin: true,
                            userName: data.userName,
                            userEmail: data.userEmail,
                            userMessage: data.userMessage,
                            userPassword: data.userPassword,
                            userPhone: data.userPhone,
                            userRank : data.codeName,
                            userProfileImageUrl: data.userProfileImageUrl
                        });

                    // home 로 이동
                    this
                        .$router
                        .push("/home");
                })
                .catch((error) => {
                    console.log("LoginVue: error : ");
                    console.log(error);
                    if (error.response.status == "404") {
                        this
                            .$alertify
                            .error("이메일 또는 비밀번호를 확인하세요.");
                    } else {
                        this
                            .$alertify
                            .error("Opps!! 서버에 문제가 발생했습니다.");
                    }
                });
        },

        KakaoLogin() {
            console.log(window.Kakao);
            window
                .Kakao
                .Auth
                .login({
                    scope: 'account_email, profile, gender',
                    success: this.GetMe,
                    fail: function (error) {
                        console.log(error)
                    }
                });
        },
        GetMe(authObj) {
            console.log(authObj);
            window
                .Kakao
                .API
                .request({
                    url: '/v2/user/me',
                    success: res => {
                        const kakao_account = res.kakao_account;

                        http
                            .post("/login", {
                                userName: kakao_account.profile.nickname + '('+ res.id + ')',
                                userEmail: kakao_account.email,
                                userProfileImageUrl: kakao_account.profile.profile_image_url,
                                userPassword: 'kakao',
                                userRank : this.userRank
                            })
                            .then(({data}) => {
                                console.log("LoginVue: data : ");
                                console.log(data);

                                // login 성공 전달
                                this
                                    .$store
                                    .commit('SET_LOGIN', {
                                        isLogin: true,
                                        userName: data.userName,
                                        userEmail: data.userEmail,
                                        userMessage: data.userMessage,
                                        userPassword: data.userPassword,
                                        userPhone: data.userPhone,
                                        userRank : data.codeName,
                                        userProfileImageUrl: data.userProfileImageUrl
                                    });

                                this.$store.commit('SET_KAKAO');

                                // home 로 이동
                                this
                                    .$router
                                    .push("/home");
                            })
                            .catch((error) => {
                                console.log("KaKaoLoginVue: error : ");
                                console.log(error);
                                if (error.response.status == "404") {
                                    // => 카카오 회원가입

                                    http
                                        .post("/user", {
                                            userName: kakao_account.profile.nickname + '('+ res.id + ')',
                                            userEmail: kakao_account.email,
                                            userProfileImageUrl: kakao_account.profile.profile_image_url,
                                            userPassword: 'kakao',
                                            userRank : this.userRank
                                        })
                                        .then(({data}) => {
                                            console.log("JoinVue - data : ");
                                            console.log(data);

                                            // join 성공 전달
                                            this
                                                .$store
                                                .commit('SET_LOGIN', {
                                                    isLogin: true,
                                                    userName: data.userName,
                                                    userEmail: data.userEmail,
                                                    userMessage: data.userMessage,
                                                    userPassword: data.userPassword,
                                                    userPhone: data.userPhone,
                                                    userRank : data.codeName,
                                                    userProfileImageUrl: data.userProfileImageUrl
                                                });

                                            this.$swal(
                                                {icon: 'success', title: '로그인 성공', showConfirmButton: false, timer: 1500}
                                            );
                                            this.$store.commit('SET_KAKAO');
                                            // home 로 이동
                                            this
                                                .$router
                                                .push("/home");

                                        })
                                        .catch((error) => {
                                            console.log("LoginVue: error : ");
                                            console.log(error);
                                            if (error.response.status == "404") {
                                                this
                                                    .$alertify
                                                    .error("카카오 로그인에 실패했습니다.");
                                            } else {
                                                this
                                                    .$alertify
                                                    .error("Opps!! 서버에 문제가 발생했습니다.");
                                            }
                                        });
                                } else {
                                    this
                                        .$alertify
                                        .error("Opps!! 서버에 문제가 발생했습니다.");
                                }
                            });
                    },

                    fail: error => {
                        this
                            .$router
                            .push("/");
                        console.log(error);
                    }
                })
        }

    },
    mounted() {}
};
</script>

<style></style>
