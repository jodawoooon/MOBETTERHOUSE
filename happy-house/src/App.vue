<template>
  <div id="app">
    <side-bar v-if="getIsLogin"></side-bar>

    <nav-bar v-if="getIsLogin" />
    <bread-crumb v-if="getIsLogin"></bread-crumb>
    <router-view></router-view>
  </div>
</template>

<script>
import SideBar from './components/SideBar.vue';
import NavBar from './components/NavBar.vue';
import BreadCrumb from './components/BreadCrumb.vue';

// for bootstrap 5
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap';

import { mapGetters } from 'vuex';

export default {
  name: 'App',
  data() {
    return {
      isLogin: false,
    };
  },
  components: {
    //Index,
    SideBar,
    NavBar,
    BreadCrumb,
  },
  computed: {
    ...mapGetters(['getIsLogin']),
  },
  watch: {
    getIsLogin() {
      this.isLogin = this.getIsLogin;
    },
  },
};
</script>

<style>
@import './assets/css/volt.css';
</style>
