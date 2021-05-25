<template>
  <nav id="sidebarMenu" class="sidebar d-md-block bg-dark text-white " data-simplebar>
    <div class="sidebar-inner px-2 pt-3">
      <ul class="nav flex-column pt-3 pt-md-0">
        <li class="nav-item mt-2 mb-2" :class="{ active: $store.state.curPage == 'Home' }">
          <router-link to="/home" class="nav-link">
            <span class="sidebar-icon"><font-awesome-icon :icon="['fas', 'home']"/></span>
            <span class="sidebar-text">Home</span>
          </router-link>
        </li>

        <li class="nav-item">
          <div>

            <span class="nav-link d-flex justify-content-between align-items-center" data-bs-toggle="collapse" data-bs-target="#searchSub" aria-expanded="false" aria-controls="searchSub">
              <span>
                <span class="sidebar-icon"><font-awesome-icon :icon="['fas', 'search']"/></span>
                <span class="sidebar-text">Search</span>
              </span>
              <span class="link-arrow"><font-awesome-icon :icon="['fas', 'chevron-right']"/></span>
            </span>
          </div>
          <div class="multi-level collapse" id="searchSub">
            <ul class="flex-column nav">
              <li class="nav-item" :class="{ active: $store.state.curPage == 'searchDong' }">
                <router-link to="/searchDong" class="nav-link">
                  <span class="sidebar-icon"><font-awesome-icon :icon="['fas', 'map-marked-alt']"/></span>
                  <span class="sidebar-text">SearchDong</span>
                </router-link>
              </li>
              <li class="nav-item" :class="{ active: $store.state.curPage == 'searchApt' }">
                <router-link to="/searchApt" class="nav-link">
                  <span class="sidebar-icon"><font-awesome-icon :icon="['fas', 'building']"/></span>
                  <span class="sidebar-text">SearchApt</span>
                </router-link>
              </li>
            </ul>
          </div>
        </li>

        <li class="nav-item">
          <div>
            <span class="nav-link d-flex justify-content-between align-items-center" data-bs-toggle="collapse" data-bs-target="#bookmarkSub" aria-expanded="false" aria-controls="bookmarkSub">
              <span>
                <span class="sidebar-icon"><font-awesome-icon :icon="['fas', 'star']"/></span>
                <span class="sidebar-text">Bookmark</span>
              </span>
              <span class="link-arrow"><font-awesome-icon :icon="['fas', 'chevron-right']"/></span>
            </span>
          </div>
          <div class="multi-level collapse" id="bookmarkSub">
            <ul class="flex-column nav">
              <li class="nav-item" :class="{ active: $store.state.curPage == 'bookmarkArea' }">
                <router-link to="/bookmarkArea" class="nav-link">
                  <span class="sidebar-icon"><font-awesome-icon :icon="['fas', 'map-marked-alt']"/></span>
                  <span class="sidebar-text">관심 지역 모아 보기</span>
                </router-link>
              </li>
              <li class="nav-item" :class="{ active: $store.state.curPage == 'bookmarkHouse' }">
                <router-link to="/bookmarkHouse" class="nav-link">
                  <span class="sidebar-icon"><font-awesome-icon :icon="['fas', 'building']"/></span>
                  <span class="sidebar-text">관심 매물 모아 보기</span>
                </router-link>
              </li>
            </ul>
          </div>

        </li>
        <li class="nav-item mt-2 mb-2" :class="{ active: $store.state.curPage == 'info' }">
          <router-link to="/info" class="nav-link">
            <span class="sidebar-icon"><font-awesome-icon :icon="['fas', 'info-circle']"/></span>
            <span class="sidebar-text">자치구별 정보</span>
          </router-link>
        </li>
        <li class="nav-item mt-2 mb-2" :class="{ active: $store.state.curPage == 'schoolZone' }">
          <router-link to="/schoolZone" class="nav-link">
            <span class="sidebar-icon"><font-awesome-icon :icon="['fas', 'school']"/></span>
            <span class="sidebar-text">School Zone</span>
          </router-link>
        </li>
        <li class="nav-item mt-2 mb-2" :class="{ active: $store.state.curPage == 'community' }">
          <router-link to="/community" class="nav-link">
            <span class="sidebar-icon"><font-awesome-icon :icon="['fas', 'comment-dots']"/></span>
            <span class="sidebar-text">Community</span>
          </router-link>
        </li>
        <li class="nav-item mt-2 mb-2" :class="{ active: $store.state.curPage == 'contact' }">
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
};
</script>

<style scoped>
span{
  font-size:13pt;
}
</style>