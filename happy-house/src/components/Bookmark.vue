<template>
  <main class="content">
    <h1>This is Bookmark.vue</h1>
  </main>
</template>

<script>
export default {
  name: 'Bookmark',
  data() {
    return {};
  },
  mounted() {
    this.$store.commit('SET_BREADCRUMB_INFO', {
      title: 'Bookmark',
      subTitle: '관심 매물 / 관심 지역 검색',
      desc: '관심 매물 혹은 관심 지역의 매물정보를 확인해보세요.',
    });
    this.$store.commit('SET_CUR_PAGE', 'bookmark');
  },
};
</script>

<style></style>
