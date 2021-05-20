<template>
  <div>
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
              <li class="nav-item active" id="navItem1">
                <a class="nav-link" href="#">공지 사항<span class="sr-only">(current)</span></a>
              </li>
              <li class="nav-item active" style="display: none" id="navItem2">
                <a class="nav-link text-light" href="#">오늘의 뉴스<span class="sr-only">(current)</span> </a>
              </li>
              <li class="nav-item active" style="display: none" id="navItem3">
                <a class="nav-link text-light" href="#">커뮤니티<span class="sr-only">(current)</span></a>
              </li>
              <li class="nav-item active" id="navItem4" style="display: none">
                <button id="signUp" class="nav-item btn btn-light"><i class="fa fa-user"></i> Sign Up</button>
              </li>
              <li class="nav-item active" id="navItem5" style="display: none">
                <button id="login" class="nav-item btn btn-light"><i class="fa fa-lock"></i> Login</button>
              </li>
              <li class="nav-item active" id="navItem6">
                <button id="logout" class="nav-item btn btn-light"><i class="bi bi-person-x-fill"></i> Logout</button>
              </li>
              <li class="nav-item active" id="navItem7">
                <button id="myPage" class="nav-item btn btn-light"><i class="bi bi-person-square"></i> My Page</button>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <hr />
    </main>
  </div>
</template>

<script>
export default {};
</script>

<style></style>
