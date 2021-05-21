import Vue from 'vue'; // defalut module
import VueRouter from 'vue-router'; // installed module

Vue.use(VueRouter);

import Home from '@/components/Home.vue';
import SearchDong from '@/components/SearchDong.vue';
import SearchApt from '@/components/SearchApt.vue';
import Bookmark from '@/components/Bookmark.vue';
import Community from '@/components/Community.vue';
import Contact from '@/components/Contact.vue';
import Login from '@/components/Login.vue';
import Join from '@/components/Join.vue';
import MyPage from '@/components/MyPage.vue';
import Index from '@/components/Index.vue';

export default new VueRouter({
  routes: [
    {
      path: '/',
      component: Index,
    },
    {
      path: '/home',
      component: Home,
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
    {
      path: '/login',
      component: Login,
    },
    {
      path: '/join',
      component: Join,
    },
    {
      path: '/mypage',
      component: MyPage,
    },
  ],
});
