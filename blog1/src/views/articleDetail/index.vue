<template>
  <div >
    <h2 align="center">{{articles.title}}</h2>
    <div v-html="articles.content"></div>
  </div>
</template>
<script>

  export default {
    data () {
      return {
        articles: null,
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
          url: 'http://localhost:8080/blog/article/'+id
        }).then(function(resp){
          vm.articles = resp.data
        })
      },
    }
  }
</script>
<style scoped>

</style>
