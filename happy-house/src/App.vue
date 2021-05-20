<template>
  <div id="app">
    <side-bar></side-bar>
  </div>
</template>

<script>
import SideBar from './components/SideBar.vue';

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
  },
};
</script>

<style src="./assets/css/volt.css"></style>
<style></style>
