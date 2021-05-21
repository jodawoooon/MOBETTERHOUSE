<template>
  <div id="app">
    <side-bar v-if="getIsLogin" ></side-bar>

    <nav-bar v-if="getIsLogin" />
    <bread-crumb></bread-crumb>
    <router-view></router-view>
  </div>
</template>

<script>
import SideBar from './components/SideBar.vue';
import NavBar from './components/NavBar.vue';
import BreadCrumb from './components/BreadCrumb.vue';
//import Index from './components/Index.vue';

// for bootstrap 5
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap';

import { mapGetters } from 'vuex';

export default {
  name: 'App',
  data() {
    return {
      size: '5',
    };
  },
  components: {
    //Index,
    SideBar,
    NavBar,
    BreadCrumb,
  },
  computed: {
    ...mapGetters(['getIsLogin', 'getIsLoading']),
  },
  methods: {},
};
</script>

<style>
@import "./assets/css/volt.css"
</style>