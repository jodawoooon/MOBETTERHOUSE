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
            <img class="user-avatar md-avatar rounded-circle m-1" alt="Image placeholder" src="../assets/img/team/profile-picture-3.jpg">
              
            <li class="nav-item m-2" id="navItem1">
                
              <strong>{{ userInfo.userName }}({{ userInfo.userEmail }})</strong>님 환영합니다.
            </li>
            <li class="nav-item" id="navItem2">
              <button id="logout" class="nav-item btn btn-light"><i class="bi bi-person-x-fill"></i> Logout</button>
            </li>
            <li class="nav-item" id="navItem3" :class="{ active: curPage == 'mypage' }" @click="changePage('mypage')">
              <router-link to="/mypage" id="myPage" class="nav-item btn btn-light">
                <i class="bi bi-person-square"></i> My Page
              </router-link>
              
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
  props: ['isLogin', 'userInfo'],
  data(){
    return {
      mypageBreadCrumb: {
        title : 'MyPage',
        subTitle: '개인정보 조회',
        desc: '개성있는 프로필 사진을 등록해보세요.',
      }
    }
  },
  methods: {
    changePage(page) {
      if (page === 'mypage') this.$emit('change-page', { page: page, breadCrumbInfo: this.mypageBreadCrumb });

    },
  },
};
</script>

<style></style>
