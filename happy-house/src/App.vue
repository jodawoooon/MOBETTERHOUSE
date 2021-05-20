<template>
  <div id="app">
    <side-bar></side-bar>
    <nav-bar></nav-bar>
    <bread-crumb :breadCrumbInfo="breadCrumbInfo"></bread-crumb>
  </div>
</template>

<script>
import SideBar from './components/SideBar.vue';
import NavBar from './components/NavBar.vue';
import BreadCrumb from './components/BreadCrumb.vue';
export default {
  name: 'App',
  data() {
    return {
      isLogin: true,
      userInfo: {
        userName: '손동우',
        userEmail: 'ssafy@ssafy.com',
      },
      breadCrumbInfo: {
        title: 'Search',
        subTitle: '매물 / 거래정보 검색',
        desc: '원하는 지역의 매물정보를 확인해보세요.',
      },
    };
  },
  components: {
    SideBar,
    NavBar,
    BreadCrumb,
  },
};
</script>

<style src="./assets/css/volt.css"></style>
<style></style>
