<template>
  <nav id="sidebarMenu" class="sidebar d-md-block bg-dark text-white collapse" data-simplebar>
    <div class="sidebar-inner px-2 pt-3">
      <ul class="nav flex-column pt-3 pt-md-0">
        <li class="nav-item" :class="{ active: curPage == 'search' }" @click="changePage('search')">
          <router-link to="/house" class="nav-link">
            <span class="sidebar-icon"><font-awesome-icon :icon="['fas', 'search']"/></span>
            <span class="sidebar-text">Search</span>
          </router-link>
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
      curPage: 'search',
      searchBreadCrumb: {
        title: 'Search',
        subTitle: '매물 / 거래정보 검색',
        desc: '원하는 지역의 매물정보를 확인해보세요.',
      },
      bookmarkBreadCrumb: {
        title: 'Bookmark',
        subTitle: '관심 매물 / 관심 지역 검색',
        desc: '관심 매물 혹은 관심 지역의 매물정보를 확인해보세요.',
      },
      communityBreadCrumb: {
        title: 'Community',
        subTitle: '커뮤니티',
        desc: '커뮤니티에서 자유롭게 소통하세요.',
      },
      contactBreadCrumb: {
        title: 'Contact',
        subTitle: '문의',
        desc: '자유롭게 문의하세요.',
      },
    };
  },
  methods: {
    changePage(page) {
      this.curPage = page;
      if (page === 'search') this.$emit('change-page', { page: page, breadCrumbInfo: this.searchBreadCrumb });
      else if (page === 'bookmark') this.$emit('change-page', { page: page, breadCrumbInfo: this.bookmarkBreadCrumb });
      else if (page === 'community') this.$emit('change-page', { page: page, breadCrumbInfo: this.communityBreadCrumb });
      else if (page === 'contact') this.$emit('change-page', { page: page, breadCrumbInfo: this.contactBreadCrumb });
    },
  },
};
</script>
