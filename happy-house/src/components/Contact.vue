<template>
  <main class="content">
    <div class="row">
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
      title: 'Contact',
      subTitle: '문의',
      desc: '자유롭게 문의하세요.',
    });
    this.$store.commit('SET_CUR_PAGE', 'contact');
  },
};
</script>

<style></style>
