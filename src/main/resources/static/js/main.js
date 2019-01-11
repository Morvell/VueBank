import Vue from 'vue'
import Vuelidate from 'vuelidate'
import VueResource from 'vue-resource'
import App from 'pages/App.vue'
import VueRouter from 'vue-router'
import PayAnyCard from 'components/pay/PayAnyCard.vue'
import PayYouBank from 'components/pay/PayYouBank.vue'
import RequestMoney from 'components/request/RequestMoney.vue'
import Pay from 'components/pay/Pay.vue'
import VueTheMask from 'vue-the-mask'
import Notifications from 'vue-notification'

Vue.use(Vuelidate);
Vue.use(VueResource);
Vue.use(VueRouter);
Vue.use(VueTheMask);
Vue.use(Notifications);

var router = new VueRouter({
  routes: [
    {path: '/', component: Pay,
      children: [
        {
          path: '',
          component: PayAnyCard
        },
        {
          path: 'pay-you-bank',
          component: PayYouBank
        }]},
    // {path: '/', component: PayAnyCard},
    // {path: '/pay-you-bank', component: PayYouBank},
    {path: '/request', component: RequestMoney}
  ]
});

new Vue({
  el: '#app',
  router: router,
  render: a => a(App),
});
