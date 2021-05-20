<template>
  <main class="content">
    <nav class="navbar navbar-top navbar-expand navbar-dashboard navbar-dark ps-0 pe-2 pb-0">
      <div class="container-fluid px-0">
        <div class="d-flex justify-content-between w-100" id="navbarSupportedContent">
          <div class="d-flex">
            <button id="btnSsafyLogo" class="navbar-brand btn">
              <img class="img-fluid" style="width: 80px; height: 80px" src="@/assets/img/ssafy_logo.png" alt="" />
            </button>
          </div>
          <ul class="navbar-nav align-items-center">
            <li class="nav-item" id="navItem1">
              <strong>{{ userInfo.userName }}({{ userInfo.userEmail }})</strong>님 환영합니다.
            </li>
            <li class="nav-item" id="navItem2">
              <button id="logout" class="nav-item btn btn-light"><i class="bi bi-person-x-fill"></i> Logout</button>
            </li>
            <li class="nav-item" id="navItem3">
              <button id="myPage" class="nav-item btn btn-light"><i class="bi bi-person-square"></i> My Page</button>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <hr />
  </main>
</template>

<script>
export default {
  name: 'NavBar',
  props: ['isLogin', 'userInfo'],
};
</script>

<style></style>
