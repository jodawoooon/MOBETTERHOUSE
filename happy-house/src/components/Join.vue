<template>
  <div class="container">
     <!-- Section -->
        <section class="d-flex align-items-center my-5 mt-lg-6 mb-lg-5">
            <div class="container">
                <p class="text-center"><router-link to="/" class="text-gray-700"><i class="fas fa-angle-left me-2"></i>이전 페이지로</router-link></p><div class="row justify-content-center form-bg-image" style="background-image: url(./img/illustrations/signin.svg)">
                    <div class="col-12 d-flex align-items-center justify-content-center">
                        <div class="mb-4 mb-lg-0 bg-white shadow-soft border rounded border-light p-4 p-lg-5 w-100 fmxw-500">
                            <div class="text-center text-md-center mb-4 mt-md-0">
                                <h1 class="mb-0 h3">Create account</h1>
                            </div>
                            <form action="#">
                                <!-- Form -->
                                <div class="form-group mb-4">
                                    <label for="email">Email</label>
                                    <div class="input-group">
                                        <span class="input-group-text" id="basic-addon3"><i class="fas fa-envelope"></i></span>
                                        <input type="email" class="form-control" v-model="userEmail" placeholder="ssafy@ssafy.com" id="email" autofocus required>
                                    </div>  
                                </div>
                                <!-- End of Form -->
                                <div class="form-group">
                                    <!-- Form -->
                                    <div class="form-group mb-4">
                                        <label for="password">Password</label>
                                        <div class="input-group">
                                            <span class="input-group-text" id="basic-addon4"><span class="fas fa-unlock-alt"></span></span>
                                            <input type="password" placeholder="Password" v-model="userPassword" class="form-control" id="password" required>
                                        </div>  
                                    </div>
                                    <!-- End of Form -->
                                    <!-- Form -->
                                    <div class="form-group mb-4">
                                        <label for="confirm_password">Confirm Password</label>
                                        <div class="input-group">
                                            <span class="input-group-text" id="basic-addon5"><span class="fas fa-unlock-alt"></span></span>
                                            <input type="password" placeholder="Confirm Password" class="form-control" id="confirm_password" required>
                                        </div>  
                                    </div>
                                    <!-- End of Form -->
                                    
                                </div>
                                <div class="d-grid">
                                    <button @click="join" class="btn btn-dark">Sign up</button>
                                </div>
                            </form>
                            
                            <div class="d-flex justify-content-center align-items-center mt-4">
                                <span class="fw-normal">
                                    가입된 계정이 있습니까?
                                    <router-link to="/login" class="fw-bold">
                                      Sign in
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
  name: "Join",

  data() {
    return {
      userEmail: "",
      userPassword: "",

      userName: "",
      userProfileImageUrl: "",
    };
  },
  methods: {
    login() {
      http
        .post("/login", {
          userEmail: this.userEmail,
          userPassword: this.userPassword,
        })
        .then(({ data }) => {
          console.log("LoginVue: data : ");
          console.log(data);

          // login 성공 전달
          this.$emit("call-parent-loginSuccess", {
            userName: data.userName,
            userProfileImageUrl: data.userProfileImageUrl,
          });
          // board 로 이동
          this.$router.push("/board");
        })
        .catch((error) => {
          console.log("LoginVue: error : ");
          console.log(error);
          if (error.response.status == "404") {
            this.$alertify.error("이메일 또는 비밀번호를 확인하세요.");
          } else {
            this.$alertify.error("Opps!! 서버에 문제가 발생했습니다.");
          }
        });
    },
  },
};
</script>

<style></style>
