<template>
  <main class="content">
    <h1>This is Community.vue</h1>
  </main>
</template>

<script>
export default {
  name: 'Community',
  data() {
    return {
      breadCrumbInfo: {
        title: 'Community',
        subTitle: '커뮤니티',
        desc: '커뮤니티에서 자유롭게 소통하세요.',
      },
    };
  },
  mounted() {
    this.$store.commit('SET_BREADCRUMB_INFO', {
      isHome : false,
      title: 'Community',
      subTitle: '커뮤니티',
      desc: '커뮤니티에서 자유롭게 소통하세요.',
    });
    this.$store.commit('SET_CUR_PAGE', 'community');
  },
};
</script>

<style></style>
