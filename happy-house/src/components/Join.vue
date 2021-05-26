<template>
  <div class="container">
    <!-- Section -->
    <section class="d-flex align-items-center my-5 mt-lg-6 mb-lg-5">
      <div class="container">
        <p class="text-center">
          <router-link to="/" class="text-gray-700"><font-awesome-icon :icon="['fas', 'angle-left']" /> 이전 페이지로</router-link>
        </p>
        <div class="row justify-content-center form-bg-image" :style="{ backgroundImage: 'url(' + require('@/assets/img/illustrations/signin.svg') + ')' }">
          <div class="col-12 d-flex align-items-center justify-content-center">
            <div class="mb-4 mb-lg-0 bg-white shadow-soft border rounded border-light p-4 p-lg-5 w-100 fmxw-500">
              <div class="text-center text-md-center mb-4 mt-md-0">
                <h1 class="mb-0 h3">Create account</h1>
              </div>
              <!-- <form action="#"> -->
                <!-- Form -->
                <div class="form-group mb-4">
                  <label for="userName">Name</label>
                  <div class="input-group">
                    <span class="input-group-text" id="basic-addon3"><font-awesome-icon :icon="['fas', 'user']"/></span>
                    <input
                      type="name"
                      class="form-control"
                      placeholder="Enter User Name"
                      :class="{ 'is-valid': isUserNameFocusAndValid, 'is-invalid': isUserNameFocusAndInvalid }"
                      v-model="userName"
                      @input="validateUserName"
                      @focus="isUserNameFocus = true"
                      id="userName"
                    />
                    <div class="valid-feedback">Valid.</div>
                    <div class="invalid-feedback">올바른 이름을 입력해 주세요.</div>
                  </div>
                </div>
                <!-- End of Form -->

                <!-- Form -->
                <div class="form-group mb-4">
                  <label for="email">Email</label>
                  <div class="input-group">
                    <span class="input-group-text" id="basic-addon3"><font-awesome-icon :icon="['fas', 'envelope']"/></span>
                    <input
                      type="email"
                      class="form-control"
                      v-model="userEmail"
                      placeholder="Enter your email"
                      id="email"
                      :class="{ 'is-valid': isUserEmailFocusAndValid, 'is-invalid': isUserEmailFocusAndInValid }"
                      @input="validateEmail"
                      @focus="isUserEmailFocus = true"
                    />

                    <div class="valid-feedback">Valid.</div>
                    <div class="invalid-feedback">올바른 Email 을 입력해 주세요.</div>
                  </div>
                </div>
                <!-- End of Form -->
                <div class="form-group">
                  <!-- Form -->
                  <div class="form-group mb-4">
                    <label for="password">Password</label>
                    <div class="input-group">
                      <span class="input-group-text" id="basic-addon4"><font-awesome-icon :icon="['fas', 'key']"/></span>
                      <input
                        type="password"
                        placeholder="Password"
                        v-model="userPassword"
                        class="form-control"
                        id="password"
                        :class="{ 'is-valid': isUserPasswordFocusAndValid, 'is-invalid': isUserPasswordFocusAndInvalid }"
                        @input="validatePassword"
                        @focus="isUserPasswordFocus = true"
                      />
                      <div class="valid-feedback">Valid.</div>
                      <div class="invalid-feedback">1개 이상의 특수문자, 대소문자 및 숫자를 포함하고 8자리 이상이여야 합니다.</div>
                    </div>
                  </div>
                  <!-- End of Form -->
                  <!-- Form -->
                  <div class="form-group mb-4">
                    <label for="confirm_password">Confirm Password</label>
                    <div class="input-group">
                      <span class="input-group-text" id="basic-addon5"><font-awesome-icon :icon="['fas', 'key']"/></span>
                      <input
                        type="password"
                        placeholder="Confirm Password"
                        class="form-control"
                        :class="{ 'is-valid': isUserPassword2FocusAndValid, 'is-invalid': isUserPassword2FocusAndInvalid }"
                        v-model="userPassword2"
                        @input="validatePassword2"
                        @focus="isUserPassword2Focus = true"
                      />
                      <div class="valid-feedback">Valid.</div>
                      <div class="invalid-feedback">비밀번호가 일치하지 않습니다.</div>
                    </div>
                  </div>
                  <!-- End of Form -->
                  <!-- Form -->
                  <div class="form-group mb-4">
                    <div class="form-check form-check-inline" v-for="(code, index) in codeList" :key="index">
                      <input class="form-check-input" :value="code.code" name="code.code" type="radio" v-model="userRank" />
                      <label class="form-check-label">{{ code.codeName }}</label>
                    </div>
                  </div>
                  <!-- End of Form -->
                </div>
                <div class="d-grid">
                  <button @click="join" class="btn btn-dark">Sign up</button>
                </div>
                <div class="mt-3 mb-4 text-center">
                  <span class="fw-normal">or</span>
                </div>
                <div class="d-flex justify-content-center my-4">
                  <img @click="KakaoLogin" class="btn" src="../assets/img/kakao_login_medium_wide.png" />
                  <!-- <a href="#" class="btn btn-icon-only btn-pill btn-outline-gray-400 text-facebook me-2" type="button" aria-label="kakao button" title="kakao button">
                                    <font-awesome-icon :icon="['fas', 'facebook']"/> 
                                    
                                </a> -->
                </div>
              <!-- </form> -->

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
import Vue from 'vue';
import VueAlertify from 'vue-alertify';
Vue.use(VueAlertify);

