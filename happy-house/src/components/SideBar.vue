<template>
  <nav id="sidebarMenu" class="sidebar d-md-block bg-dark text-white collapse" data-simplebar>
    <div class="sidebar-inner px-2 pt-3">
      <ul class="nav flex-column pt-3 pt-md-0">
        <li class="nav-item" :class="{ active: curPage == 'MainPage' }" @click="changePage('MainPage')">
          <router-link to="/mainPage" class="nav-link">
            <span class="sidebar-icon"><font-awesome-icon :icon="['fas', 'home']"/></span>
            <span class="sidebar-text">MainPage</span>
          </router-link>
        </li>
        <li class="nav-item">
          <div @click="changePage('search')">
            <span
              class="nav-link d-flex justify-content-between align-items-center"
              :class="{ collapsed: curPage != 'search' && curPage != 'searchDong' }"
              data-bs-toggle="collapse"
              data-bs-target="#submenu-app"
            >
              <span>
                <span class="sidebar-icon"><font-awesome-icon :icon="['fas', 'search']"/></span>
                <span class="sidebar-text">Search</span>
              </span>
              <span class="link-arrow"><font-awesome-icon :icon="['fas', 'chevron-right']"/></span>
            </span>
          </div>
          <div class="multi-level collapse" :class="{ show: curPage == 'search' || curPage == 'searchDong' || curPage == 'searchApt' }" role="list" id="submenu-app" aria-expanded="false">
            <ul class="flex-column nav">
              <li class="nav-item" :class="{ active: curPage == 'searchDong' }" @click="changePage('searchDong')">
                <router-link to="/searchDong" class="nav-link">
                  <span class="sidebar-icon"><font-awesome-icon :icon="['fas', 'map-marked-alt']"/></span>
                  <span class="sidebar-text">SearchDong</span>
                </router-link>
              </li>
              <li class="nav-item" :class="{ active: curPage == 'searchApt' }" @click="changePage('searchApt')">
                <router-link to="/searchApt" class="nav-link">
                  <span class="sidebar-icon"><font-awesome-icon :icon="['fas', 'building']"/></span>
                  <span class="sidebar-text">SearchApt</span>
                </router-link>
              </li>
            </ul>
          </div>
        </li>
        <li class="nav-item" :class="{ active: curPage == 'bookmark' }" @click="changePage('bookmark')">
          <router-link to="/bookmark" class="nav-link">
            <span class="sidebar-icon"><font-awesome-icon :icon="['fas', 'star']"/></span>
            <span class="sidebar-text">Bookmark</span>
          </router-link>
        </li>
        <li class="nav-item" :class="{ active: curPage == 'community' }" @click="changePage('community')">
          <router-link to="/community" class="nav-link">
            <span class="sidebar-icon"><font-awesome-icon :icon="['fas', 'comment-dots']"/></span>
            <span class="sidebar-text">Community</span>
          </router-link>
        </li>
        <li class="nav-item" :class="{ active: curPage == 'contact' }" @click="changePage('contact')">
          <router-link to="/contact" class="nav-link">
            <span class="sidebar-icon"><font-awesome-icon :icon="['fas', 'phone']"/></span>
            <span class="sidebar-text">Contact</span>
          </router-link>
        </li>
      </ul>
    </div>
  </nav>
</template>

<script>
export default {
  name: 'SideBar',
  data() {
    return {
      curPage: 'MainPage',
    };
  },
  methods: {
    changePage(page) {
      console.log('changePage : ' + page);
      this.curPage = page;
    },
  },
};
</script>
