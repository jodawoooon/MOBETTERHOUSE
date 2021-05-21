<template>
  <main class="content">
    <h1>This is Home.vue</h1>
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
      subTitle: '메인 페이지',
      desc: '뭔가 메인 페이지가 필요할 것 같다.',
    });
    this.$store.commit('SET_CUR_PAGE', 'Home');
  },
};
</script>

<style></style>
