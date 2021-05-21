<template>
  <div id="app">
    <side-bar></side-bar>

    <nav-bar v-if="getIsLogin" />
    <bread-crumb></bread-crumb>
    <!-- <pulse-loader :loading="getIsLoading" :size="size"></pulse-loader> -->
    <router-view></router-view>
  </div>
</template>

<script>
import SideBar from './components/SideBar.vue';
import NavBar from './components/NavBar.vue';
import BreadCrumb from './components/BreadCrumb.vue';
//import Index from './components/Index.vue';

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

<style src="./assets/css/volt.css"></style>
<style></style>
