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
    this.$emit('change-page', this.breadCrumbInfo);
  },
};
</script>

<style></style>