import http from '@/common/axios.js';

export default {
  name: 'Join',

  data() {
    return {
      userEmail: '',
      userPassword: '',
      userPassword2: '',
      userName: '',
      userProfileImageUrl: '',

      // focus
      isUserNameFocus: false,
      isUserEmailFocus: false,
      isUserPasswordFocus: false,
      isUserPassword2Focus: false,

      // validation
      isUserNameValid: false,
      isUserEmailValid: false,
      isUserPasswordValid: false,
      isUserPassword2Valid: false,

      // 회원 구분
      groupCode: '1',
      codeList: [],
      userRank: '3', // 일반회원 default
    };
  },
  computed: {
    isUserNameFocusAndValid() {
      return this.isUserNameFocus && this.isUserNameValid;
    },
    isUserNameFocusAndInvalid() {
      return this.isUserNameFocus && !this.isUserNameValid;
    },
    isUserEmailFocusAndValid() {
      return this.isUserEmailFocus && this.isUserEmailValid;
    },
    isUserEmailFocusAndInValid() {
      return this.isUserEmailFocus && !this.isUserEmailValid;
    },
    isUserPasswordFocusAndValid() {
      return this.isUserPasswordFocus && this.isUserPasswordValid;
    },
    isUserPasswordFocusAndInvalid() {
      return this.isUserPasswordFocus && !this.isUserPasswordValid;
    },
    isUserPassword2FocusAndValid() {
      return this.isUserPassword2Focus && this.isUserPassword2Valid;
    },
    isUserPassword2FocusAndInvalid() {
      return this.isUserPassword2Focus && !this.isUserPassword2Valid;
    },
  },
  methods: {
    validateUserName() {
      this.isUserNameValid = this.userName.length > 0 ? true : false;
      console.log(this.isUserNameValid);
    },
    validateEmail() {
      // ^ 시작일치, $ 끝 일치
      // {2, 3} 2개 ~ 3개
      // * 0회 이상, + 1회 이상
      // [-_.] - 또는 _ 또는 .
      // ? 없거나 1회
      let regexp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
      this.isUserEmailValid = regexp.test(this.userEmail) ? true : false;
      console.log(this.isUserEmailValid);
    },
    validatePassword() {
      let patternEngAtListOne = new RegExp(/[a-zA-Z]+/); // + for at least one
      let patternSpeAtListOne = new RegExp(/[~!@#$%^&*()_+|<>?:{}]+/); // + for at least one
      let patternNumAtListOne = new RegExp(/[0-9]+/); // + for at least one

      this.isUserPasswordValid =
        patternEngAtListOne.test(this.userPassword) && patternSpeAtListOne.test(this.userPassword) && patternNumAtListOne.test(this.userPassword) && this.userPassword.length >= 8 ? true : false;
    },
    validatePassword2() {
      this.isUserPassword2Valid = this.userPassword == this.userPassword2 ? true : false;
    },
    join() {
      http
        .post('/user', {
          userName: this.userName,
          userEmail: this.userEmail,
          userPassword: this.userPassword,
          userRank: this.userRank,
        })
        .then(({ data }) => {
          console.log('JoinVue - data : ');
          console.log(data);

          // join 성공 전달
          this.$store.commit('SET_LOGIN', {
            isLogin: true,
             userSeq : data.userSeq,   
            userName: data.userName,
            userEmail: data.userEmail,
            userMessage: data.userMessage,
            userPassword: data.userPassword,
            userPhone: data.userPhone,
            userRank: data.codeName,
            userProfileImageUrl: data.userProfileImageUrl,
          });

          this.$alertify
                                .success(this.$store.state.userInfo.userName+"님 환영합니다");

          // home 로 이동

          this.$router.push('/home');
        })
        .catch((error) => {
          console.log('JoinVue: error : ');
          console.log(error);
          if (error.response.status == '404') {
            this.$alertify.error('회원가입에 실패했습니다.');
          } else {
            this.$alertify.error('회원가입에 실패했습니다.');
          }
        });
    },

    KakaoLogin() {
      console.log(window.Kakao);
      window.Kakao.Auth.login({
        scope: 'account_email, profile, gender',
        success: this.GetMe,
        fail: function(error) {
          console.log(error);
        },
      });
    },
    GetMe(authObj) {
      console.log(authObj);
      window.Kakao.API.request({
        url: '/v2/user/me',
        success: (res) => {
          const kakao_account = res.kakao_account;

          http
            .post('/login', {
              userName: kakao_account.profile.nickname,
              userEmail: kakao_account.email,
              userProfileImageUrl: kakao_account.profile.profile_image_url,
              userPassword: 'kakao',
            })
            .then(({ data }) => {
              console.log('LoginVue: data : ');
              console.log(data);

              // login 성공 전달
              this.$store.commit('SET_LOGIN', {
                isLogin: true,
                 userSeq : data.userSeq,   
                userName: data.userName,
                userEmail: data.userEmail,
                userMessage: data.userMessage,
                userPassword: data.userPassword,
                userPhone: data.userPhone,
                userRank: data.codeName,
                userProfileImageUrl: data.userProfileImageUrl,
              });
              this.$alertify
                                .success(this.$store.state.userInfo.userName+"님 환영합니다");

              // home 로 이동
              this.$router.push('/home');
            })
            .catch((error) => {
              console.log('KaKaoLoginVue: error : ');
              console.log(error);
              if (error.response.status == '404') {
                // => 카카오 회원가입

                http
                  .post('/user', {
                    userName: kakao_account.profile.nickname,
                    userEmail: kakao_account.email,
                    userProfileImageUrl: kakao_account.profile.profile_image_url,
                    userPassword: 'kakao',
                  })
                  .then(({ data }) => {
                    console.log('JoinVue - data : ');
                    console.log(data);

                    // join 성공 전달
                    this.$store.commit('SET_LOGIN', {
                      isLogin: true,
                      userSeq : data.userSeq,   
                      userName: data.userName,
                      userEmail: data.userEmail,
                      userMessage: data.userMessage,
                      userPassword: data.userPassword,
                      userPhone: data.userPhone,
                      userRank: data.codeName,
                      userProfileImageUrl: data.userProfileImageUrl,
                    });

                    this.$alertify
                                .success(this.$store.state.userInfo.userName+"님 환영합니다");
                    // home 로 이동
                    this.$router.push('/home');
                  })
                  .catch((error) => {
                    console.log('LoginVue: error : ');
                    console.log(error);
                    if (error.response.status == '404') {
                      this.$alertify.error('카카오 로그인에 실패했습니다.');
                    } else {
                      this.$alertify.error('Opps!! 서버에 문제가 발생했습니다.');
                    }
                  });
              } else {
                this.$alertify.error('Opps!! 서버에 문제가 발생했습니다.');
              }
            });
        },

        fail: (error) => {
          this.$router.push('/');
          console.log(error);
        },
      });
    },
  },
  created() {
    http
      .get('/codes', {
        // get query string
        params: {
          groupCode: this.groupCode,
        },
      })
      .then(({ data }) => {
        console.log('RegisterVue: data : ');
        console.log(data);
        if (data.result == 'login') {
          this.$router.push('/login');
        } else {
          this.codeList = data;
          console.log(this.codeList);
        }
      });
  },
};
</script>

<style></style>
