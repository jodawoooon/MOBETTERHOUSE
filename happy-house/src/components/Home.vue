<template>
  <main class="content">
    <div class="col-12 mb-4">
      <div class="row justify-content-center mb-5 mb-lg-6">
        <div class="row mb-7 mt-7">
          <div class="col-6 col-md-3 text-center mb-4">
            <div class="icon icon-shape icon-lg bg-white shadow-lg border-light rounded-circle icon-secondary mb-4">
              <span class="fas fa-pager"></span>
            </div>
            <h3 class="fw-bolder">매물ㅇㅇ</h3>
            <p class="text-gray">Dashboard Pages</p>
          </div>
          <div class="col-6 col-md-3 text-center mb-4">
            <div class="icon icon-shape icon-lg bg-white shadow-lg border-light rounded-circle icon-secondary mb-4">
              <span class="fas fa-puzzle-piece"></span>
            </div>
            <h3 class="fw-bolder">구별 ㅇㅇ</h3>
            <p class="text-gray">Premium Components</p>
          </div>
          <div class="col-6 col-md-3 text-center">
            <div class="icon icon-shape icon-lg bg-white shadow-lg border-light rounded-circle icon-secondary mb-4">
              <span class="fab fa-sass"></span>
            </div>
            <h3 class="fw-bolder">커뮤니티</h3>
            <p class="text-gray">Sass & Gulp</p>
          </div>
          <div class="col-6 col-md-3 text-center">
            <div class="icon icon-shape icon-lg bg-white shadow-lg border-light rounded-circle icon-secondary mb-4">
              <span class="fab fa-js-square"></span>
            </div>
            <h3 class="fw-bolder">ㅇㅇㅇㅇ</h3>
            <p class="text-gray">Javascript</p>
          </div>
        </div>
      </div>

      <div class="row justify-content-between align-items-center mb-5 mb-lg-7">
        <div class="row justify-content-between align-items-center">
          <div class="col-lg-5 order-lg-2 mb-5 mb-lg-0">
            <h2 class="h1">Bootstrap 5</h2>
            <p class="mb-4 lead fw-bold">Latest version of Bootstrap without jQuery</p>
            <p class="mb-4">Volt is built using the latest version of Bootstrap 5 and we only used Vanilla Javascript for everything including the plugins</p>
            <a href="https://themesberg.com/docs/volt-bootstrap-5-dashboard/components/accordions/" target="_blank" class="btn btn-outline-primary"
              ><span class="fas fa-book me-2"></span> Getting started</a
            >
          </div>
          <div class="col-lg-6 order-lg-1">
            <img src="https://picsum.photos/seed/picsum/500/500" alt="Front pages overview" />
          </div>
        </div>
        <div class="col-lg-5 mb-5 mb-lg-0">
          <h2 class="h1 d-flex align-items-center">Kanban Board <span class="badge-md ms-3 mb-0 fs-6 badge rounded-pill text-dark bg-secondary">Pro</span></h2>
          <p class="mb-4 lead fw-bold">Advanced FullCalendar.js integration</p>
          <p class="mb-4">We created a fully editable calendar where you can add, edit and delete events for your admin dashboard.</p>
          <a href="https://demo.themesberg.com/volt-pro/pages/kanban.html" target="_blank" class="btn btn-secondary text-dark me-3"><span class="fas fa-th me-2"></span> Demo</a>
          <!-- <a href="https://themesberg.com/docs/volt-bootstrap-5-dashboard/plugins/kanban/" target="_blank" class="btn btn-outline-primary"><span class="fas fa-book me-2"></span> Guide</a> -->
        </div>
        <div class="col-lg-6">
          <img src="https://picsum.photos/seed/picsum/500/500" alt="Kanban Preview" />
        </div>
      </div>
      <div class="row justify-content-between align-items-center mb-5 mb-lg-7">
        <div class="col-lg-5 order-lg-2 mb-5 mb-lg-0">
          <h2 class="h1 d-flex align-items-center">Mapbox <span class="badge-md ms-3 mb-0 fs-6 badge rounded-pill text-dark bg-secondary">Pro</span></h2>
          <p class="mb-4 lead fw-bold">Markers and cards integration with Leaflet.js</p>
          <p class="mb-4">You can use this map to add markers with custom cards and show them on a map using our custom MapBox integration with Leaflet.js</p>
          <a href="https://demo.themesberg.com/volt-pro/pages/map.html" target="_blank" class="btn btn-secondary text-dark me-3"><span class="fas fa-map-marked-alt me-2"></span> Demo</a>
          <a href="https://themesberg.com/docs/volt-bootstrap-5-dashboard/plugins/mapbox/" target="_blank" class="btn btn-outline-primary"><span class="fas fa-book me-2"></span> Guide</a>
        </div>
        <div class="col-lg-6 order-lg-1">
          <img src="https://picsum.photos/seed/picsum/500/500" alt="MapBox Leaflet.js Custom Integration Mockup" />
        </div>
      </div>
      <div class="row justify-content-between align-items-center mb-5 mb-lg-7">
        <div class="col-lg-5 mb-5 mb-lg-0">
          <h2 class="h1 d-flex align-items-center">Calendar <span class="badge-md ms-3 mb-0 fs-6 badge rounded-pill text-dark bg-secondary">Pro</span></h2>
          <p class="mb-4 lead fw-bold">Advanced FullCalendar.js integration</p>
          <p class="mb-4">We created a fully editable calendar where you can add, edit and delete events for your admin dashboard.</p>
          <a href="https://demo.themesberg.com/volt-pro/pages/calendar.html" target="_blank" class="btn btn-secondary text-dark me-3"><span class="far fa-calendar-alt me-2"></span> Demo</a>
          <a href="https://themesberg.com/docs/volt-bootstrap-5-dashboard/plugins/calendar/" target="_blank" class="btn btn-outline-primary"><span class="fas fa-book me-2"></span> Guide</a>
        </div>
        <div class="col-lg-6">
          <img src="https://picsum.photos/seed/picsum/500/500" alt="Calendar Preview" />
        </div>
      </div>
      <div class="card border-light shadow-sm">
        <div class="card-header border-bottom border-light d-flex justify-content-between">
          <h2 class="h5 mb-0">Team members</h2>
          <a href="#" class="btn btn-sm btn-secondary">See all</a>
        </div>
        <div class="card-body">
          <ul class="list-group list-group-flush list my--3">
            <li class="list-group-item px-0">
              <div class="row align-items-center">
                <div class="col-auto">
                  <!-- Avatar -->
                  <a href="#" class="user-avatar">
                    <img class="rounded-circle" alt="Image placeholder" src="../assets/img/team/profile-picture-1.jpg" />
                  </a>
                </div>
                <div class="col-auto ms--2">
                  <h4 class="h6 mb-0">
                    <a href="#!">Chris Wood</a>
                  </h4>
                  <span class="text-success">●</span>
                  <small>Online</small>
                </div>
                <div class="col text-right">
                  <a href="#" class="btn btn-sm btn-tertiary"><i class="fas fa-calendar-check me-1"></i> Invite</a>
                </div>
              </div>
            </li>
            <li class="list-group-item px-0">
              <div class="row align-items-center">
                <div class="col-auto">
                  <!-- Avatar -->
                  <a href="#" class="user-avatar">
                    <img class="rounded-circle" alt="Image placeholder" src="../assets/img/team/profile-picture-2.jpg" />
                  </a>
                </div>
                <div class="col-auto ms--2">
                  <h4 class="h6 mb-0">
                    <a href="#!">Jose Leos</a>
                  </h4>
                  <span class="text-warning">●</span>
                  <small>In a meeting</small>
                </div>
                <div class="col text-right">
                  <a href="#" class="btn btn-sm btn-tertiary"><i class="fas fa-comment me-1"></i> Message</a>
                </div>
              </div>
            </li>
            <li class="list-group-item px-0">
              <div class="row align-items-center">
                <div class="col-auto">
                  <!-- Avatar -->
                  <a href="#" class="user-avatar">
                    <img class="rounded-circle" alt="Image placeholder" src="../assets/img/team/profile-picture-3.jpg" />
                  </a>
                </div>
                <div class="col-auto ms--2">
                  <h4 class="h6 mb-0">
                    <a href="#!">Bonnie Green</a>
                  </h4>
                  <span class="text-danger">●</span>
                  <small>Offline</small>
                </div>
                <div class="col text-right">
                  <a href="#" class="btn btn-sm btn-tertiary"><i class="fas fa-calendar-check me-1"></i> Invite</a>
                </div>
              </div>
            </li>
            <li class="list-group-item px-0">
              <div class="row align-items-center">
                <div class="col-auto">
                  <!-- Avatar -->
                  <a href="#" class="user-avatar">
                    <img class="rounded-circle" alt="Image placeholder" src="../assets/img/team/profile-picture-4.jpg" />
                  </a>
                </div>
                <div class="col-auto ms--2">
                  <h4 class="h6 mb-0">
                    <a href="#">Neil Sims</a>
                  </h4>
                  <span class="text-success">●</span>
                  <small>Online</small>
                </div>
                <div class="col text-right">
                  <a href="#" class="btn btn-sm btn-tertiary"><i class="fas fa-comment me-1"></i> Message</a>
                </div>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </main>
</template>

<script>
export default {
  name: 'Home',
  data() {
    return {};
  },
  mounted() {
    
      this
            .$store
            .commit('SET_BREADCRUMB_INFO', {
                isHome : true,
                title: '',
                subTitle: '',
                desc: ''
            });
        this
            .$store
            .commit('SET_CUR_PAGE', 'Home');
            console.log(this.$store.state.userInfo.isLogin);
   
  },
};
</script>

<style></style>
