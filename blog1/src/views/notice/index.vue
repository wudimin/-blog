<template>
  <div class="app-container">
    <div class="container" align="center">
      <div class="grid-content" >
        <el-button type="success" @click="addNotice">发布新公告</el-button>
      </div>

      <el-row class="paper">
        <el-col :span="12" v-for="(item,index) in notices" :key="index">
          <el-card shadow="hover" >
            <h3 @click="toNoticeDetail(item.id)">{{item.title}}</h3>
            <div style="padding: 14px;">
              <time class="time">{{item.created}}</time>
              <div class="bottom clearfix">
                <el-button type="primary" icon="el-icon-edit" circle @click="editNot(item.id)"></el-button>
                <el-button type="danger" icon="el-icon-delete" circle @click="delNotice(item.id)"></el-button>
              </div>
            </div>
          </el-card>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        notices: null,
        loading: false,
      }

    },

    created() {
      this.fetchData()
    },

    methods: {

      addNotice() {
        this.$router.push("/notice/add")
      },

      delNotice(id){
        var vm = this;
        this.axios({
          method: 'DELETE',
          url: 'http://localhost:8080/blog/notice/'+id,
        }). then(function(resp) {
          if(resp.data == "success"){
            //消息弹框
            vm.$message({
              message: '删除成功',
              type: 'success'
            });
            //更新数据
            vm.fetchData()
          }
        }).catch(function(error) {
          vm.$message.error('删除失败');
        })
      },
      editNot(id){
        this.$router.push("/editNotice/index/"+id)
      },

      fetchData() {
        var vm = this;
        this.axios({
          method: 'GET',
          url: 'http://localhost:8080/blog/notices',
        }). then(function(resp) {
          //vm.list = resp.data
          vm.notices = resp.data
        });
      },

      toNoticeDetail(id) {
        this.$router.push("/noticeDetail/index/"+id)
      }
    }
  }
</script>

<style lang="scss" scoped>
  .time {
    font-size: 13px;
    color: #999;
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
