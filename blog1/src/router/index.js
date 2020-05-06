import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

export const constantRoutes = [
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },

  {
    path: '/404',
    component: () => import('@/views/404'),
    hidden: true
  },

  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [{
      path: 'dashboard',
      name: 'Dashboard',
      component: () => import('@/views/dashboard/index'),
      meta: { title: '后台管理', icon: 'dashboard' }
    }]
  },

  {
    path: '/product',
    // alwaysShow: true,
    component: Layout,
    redirect: '/product/index',
    name: 'Example',
    meta: { title: '博客管理', icon: 'example' },
    children: [
      {
        path: 'products',
        name: 'Products',
        component: () => import('@/views/products/index'),
        meta: { title: '博客列表', icon: 'table' }
      },
      {
        path: 'addProduct',
        name: 'addProduct',
        component: () => import('@/views/addProduct/index'),
        meta: { title: '写博客', icon: 'form' }
      }
    ]
  },

  {
    path: '/editProduct',
    //设置为 true ，该路由不会出现在侧边栏中
    hidden: true,
    component: Layout,
    children: [
      {
        path: 'index/:id',
        name: 'editProduct',
        component: () => import('@/views/editProduct/index'),
        meta: { title: '商品编辑', icon: 'edit' }
      }
    ]
  },

  {
    path: '/comment',
    component: Layout,
    children: [
      {
        path: 'index',
        name: 'Comment',
        component: () => import('@/views/comment/index'),
        meta: { title: '评论管理', icon: 'form' }
      }
    ]
  },

  {
    path: '/notice',
    component: Layout,
    children: [
      {
        path: 'index',
        name: 'Notice',
        component: () => import('@/views/notice/index'),
        meta: { title: '公告栏', icon: 'form' }
      }
    ]
  },
  {
    path: '/notice',
    component: Layout,
    children: [
      {
        path: 'add',
        hidden: true,
        name: 'AddNotice',
        component: () => import('@/views/notice/add'),
        //meta: { title: '新增公告', icon: 'news' }
      }
    ]
  },

  {
    path: '/noticeDetail',
    //设置为 true ，该路由不会出现在侧边栏中
    hidden: true,
    component: Layout,
    children: [
      {
        path: 'index/:id',
        name: 'NoticeDetail',
        component: () => import('@/views/noticeDetail/index'),
        //meta: { title: '公告详情', icon: 'edit' }
      }
    ]
  },
  {
    path: '/editNotice',
    //设置为 true ，该路由不会出现在侧边栏中
    hidden: true,
    component: Layout,
    children: [
      {
        path: 'index/:id',
        name: 'EditNotice',
        component: () => import('@/views/editNotice/index'),
        //meta: { title: '修改公告', icon: 'edit' }
      }
    ]
  },
  {
    path: '/articleDetail',
    //设置为 true ，该路由不会出现在侧边栏中
    hidden: true,
    component: Layout,
    children: [
      {
        path: 'index/:id',
        name: 'ArticleDetail',
        component: () => import('@/views/articleDetail/index'),
        //meta: { title: '文章详情', icon: 'edit' }
      }
    ]
  },



  // 404 page must be placed at the end !!!
  { path: '*', redirect: '/404', hidden: true }
]

const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
