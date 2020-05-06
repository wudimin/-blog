<template>
  <div class="app-container">
    <el-row>
      <el-col :span="21">
        <div class="grid-content bg-purple">
          <el-input
            placeholder="公告标题"
            v-model="notices.title"
            clearable>
          </el-input>
        </div>
      </el-col>
      <el-col :span="3">
        <div class="grid-content" align="right">
          <el-button type="success" @click="onSubmit">发布公告</el-button>
        </div>
      </el-col>
    </el-row>

    <!--    富文本-->
    <div class="tinymce-editor">
      <editor v-model="notices.content"
              :init="init"
              :disabled="disabled"
              @onClick="onClick">
      </editor>
    </div>
  </div>
</template>
<script>
  //发送post请求携带数据时需要导入该模块
  import Qs from 'qs'
  import tinymce from 'tinymce/tinymce'
  import Editor from '@tinymce/tinymce-vue'
  import 'tinymce/themes/silver'
  // 编辑器插件plugins
  // 更多插件参考：https://www.tiny.cloud/docs/plugins/
  import 'tinymce/plugins/image'// 插入上传图片插件
  import 'tinymce/plugins/media'// 插入视频插件
  import 'tinymce/plugins/table'// 插入表格插件
  import 'tinymce/plugins/lists'// 列表插件
  import 'tinymce/plugins/wordcount'// 字数统计插件
  export default {
    components: {
      Editor
    },
    props: {
      value: {
        type: String,
        default: ''
      },
      // 基本路径，默认为空根目录，如果你的项目发布后的地址为目录形式，
      // 即abc.com/tinymce，baseUrl需要配置成tinymce，不然发布后资源会找不到
      baseUrl: {
        type: String,
        default: ''
      },
      disabled: {
        type: Boolean,
        default: false
      },
      plugins: {
        type: [String, Array],
        default: 'lists image media table wordcount'
      },
      toolbar: {
        type: [String, Array],
        default: 'undo redo |  formatselect | bold italic forecolor backcolor | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | lists image media table | removeformat'
      }
    },
    data () {
      return {
        notices: {
          title: "",
          content: "",
        },

        init: {
          language_url: `${this.baseUrl}/tinymce/langs/zh_CN.js`,
          language: 'zh_CN',
          skin_url: `${this.baseUrl}/tinymce/skins/ui/oxide`,
          content_css: `${this.baseUrl}/tinymce/skins/content/default/content.css`,
          // skin_url: `${this.baseUrl}/tinymce/skins/ui/oxide-dark`, // 暗色系
          // content_css: `${this.baseUrl}/tinymce/skins/content/dark/content.css`, // 暗色系
          height: 300,
          plugins: this.plugins,
          toolbar: this.toolbar,
          branding: false,
          menubar: false,
          // 此处为图片上传处理函数，这个直接用了base64的图片形式上传图片，
          // 如需ajax上传可参考https://www.tiny.cloud/docs/configure/file-image-upload/#images_upload_handler
          images_upload_handler: (blobInfo, success, failure) => {
            const img = 'data:image/jpeg;base64,' + blobInfo.base64()
            success(img)
          }
        },
      }
    },
    mounted () {
      tinymce.init({})
    },
    methods: {
      onSubmit(){
        var vm = this;
        this.axios({
          method: 'POST',
          url: 'http://localhost:8080/blog/notice',
          //解决POST请求无法携带数据的问题
          transformRequest: [function(data) {
            return Qs.stringify(data)
          }],
          data: vm.notices,
          dataType: "json",

        }).then(function(){
          //添加成功后
          vm.$router.push("/notice/index")
        })
      },

      // 添加相关的事件，可用的事件参照文档=> https://github.com/tinymce/tinymce-vue => All available events
      // 需要什么事件可以自己增加
      onClick (e) {
        this.$emit('onClick', e, tinymce)
      },
      // 可以添加一些自己的自定义事件，如清空内容
      clear () {
        this.myValue = ''
      }
    },
    watch: {
      value (newValue) {
        this.myValue = newValue
      },
      myValue (newValue) {
        this.$emit('input', newValue)
      }
    }
  }
</script>
<style scoped>
  .bg-purple {
    background: #d3dce6;
  }
  .bg-purple-light {
    background: #e5e9f2;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }
</style>
