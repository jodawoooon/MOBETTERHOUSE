<template>
  <main class="content">
    <h1>This is MainPage.vue</h1>
  </main>
</template>

<script>
export default {
  name: 'MainPage',
  data() {
    return {
      breadCrumbInfo: {
        title: 'MainPage',
        subTitle: '메인 페이지',
        desc: '뭔가 메인 페이지가 필요할 것 같다.',
      },
    };
  },
  mounted() {
    this.$emit('change-page', this.breadCrumbInfo);
  },
};
</script>

<style></style>
