<template>
  <!-- Hero -->
  <main>
    <section class="section-header overflow-hidden pt-7 pt-lg-8 pb-9 pb-lg-12 bg-primary text-white" :style="{ backgroundImage: 'url(' + require('@/assets/img/illustrations/signin.svg') + ')'}" style="background-size:cover; ">
        <div class="container">
          <div class="row mt-10">
            <div class="col-12 text-center">
              <div class="bootstrap-big-icon d-none d-lg-block"></div>
              <h1 class="fw-bolder mb-4" style="font-size : 60px;">Happy House</h1>
              
              
              <h2 class="lead fw-normal text-muted mb-2 bg-primary ">원하는 조건의 집을 한눈에 확인하세요!</h2>
              <h2 class="lead fw-normal text-muted mb-5 bg-primary ">똑똑한 내 집 마련의 시작. Happy House</h2>
              <!-- Button Modal -->
              <div class="d-flex align-items-center justify-content-center mb-5">
                  <router-link to="/login" class="btn btn-lg btn-secondary text-dark me-4" >
                    <span class="fas fa-sign-in-alt"></span> sign in
                  </router-link>
                  <router-link to="/join" class="btn btn-lg btn-secondary text-dark" >
                    <span class="fas fa-user-plus"></span> sign up
                  </router-link>
                
              </div>
            </div>
          </div>
        </div>
        <figure class="position-absolute bottom-0 left-0 w-100 d-none d-md-block mb-n2"><svg class="fill-gray-100" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 3000 185.4"><path d="M3000,0v185.4H0V0c496.4,115.6,996.4,173.4,1500,173.4S2503.6,115.6,3000,0z"></path></svg></figure>       
   </section>
     
      
  </main>
      
      
</template>

<script>
export default {
    name : 'Index',
    methods:{
        login(){

        },
        join(){

        }
    },
    
}
</script>

<style>

</style>