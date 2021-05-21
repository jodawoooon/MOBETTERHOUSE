<template>
  <main class="content">
    <div class="main bg-light p-4">
      <!-- searchBar start -->
      <div class="row mb-3">
        <div class="col-3"></div>
        <div class="col-4">
          <input type="text" class="form-control" id="searchText" />
        </div>
        <div class="col-2">
          <input type="button" id="btnSearch" class="btn btn-warning ml-3" value="검색" />
        </div>
        <div class="col-3"></div>
      </div>
      <!-- searchBar end -->

      <div class="row m-1">
        <div class="col-4" id="apartInfo">
          <!-- tempInfo start -->
          <div v-for="i in 5" :key="i" class="apart row" id="apartInfo - ' + (i + 1) + '">
            <div class="col-8">
              <h5>Apartment Name {{ i }}</h5>
              <p class="m-0">거래금액: dealAmount</p>
              <p class="m-0">전용면적: area</p>
              <p class="m-0">등록일: dealDate</p>
            </div>
            <div class="col align-self-center" style="text-align: center">
              <i class="bi bi-star bookmarkStar" id="bookmarkStar' + (i + 1) + '" aria-hidden="true" style="color: rgb(255, 226, 95); font-size: 25px">
                <input type="hidden" value="' + dealNo + '" />
              </i>
            </div>
            <hr />
          </div>
          <!-- tempInfo end -->
        </div>
        <div id="map" class="col-8 border border-5" style="height: 550px">Map</div>
      </div>
    </div>
    <div id="paginationWrapper" class="align-self-center">PaginationWrapper</div>
    <div class="mt-4"></div>
  </main>
</template>

<script>
export default {
  naem: 'SearchDong',
  data() {
    return {
      breadCrumbInfo: {
        title: 'SearchApt',
        subTitle: '아파트 이름으로 매물 / 거래정보 검색',
        desc: '원하는 지역의 매물정보를 확인해보세요.',
      },
    };
  },
  mounted() {
    this.$emit('change-page', this.breadCrumbInfo);
  },
};
</script>

<style></style>
