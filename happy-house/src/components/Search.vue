<template>
  <main class="content">
    <div class="main bg-light p-4">
      <!-- selectbar start  -->
      <div class="col row">
        <div class="col">
          <select id="selectSido" class="form-select form-select-sm" aria-label="시">
            <option selected disabled>시/도</option>
          </select>
        </div>
        <div class="col">
          <select id="selectGugun" class="form-select form-select-sm" aria-label="구">
            <option selected disabled>구/군</option>
          </select>
        </div>
        <div class="col">
          <select id="selectDong" class="form-select form-select-sm" aria-label="동">
            <option selected disabled>동</option>
          </select>
        </div>
        <div class="col">
          <input type="button" id="btnSearch" class="btn btn-warning ml-3" value="검색" disabled />
        </div>
      </div>
      <!-- selectbar end  -->

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
  name: 'Search',
};
</script>

<style></style>
