<template>
  <div id="app">
    <side-bar v-if="getIsLogin" ></side-bar>

    <nav-bar v-if="getIsLogin" />
    <bread-crumb v-if="getIsLogin" ></bread-crumb>
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
    return {};
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
  methods: {},
};
</script>

<style src="./assets/css/volt.css"></style>
<style></style>
