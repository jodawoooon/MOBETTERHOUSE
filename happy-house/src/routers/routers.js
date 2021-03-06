import Vue from 'vue'; // defalut module
import VueRouter from 'vue-router'; // installed module

Vue.use(VueRouter);

import Home from '@/components/Home.vue';
import SearchDong from '@/components/SearchDong.vue';
import SearchApt from '@/components/SearchApt.vue';
import Community from '@/components/Community.vue';
import Contact from '@/components/Contact.vue';
import Login from '@/components/Login.vue';
import Join from '@/components/Join.vue';
import MyPage from '@/components/MyPage.vue';
import Index from '@/components/Index.vue';
import SchoolZone from '@/components/SchoolZone.vue';
import GuInfo from '@/components/GuInfo.vue';
import BookmarkHouse from '@/components/BookmarkHouse.vue';
import BookmarkArea from '@/components/BookmarkArea.vue';

export default new VueRouter({
  routes: [
    {
      path: '/',
      component: Index,
      name: 'Index',
    },
    {
      path: '/home',
      component: Home,
      name: 'Home',
    },
    {
      path: '/searchDong',
      component: SearchDong,
      name: 'SearchDong',
    },
    {
      path: '/searchApt',
      component: SearchApt,
      name: 'SearchApt',
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
    {
      path: '/index',
      component: Index,
    },
    {
      path: '/schoolZone',
      component: SchoolZone,
    },
    {
      path: '/info',
      component: GuInfo,
    },
    {
      path: '/bookmarkHouse',
      component: BookmarkHouse,
      name: 'BookmarkHouse',
    },
    {
      path: '/bookmarkArea',
      component: BookmarkArea,
      name: 'BookmarkArea',
    },
  ],
});
