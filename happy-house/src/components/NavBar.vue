<template>
  <main class="content">
    <nav class="navbar navbar-top navbar-expand navbar-dashboard navbar-dark ps-0 pe-2 pb-0">
      <div class="container-fluid px-0">
        <div class="d-flex justify-content-between w-100" id="navbarSupportedContent">
          <div class="d-flex">
            <button id="btnSsafyLogo" class="navbar-brand btn">
              <img class="img-fluid" style="width: 80px; height: 80px" src="@/assets/img/ssafy_logo.png" alt="" />
            </button>
          </div>

          <ul class="navbar-nav align-items-center">
            
            <!-- 기존 nav바 -->
            <!-- <img class="user-avatar md-avatar rounded-circle m-1" alt="Image placeholder" :src="requireImg" />
            
            <li class="nav-item m-2" id="navItem1" >
              <strong>{{ $store.state.userInfo.userName }}({{ $store.state.userInfo.userEmail }})</strong>님 환영합니다.
            </li>
            
            <li class="nav-item" id="navItem2">
              <button id="logout" @click="logout" class="nav-item btn btn-light"><font-awesome-icon :icon="['fas', 'sign-out-alt']"/> Logout</button>
            </li>
            <li class="nav-item" id="navItem3" :class="{ active: $store.state.curPage == 'mypage' }" @click="changePage('mypage')">
              <router-link to="/mypage" id="myPage" class="nav-item btn btn-light"> <font-awesome-icon :icon="['fas', 'user-circle']"/> My Page </router-link>
            </li> -->


            <!-- dropdown nav바 -->
            <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle pt-1 px-0" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              <div class="media d-flex align-items-center">
                <img class="user-avatar md-avatar rounded-circle m-1" alt="Image placeholder" :src="requireImg">
                <div class="media-body ms-2 text-dark align-items-center d-none d-lg-block">
                  <span class="mb-0 fw-bold"><strong>{{ $store.state.userInfo.userName }}({{ $store.state.userInfo.userEmail }})</strong></span>
                </div>
              </div>
            </a>
            <div class="dropdown-menu dashboard-dropdown dropdown-menu-end mt-2 py-0">
              <li class="dropdown-item rounded-top fw-bold" id="navItem3" :class="{ active: $store.state.curPage == 'mypage' }" @click="changePage('mypage')">
              <router-link to="/mypage" id="myPage" class="nav-item btn btn-light"> <font-awesome-icon :icon="['fas', 'user-circle']"/> My Page </router-link>
            </li>
                <div role="separator" class="dropdown-divider my-0"></div>
                <li class="dropdown-item rounded-bottom fw-bold" id="navItem2">
              <button id="logout" @click="logout" class="nav-item btn btn-light"><font-awesome-icon :icon="['fas', 'sign-out-alt']" class="text-danger"/> Logout</button>
            </li>
            </div>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <hr />
  </main>
</template>

<script>
export default {
  name: 'NavBar',
  data() {
    return {
      mypageBreadCrumb: {
        title: 'MyPage',
        subTitle: '개인정보 조회',
        desc: '개성있는 프로필 사진을 등록해보세요.',
      },
    };
  },
  methods: {
    changePage(page) {
      if (page === 'mypage') this.$emit('change-page', { page: page, breadCrumbInfo: this.mypageBreadCrumb });
    },
    logout(){
      this.$store.commit('SET_LOGOUT');

      this.$router.push("/");
    }
  },
  computed : {
        requireImg : function(){
            console.log(this.$store.state.userInfo.userProfileImageUrl);

            if( this.$store.state.userInfo.userProfileImageUrl == ''  ) {
                return require('../assets/img/noProfile.png')
            }else if(this.$store.state.userInfo.userProfileImageUrl=='undefined'){
              return require('../assets/img/noProfile.png')
            }else if(this.$store.state.userInfo.userProfileImageUrl.indexOf("http://k.kakaocdn.net/") != -1){
              return (this.$store.state.userInfo.userProfileImageUrl)
            }
            else{
                // let url = '../assets' + this.$store.state.userInfo.userProfileImageUrl;
                // let fs = require('fs');
                // let res =  fs.existSync(url);
                // console.log(res);
                return require('../assets' + this.$store.state.userInfo.userProfileImageUrl);
            }
        }
            ,
        
    },
  
};
</script>

<style></style>
