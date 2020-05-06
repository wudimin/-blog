import Vue from 'vue'
import Router from 'vue-router'

import Home from "../Home";

Vue.use(Router);

export default new Router({
  mode: 'history',

  routes: [
    //公告详情
    {
      path: '/notice/:id',
      name: 'Notice',
      component: () => import('@/views/notice'),
    },
    //文章详情
    {
      path: '/articleDetail/:id',
      name: 'ArticleDetail',
      component: () => import('@/views/articleDetail'),
    },
    //首页
    {
      path: '',
      name: 'Home',
      component: Home,
    },
  ]
});
