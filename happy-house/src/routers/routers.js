import Vue from 'vue'; // defalut module
import VueRouter from 'vue-router'; // installed module

Vue.use(VueRouter);

import Search from '@/components/Search.vue';
import Bookmark from '@/components/Bookmark.vue';
import Community from '@/components/Community.vue';
import Contact from '@/components/Contact.vue';
import Login from '@/components/Login.vue';
import Join from '@/components/Join.vue';
import MyPage from '@/components/MyPage.vue';

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
      component : Login
    },
    {
      path: '/join',
      component : Join
    },
    {
      path: '/mypage',
      component : MyPage
    },
    
    
  ],
});
