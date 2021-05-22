<template>
  <main class="content">
    <div class="py-4 p-4">
      <nav aria-label="breadcrumb">
        <ol class="breadcrumb breadcrumb-dark breadcrumb-transparent">
          <li class="breadcrumb-item">
            <a href="#"><font-awesome-icon :icon="['fas', 'home']"/></a>
          </li>
          <li class="breadcrumb-item">
            <a href="#">{{ $store.state.breadCrumbInfo.title }}</a>
          </li>
        </ol>
      </nav>
      <div class="d-flex justify-content-between w-100 flex-wrap">
        <div class="mb-3 mb-lg-0">
          <p style="font-size:30px; font-weight:bold;">{{ $store.state.breadCrumbInfo.subTitle }}</p>
          <p class="mb-0">{{ $store.state.breadCrumbInfo.desc }}</p>
        </div>
      </div>
    </div>
  </main>
</template>

<script>
export default {
  name: 'BreadCrumb',
};
</script>

<style></style>
