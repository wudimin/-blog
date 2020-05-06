<template>

  <div class="app-container">
    <div align="center">
      <el-row class="paper">
        <el-col :span="22" v-for="(item,index) in notices" :key="index">
          <el-card shadow="hover" class="aaa">
            <div @click="toNoticeDetail(item.id)">
              <img src="@/assets/img/img.jpg" class="image">
              <h3 >{{item.title}}</h3>
              <div style="padding: -1px;">
                <i class="el-icon-view"><span>{{item.hits}}</span></i>
                &emsp; &emsp;
                <i class="el-icon-s-comment"><span>{{item.comments}}</span></i>
                <br/>
                <time class="time">{{item.created}}</time>
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
        notices: [
          {
            "id": 6,
            "title": "测试",
            "content": null,
            "created": "2020-04-28 12:35:43",
            "thumbnail": "@/assets/upload/thumbnail.jpg",
            "hits": 6,
            "comments": 0,
            "commentList": null
          },
        ],
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
          url: 'http://localhost:8080/blog/articles',
        }).then(function (resp) {
          vm.notices = resp.data
        });
      },

      toNoticeDetail(id) {
         this.$router.push("/articleDetail/"+id)
      }
    }
  }
</script>

<style lang="scss" scoped>
  .time {
    font-size: 13px;
    color: #FFEFE5;
  }
  .bottom {
    margin-top: 13px;
    line-height: 12px;
  }
  .image {
    width: 20%;
    display: block;
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
    margin: 10px 0;
  }
  .aaa {
    background-color: #61BFAD;
  }
</style>
