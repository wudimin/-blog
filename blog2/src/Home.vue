<template>
  <div id="home" class="aaa">
    <el-container>
      <el-header>header</el-header>
        <el-container>
          <el-container>
            <el-main>Main</el-main>
            <el-aside width="200px">Aside</el-aside>
          </el-container>
          <el-footer>Footer</el-footer>
        </el-container>
    </el-container>

  </div>
</template>

<script>
  import Header from "./views/Header";
  import Footer from "./views/Footer";
  import article from "./views/Article";
  import Aside from "./views/Aside";

    export default {
        name: "Home",
      data (){
        return {

        }
      },
      components:{
        'el-header':Header,
        'el-footer':Footer,
        'el-main': article,
        'el-aside': Aside

      },

    }
</script>

<style scoped>
  .aaa {
    background-color: #F9F7E8;
  }
  .el-header, .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
  }

  .el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    line-height: 100px;
  }

  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 160px;
  }

  body > .el-container {
    margin-bottom: 40px;
  }

  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }

  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }
</style>
