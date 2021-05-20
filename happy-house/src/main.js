import Vue from 'vue';
import App from './App.vue';
import router from './routers/routers.js';

// for bootstrap 5
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap';

//fort-awesome
import { library } from '@fortawesome/fontawesome-svg-core';
import { faSearch, faStar, faCommentDots, faHome, faPhone, faChevronRight, faBuilding, faMapMarkedAlt } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';

library.add(faSearch, faStar, faCommentDots, faHome, faPhone, faChevronRight, faBuilding, faMapMarkedAlt);

Vue.component('font-awesome-icon', FontAwesomeIcon);

Vue.config.productionTip = false;

new Vue({
  render: (h) => h(App),
  router,
}).$mount('#app');
