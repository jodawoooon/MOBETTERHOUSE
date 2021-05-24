<template>
  <main class="content">

     
      <div class="col-12 mb-4">
<div class="mb-4">
    test IMG
                                    <img src="@/assets/img/window_back_img.jpg">
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
                                                    <img class="rounded-circle" alt="Image placeholder" src="../assets/img/team/profile-picture-1.jpg">
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
                                                        <img class="rounded-circle" alt="Image placeholder" src="../assets/img/team/profile-picture-2.jpg">
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
                                                        <img class="rounded-circle" alt="Image placeholder" src="../assets/img/team/profile-picture-3.jpg">
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
                                                        <img class="rounded-circle" alt="Image placeholder" src="../assets/img/team/profile-picture-4.jpg">
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
    this.$store.commit('SET_BREADCRUMB_INFO', {
      title: 'Home',
      subTitle: 'Overview',
      desc: '정보 한눈에 볼 수 있는 페이지? + 우리 팀 소개',
    });
    this.$store.commit('SET_CUR_PAGE', 'Home');
    
    if(this.$store.state.userInfo.isLogin==false){
        this.$router.push('/');
    }
    console.log(this.$store.state.userInfo.userSeq);
    

  },
  
};
</script>

<style>

</style>
