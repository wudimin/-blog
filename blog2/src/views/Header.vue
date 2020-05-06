<template>
  <el-menu
    :default-active="activeIndex2"
    class="el-menu-demo"
    mode="horizontal"
    @select="handleSelect"
    background-color="#E54B4B"
    text-color="#fff"
    active-text-color="#FEFBFB">
    <el-menu-item index="1">首页</el-menu-item>
    <el-menu-item index="2" disabled>关于我</el-menu-item>
  </el-menu>
</template>
<!--FEFBFB-->
<script>
  export default {
    data() {
      return {
        activeIndex: '1',
        activeIndex2: '1'
      };
    },
    methods: {
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
      }
    }
  }
</script>

<style>

</style>
