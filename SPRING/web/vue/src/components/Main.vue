<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <form action="">
      <input type="text" name="id" placeholder="아이디를 입력하세요"><br>
      <input type="text" name="pwd" placeholder="비밀번호를 입력하세요">
    </form>
  </div>
</template>

<script>
export default {
  name: 'Main',
  props: {
    msg: String
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
