<template>
  <div id="app">
    <side-bar></side-bar>

    <nav-bar />
    <bread-crumb></bread-crumb>
    <router-view></router-view>
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
    return {};
  },
  components: {
    //Index,
    SideBar,
    NavBar,
    BreadCrumb,
  },
  computed: {},
  methods: {},
};
</script>

<style src="./assets/css/volt.css"></style>
<style></style>
