<template>

  <div>
    <el-card class="box-card" v-for="comment in comments">
      <div class="aaa">
        <div slot="header" class="clearfix" align="center">
          <span>{{comment.title}}</span>
        </div>
      </div>

      <div v-for="(item,index) in comment.commentList" :key="index" class="text item">
        {{item.author +"："+ item.content}}
        <el-button type="danger" icon="el-icon-delete" circle @click="delComment(item.id)"></el-button>
      </div>

    </el-card>
  </div>


</template>

<script>
  export default {
    data() {
      return {
        comments: [
          {
            "id": 1,
            "title": "Vue.js前端框架介绍",
            "content": null,
            "created": null,
            "thumbnail": null,
            "hits": null,
            "comments": null,
            "commentList": [
              {
                "id": 1,
                "articleid": null,
                "content": "vue效率高",
                "created": "2020-04-25 15:44:31",
                "author": "匿名"
              },
              {
                "id": 2,
                "articleid": null,
                "content": "vue3.0最新开源",
                "created": "2020-04-25 15:44:31",
                "author": "匿名"
              }
            ]
          },
        ]
      }

    },

    created() {
      this.fetchData()
    },
    methods: {
      fetchData() {
        var vm = this;
        this.axios({
          method: 'GET',
          url: 'http://localhost:8080/blog/comments',
        }). then(function(resp) {
          vm.comments = resp.data
        });
      },

      delComment(id){
        var vm = this;
        this.axios({
          method: 'DELETE',
          url: 'http://localhost:8080/blog/comment/'+id,
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
      }
    }
  }
</script>

<style scoped>
  .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }

  .box-card {
    width: 1000px;
  }
  .aaa {
    font-size: 20px;
    background-color: #b9dec9;
  }
</style>
