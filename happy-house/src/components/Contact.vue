<template>
  <main class="content">
    <!-- <div class="row">
      <span>
        <span class="d-inline-block"><font-awesome-icon :icon="['fas', 'map-marker']" class="d-flex justify-content-center" style="width:30px"/></span>
        <span class="d-inline-block"><h6>(SSAFY) 서울시 강남구 테헤란로 멀티캠퍼스</h6></span>
      </span>
    </div>
    <div class="row">
      <span>
        <span class="d-inline-block"><font-awesome-icon :icon="['fas', 'phone']" class="d-flex justify-content-center" style="width:30px"/></span>
        <span class="d-inline-block"><h6>1544-9001</h6></span>
      </span>
    </div>
    <div class="row">
      <span>
        <span class="d-inline-block"><font-awesome-icon :icon="['fas', 'envelope']" class="d-flex justify-content-center" style="width:30px"/></span>
        <span class="d-inline-block">
          <h6><a href="#">admin@ssafy.com</a></h6>
        </span>
      </span>
    </div> -->

    <div class="row m-8 p-3 mt-2" style="text-align:center; justify-content:space-between;">
                              
                        
                <div class="card col p-2 border-light shadow-sm cust_box  page-preview scale-up-2">
                                <div class="card-body pb-3">
                                    <img src="../assets/img/team/sonProfile.jpeg" class="user-avatar scale-up-2 mt-5 large-avatar rounded-circle mx-auto mb-4" alt="Neil Portrait">
                                    <h4 class="h2">손동우</h4>
                                    <h5 class="fw-normal">DONGWOO SOHN</h5>
                                     <h6 class="fw-normal">SSAFY 5기 <br> 서울 13반</h6>
                                    <div style="text-align:left; margin-left:20px;">
                                      <p class="text-gray mt-5 mb-0  page-preview scale-up-2 "><img src="../assets/img/email.png" class="cust-icon"> samsohn0128@gmail.com</p>
                                      <p class="text-gray mt-0 mb-0  page-preview scale-up-2"><img src="../assets/img/github.png" class="cust-icon"> <a href="https://github.com/samsohn0128">samsohn0128</a></p>
                                      <p class="text-gray mt-0 mb-0  page-preview scale-up-2"><img src="../assets/img/instagram.png" class="cust-icon"> <a href="https://www.instagram.com/boong_bara/">@boong_bara</a></p>
                                      <p class="text-gray mt-0  mb-0   page-preview scale-up-2"><img src="../assets/img/phone.png" class="cust-icon"> 010-8863-6808</p>
                                      </div>
                                </div>
                </div>
                <div class="card col p-2 border-light shadow-sm cust_box  page-preview scale-up-2">
                                <div class="card-body pb-3">
                                    <img src="../assets/img/team/daProfile.jpg" class="user-avatar scale-up-2 mt-5 large-avatar rounded-circle mx-auto mb-4" alt="Neil Portrait">
                                    <h4 class="h2 fw-bold">조다운</h4>
                                    <h5 class="fw-normal">DAUN JO</h5>
                            
                                    <h6 class="fw-normal">SSAFY 5기 <br> 서울 13반</h6>
                                   
                                    <div style="text-align:left; margin-left:20px;">
                                      <p class="text-gray mt-5 mb-0  page-preview scale-up-2"><img src="../assets/img/email.png" class="cust-icon"> jodawooooon@naver.com</p>
                                      <p class="text-gray mt-0 mb-0  page-preview scale-up-2"><img src="../assets/img/github.png" class="cust-icon"> <a href="https://github.com/jodawoooon">jodawoooon</a></p>
                                      <p class="text-gray mt-0 mb-0  page-preview scale-up-2"><img src="../assets/img/instagram.png" class="cust-icon"> <a href="https://www.instagram.com/jodawooooon/">@jodawoooon</a></p>
                                      <p class="text-gray mt-0 mb-0  page-preview scale-up-2"><img src="../assets/img/phone.png" class="cust-icon"> 010-9334-4135</p>
                                      </div>
                                </div>
                </div>
                <div class="card col p-2 border-light shadow-sm cust_box  page-preview scale-up-2">
                                <div class="card-body pb-5">
                                    <img src="../assets/img/team/jeonProfile.png" class="user-avatar scale-up-2 mt-5 large-avatar rounded-circle mx-auto mb-4" alt="Neil Portrait">
                                    <h4 class="h2">전중훈</h4>
                                    <h5 class="fw-normal">JOONGHOON JEON</h5>
                                    <h6 class="fw-normal">SSAFY 5기 <br> 서울 13반</h6>
                                    <div  style="text-align:left; margin-left:20px;">
                                      <p class="text-gray mt-5 mb-0  page-preview scale-up-2"><img src="../assets/img/email.png" class="cust-icon"> uj02017@naver.com</p>
                                      <p class="text-gray mt-0 mb-0  page-preview scale-up-2"><img src="../assets/img/github.png" class="cust-icon"> <a href="https://github.com/uj02017">uj02017</a></p>
                                      <p class="text-gray mt-0 mb-0  page-preview scale-up-2"><img src="../assets/img/instagram.png" class="cust-icon"> <a href="https://www.instagram.com/jeonjjoong/">@jeonjjoong</a></p>
                                      <p class="text-gray mt-0 mb-0  page-preview scale-up-2"><img src="../assets/img/phone.png" class="cust-icon"> 010-9191-1890</p>
                                      </div>
                                </div>
                </div>
                
           
    </div>
  </main>
</template>

<script>
export default {
  name: 'Contact',
  data() {
    return {};
  },
  mounted() {
    this.$store.commit('SET_BREADCRUMB_INFO', {
      isHome : false,
      title: 'Contact',
      subTitle: 'Contact',
      desc: '저희 HAPPY HOUSE를 이용해 주셔서 감사합니다!',
    });
    this.$store.commit('SET_CUR_PAGE', 'contact');
  },
};
</script>

<style>
.cust_box{
  margin-left:10px;
}
.cust-icon{
  width:15px;
  margin-right:5px;
}

.cust_box:hover{
  background-color: #f3b773
}
</style>
