<template>
  <main class="content">
    <div class="col-12 mb-4">
      <div class="row justify-content-center mb-5 mb-lg-6">
        <div
          class="text-center bg-primary shadow-lg rounded scale mt-8 mb-8"
          style="padding:40px;  border-radius:200px; width:550px;
         
           "
        >
          <span class="lead fw-bolder text-muted display-5">똑똑한 내 집 마련의 시작</span><br />
          <span class="lead fw-bolder text-white display-1"> Happy House </span>
        </div>

        <div class="row mb-7">
          <div class="col-6 col-md-3 text-center mb-4 ">
            <router-link to="/searchDong">
              <div class="icon icon-shape icon-lg bg-white  page-preview scale-up-3  shadow-lg border-light rounded-circle icon-secondary mb-4">
                <img src="@/assets/img/houses.png" style="width:55px" />
                <div class="text-center show-on-hover rounded-bottom">
                  <p class="m-0 text-center text-white">매물검색</p>
                </div>
              </div>
            </router-link>
            <h3 class="fw-bolder mt-1">다양한 매물 정보</h3>
            <p class="text-gray">당신이 원하는 바로 그 집</p>
          </div>

          <div class="col-6 col-md-3 text-center mb-4">
            <router-link to="/bookmarkHouse">
              <div class="icon icon-shape icon-lg bg-white  page-preview scale-up-3  shadow-lg scale-up-3  border-light rounded-circle icon-secondary mb-4">
                <img src="@/assets/img/group.png" style="width:55px" />
                <div class="text-center show-on-hover rounded-bottom">
                  <p class="m-0 text-center text-white">MY관심</p>
                </div>
              </div>
            </router-link>
            <h3 class="fw-bolder mt-1">유저 맞춤 서비스</h3>
            <p class="text-gray">관심 매물, 관심 동네 모아보기</p>
          </div>
          <div class="col-6 col-md-3 text-center">
            <router-link to="/info">
              <div class="icon icon-shape icon-lg bg-white page-preview  scale-up-3 shadow-lg  scale-up-3 border-light rounded-circle icon-secondary mb-4">
                <img src="@/assets/img/analysis.png" style="width:55px" />
                <div class="text-center show-on-hover rounded-bottom">
                  <p class="m-0 text-center text-white">동네정보</p>
                </div>
              </div>
            </router-link>
            <h3 class="fw-bolder mt-1">지역별 정보 제공</h3>
            <p class="text-gray">동네 정보와 학군 정보를 한눈에!</p>
          </div>
          <div class="col-6 col-md-3 text-center">
            <router-link to="/community">
              <div class="icon icon-shape icon-lg bg-white page-preview  scale-up-3 shadow-lg scale-up-3  border-light rounded-circle icon-secondary mb-4">
                <img src="@/assets/img/community.png" style="width:55px" />
                <div class="text-center show-on-hover rounded-bottom">
                  <p class="m-0 text-center text-white">커뮤니티</p>
                </div>
              </div>
            </router-link>
            <h3 class="fw-bolder mt-1">커뮤니티</h3>

            <p class="text-gray">우리 동네 이야기</p>
          </div>
        </div>
      </div>
    </div>
  </main>
</template>

<script>
export default {
  name: 'Home',
  data() {
    return {};
  },
  mounted() {
    this.$store.commit('SET_BREADCRUMB_INFO', {
      isHome: true,
      title: '',
      subTitle: '',
      desc: '',
    });
    this.$store.commit('SET_CUR_PAGE', 'Home');
    console.log(this.$store.state.userInfo.isLogin);
  },
};
</script>

<style></style>
