<template>
  <div >
    <h2 align="center">{{notices.title}}</h2>
    <div v-html="notices.content"></div>
  </div>
</template>
<script>

  export default {
    data () {
      return {
        notices: null,
      }
    },

    created(){
      this.fatchDataById();
    },
    methods: {
      fatchDataById(){
        var id = this.$route.params.id;
        var vm = this;
        this.axios({
          method: 'GET',
          url: 'http://localhost:8080/blog/notice/'+id
        }).then(function(resp){
          vm.notices = resp.data
        })
      },
    }
  }
</script>
<style scoped>

</style>
