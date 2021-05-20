<template>
  <main class="content">
    <h1>This is Contact.vue</h1>
  </main>
</template>

<script>
export default {
  name: 'Contact',
  data() {
    return {
      breadCrumbInfo: {
        title: 'Contact',
        subTitle: '문의',
        desc: '자유롭게 문의하세요.',
      },
    };
  },
  mounted() {
    this.$emit('change-page', this.breadCrumbInfo);
  },
};
</script>

<style></style>
