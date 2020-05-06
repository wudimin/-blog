<template>
  <div class="app-container">
    <el-table
      :data="list"
      border
      fit
      highlight-current-row
    >
      <el-table-column align="center" label="序号" width="70">
        <template slot-scope="scope">
          {{ scope.$index +1}}
        </template>
      </el-table-column>

      <el-table-column align="center" label="文章ID" width="70">
        <template slot-scope="scope">
          {{ scope.row.id }}
        </template>
      </el-table-column>

      <el-table-column align="center" label="文章标题" width="280">
        <template slot-scope="scope">
          {{ scope.row.title }}
        </template>
      </el-table-column>

      <el-table-column align="center" label="创作日期" width="200">
        <template slot-scope="scope">
          {{ scope.row.created }}
        </template>
      </el-table-column>

<!--      <el-table-column align="center" label="缩略图" width="190">-->
<!--        <template slot-scope="scope">-->
<!--          {{ scope.row.thumbnail }}-->
<!--        </template>-->
<!--      </el-table-column>-->

      <el-table-column align="center" label="点击量" width="100">
        <template slot-scope="scope">
          {{ scope.row.hits }}
        </template>
      </el-table-column>

      <el-table-column align="center" label="评论量" width="100">
        <template slot-scope="scope">
          {{ scope.row.comments }}
        </template>
      </el-table-column>

      <el-table-column label="操作" align="center" width="209" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button type="primary" size="mini" @click="editPro(scope.row.id)">
            编辑
          </el-button>

          <el-button size="mini" type="danger" @click="delPro(scope.row.id)">
            删除
          </el-button>
        </template>
      </el-table-column>

    </el-table>
  </div>
</template>

<script>
  import { getList } from '@/api/table'

  export default {

    data() {
      return {
        list: [{
          "id": 1,
          "title": "Vue.js前端框架介绍",
          //"content": "<p>Vue.js是一套构建用户界面的渐进式框架。与其他重量级框架不同的是，Vue 采用自底向上增量开发的设计。Vue 的核心库只关注视图层，并且非常容易学习，非常容易与其它库或已有项目整合。</p>",
          "created": "2020-04-16 21:16:30",
          "thumbnail": "upload/placeholder.png",
          "hits": 1,
          "comments": 2,
        },
          {
            "id": 2,
            "title": "Vue.js前端框架介绍",
            //"content": "<p>Vue.js是一套构建用户界面的渐进式框架。与其他重量级框架不同的是，Vue 采用自底向上增量开发的设计。Vue 的核心库只关注视图层，并且非常容易学习，非常容易与其它库或已有项目整合。</p>",
            "created": "2020-04-16 21:16:30",
            "thumbnail": "upload/thumbnail.jpg",
            "hits": 1,
            "comments": 2,
          },
        ]
      }
    },
    created() {
      this.fetchData()
    },
    methods: {
      editPro(id){
        this.$router.push("/editProduct/index/"+id)
      },
      delPro(id){
        var vm = this;
        this.axios({
          method: 'DELETE',
          url: 'http://localhost:8080/blog/article/'+id,
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

      fetchData() {
        var vm = this;
        this.axios({
          method: 'GET',
          url: 'http://localhost:8080/blog/articles',
        }). then(function(resp) {
          vm.list = resp.data
        });
      }
    }
  }
</script>
