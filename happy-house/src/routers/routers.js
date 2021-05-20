import Vue from 'vue'; // defalut module
import VueRouter from 'vue-router'; // installed module

Vue.use(VueRouter);

import Search from '@/components/Search.vue';

export default new VueRouter({
  routes: [
    {
      path: '/',
      component: Search,
    },
    {
      path: '/house',
      component: Search,
    },
  ],
});
