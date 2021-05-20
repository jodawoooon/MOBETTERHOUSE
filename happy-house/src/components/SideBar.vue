<template>
  <nav id="sidebarMenu" class="sidebar d-md-block bg-dark text-white collapse" data-simplebar>
    <div class="sidebar-inner px-2 pt-3">
      <ul class="nav flex-column pt-3 pt-md-0">
        <li class="nav-item active">
          <a href="#" class="nav-link">
            <span class="sidebar-icon"><font-awesome-icon :icon="['fas', 'search']"/></span>
            <span class="sidebar-text">Search</span>
          </a>
        </li>
        <li class="nav-item">
          <a href="#" class="nav-link">
            <span class="sidebar-icon"><font-awesome-icon :icon="['fas', 'star']"/></span>
            <span class="sidebar-text">Bookmark</span>
          </a>
        </li>
        <li class="nav-item">
          <a href="#" class="nav-link">
            <span class="sidebar-icon"><font-awesome-icon :icon="['fas', 'comment-dots']"/></span>
            <span class="sidebar-text">Community</span>
          </a>
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
