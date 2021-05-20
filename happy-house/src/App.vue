<template>
  <div id="app">

    <side-bar @change-page="changePage"></side-bar>

    <nav-bar :isLogin="isLogin" :userInfo="userInfo"></nav-bar>
    <bread-crumb :breadCrumbInfo="breadCrumbInfo"></bread-crumb>
    <router-view @change-page="changePage"></router-view>
  </div>
</template>

<script>
import SideBar from './components/SideBar.vue';
import NavBar from './components/NavBar.vue';
import BreadCrumb from './components/BreadCrumb.vue';
//import Index from './components/Index.vue';

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
        title: '',
        subTitle: '',
        desc: '',
      },
    };
  },
  components: {
    //Index,
    SideBar,
    NavBar,
    BreadCrumb,
  },
  methods: {
    changePage(breadCrumbInfo) {
      console.log(breadCrumbInfo);
      this.breadCrumbInfo = breadCrumbInfo;
    },
    loginSuccess( userInfo ){
      this.isLogin = true;
      this.userInfo = userInfo;
    }
  },
};
</script>

<style src="./assets/css/volt.css"></style>
<style></style>
