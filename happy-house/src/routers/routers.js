import Vue from 'vue'; // defalut module
import VueRouter from 'vue-router'; // installed module

Vue.use(VueRouter);

import MainPage from '@/components/MainPage.vue';
import SearchDong from '@/components/SearchDong.vue';
import SearchApt from '@/components/SearchApt.vue';
import Bookmark from '@/components/Bookmark.vue';
import Community from '@/components/Community.vue';
import Contact from '@/components/Contact.vue';

export default new VueRouter({
  routes: [
    {
      path: '/',
      component: MainPage,
    },
    {
      path: '/mainPage',
      component: MainPage,
    },
    {
      path: '/searchDong',
      component: SearchDong,
    },
    {
      path: '/searchApt',
      component: SearchApt,
    },
    {
      path: '/bookmark',
      component: Bookmark,
    },
    {
      path: '/community',
      component: Community,
    },
    {
      path: '/contact',
      component: Contact,
    },
  ],
});
