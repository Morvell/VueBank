import Vue from 'vue'
import Vuelidate from 'vuelidate'
import VueResource from 'vue-resource'
import App from 'pages/App.vue'
import VueRouter from 'vue-router'
import PayAnyCard from 'components/pay/PayAnyCard.vue'
import PayYouBank from 'components/pay/PayYouBank.vue'
import VueTheMask from 'vue-the-mask'

Vue.use(Vuelidate);
Vue.use(VueResource);
Vue.use(VueRouter);
Vue.use(VueTheMask)

var router = new VueRouter({
  routes: [
    {path: '/', component: PayAnyCard},
    {path: '/pay-you-bank', component: PayYouBank}
  ]
});

new Vue({
  el: '#app',
  router: router,
  render: a => a(App),
});
