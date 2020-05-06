import Vue from 'vue'
import App from './App'
import router from './router'

// 导入 ElementUI
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import Axios from "axios";
import VueAxios from "vue-axios";

// 安装路由
Vue.use(router);
// 安装 ElementUI
Vue.use(ElementUI);
Vue.use(VueAxios,Axios)

Vue.config.productionTip = false

new Vue({
  el: '#app',
  // 启用路由
  router,
  // 启用 ElementUI
  render: h => h(App)
})
