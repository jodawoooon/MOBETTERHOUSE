<template>
  <div id="app">
    <side-bar></side-bar>
    <nav-bar></nav-bar>
  </div>
</template>

<script>
import SideBar from './components/SideBar.vue';
import NavBar from './components/NavBar.vue';
export default {
  name: 'App',
  data() {
    return {
      isLogin: true,
      userInfo: {
        userName: '손동우',
        userEmail: 'ssafy@ssafy.com',
      },
    };
  },
  components: {
    SideBar,
    NavBar,
  },
};
</script>

<style src="./assets/css/volt.css"></style>
<style></style>
