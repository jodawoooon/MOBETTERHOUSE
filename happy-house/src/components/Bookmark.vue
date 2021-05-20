<template>
  <main class="content">
    <h1>This is Bookmark.vue</h1>
  </main>
</template>

<script>
export default {
  name: 'Bookmark',
  data() {
    return {
      breadCrumbInfo: {
        title: 'Bookmark',
        subTitle: '관심 매물 / 관심 지역 검색',
        desc: '관심 매물 혹은 관심 지역의 매물정보를 확인해보세요.',
      },
    };
  },
  mounted() {
    this.$emit('change-page', this.breadCrumbInfo);
  },
};
</script>

<style></style>
