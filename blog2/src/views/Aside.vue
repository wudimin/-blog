<template>

  <el-col :span="14">
    <br/>
    <el-card shadow="hover" class="aaa">
      <h4>最新公告</h4>
      <ul>
        <li v-for="(item,index) in notices" :key="index">
          <h5 @click="toNoticeDetail(item.id)">{{item.title}}</h5>
          <div style="padding: 1px;">
            <time class="time">{{item.created}}</time>
          </div>
          <hr/>
        </li>
      </ul>
    </el-card>
    <br/><br/>
    <el-card shadow="hover" class="aaa">
      <h4>热度文章</h4>
      <ul>
        <li v-for="(item,index) in top" :key="index">
          <h5 @click="toArticleDetail(item.id)">{{item.title}}</h5>
          <div style="padding: 1px;">
            <time class="time">{{item.created}}</time>
          </div>
          <hr/>
        </li>
      </ul>
    </el-card>
  </el-col>


</template>

<script>
  export default {
    data() {
      return {
        notices: null,
        top: null,
      }
    },

    created(){
      this.fetchData();
      this.fatchDataById();
    },
    methods: {
      fetchData() {
        var vm = this;
        this.axios({
          method: 'GET',
          url: 'http://localhost:8080/blog/notices',
        }). then(function(resp) {
          vm.notices = resp.data
        });
      },

      toNoticeDetail(id) {
        this.$router.push("/notice/"+id)
      },

      fatchDataById() {
        var vm = this;
        this.axios({
          method: 'GET',
          url: 'http://localhost:8080/blog/top',
        }). then(function(resp) {
          vm.top = resp.data
        });
      },
      toArticleDetail(id) {
        this.$router.push("/articleDetail/"+id)
      }

    }
  }
</script>

<style scoped>
  .aaa{
    background-color: #AC88D7;
  }
  .time {
    font-size: 13px;
    color: #FFEFE5;
  }
  .bottom {
    margin-top: 13px;
    line-height: 12px;
  }
  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }
  .paper * {
    margin: 20px 0;
  }
</style>
