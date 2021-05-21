import Vue from 'vue';
import App from './App.vue';
import router from './routers/routers.js';
import store from './store/store.js';

// for bootstrap 5
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap';

//fort-awesome
import { library } from '@fortawesome/fontawesome-svg-core';
import { faSearch, faStar as fasStar, faCommentDots, faHome, faPhone, faChevronRight, faBuilding, faMapMarkedAlt, faMapMarker, faEnvelope, faSpinner } from '@fortawesome/free-solid-svg-icons';
import { faStar as farStar } from '@fortawesome/free-regular-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';

library.add(faSearch, fasStar, farStar, faCommentDots, faHome, faPhone, faChevronRight, faBuilding, faMapMarkedAlt, faMapMarker, faEnvelope, faSpinner);

Vue.component('font-awesome-icon', FontAwesomeIcon);

Vue.config.productionTip = false;

new Vue({
  render: (h) => h(App),
  router,
  store,
}).$mount('#app');
