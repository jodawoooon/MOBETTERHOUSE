import Vue from 'vue';
import App from './App.vue';
import router from './routers/routers.js';
import store from './store/store.js';
import VueAlertify from 'vue-alertify';
import VueSweetalert2 from 'vue-sweetalert2';

// for bootstrap 5
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap';

import 'sweetalert2/dist/sweetalert2.min.css';

//fort-awesome
import { library } from '@fortawesome/fontawesome-svg-core';
import {
  faSearch,
  faStar as fasStar,
  faCommentDots,
  faHome,
  faPhone,
  faUser,
  faChevronRight,
  faBuilding,
  faMapMarkedAlt,
  faMapMarker,
  faEnvelope,
  faSpinner,
  faUnlock,
  faUserShield,
  faSignOutAlt,
  faUserCircle,
  faUserEdit,
  faEraser,
  faAngleLeft,
  faPaperclip,
  faKey,
  faImage,
  faUpload,
  faSchool,
  faInfoCircle,
  faSignInAlt,
  faUserPlus,

} from '@fortawesome/free-solid-svg-icons';
import { faStar as farStar } from '@fortawesome/free-regular-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';

library.add(
  faSearch,
  fasStar,
  farStar,
  faCommentDots,
  faHome,
  faPhone,
  faUser,
  faChevronRight,
  faBuilding,
  faMapMarkedAlt,
  faMapMarker,
  faEnvelope,
  faSpinner,
  faUnlock,
  faUserShield,
  faSignOutAlt,
  faUserCircle,
  faUserEdit,
  faEraser,
  faAngleLeft,
  faPaperclip,
  faKey,
  faImage,
  faUpload,
  faSchool,
  faInfoCircle,
  faSignInAlt,
  faUserPlus,
);

Vue.component('font-awesome-icon', FontAwesomeIcon);
Vue.use(VueAlertify);
Vue.use(VueSweetalert2);



Vue.config.productionTip = false;

new Vue({
  render: (h) => h(App),
  router,
  store,
}).$mount('#app');
