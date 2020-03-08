var M = {
  v:'v',
  f:function(){
    console.log(this.v);
  }
}

module.exports = M;  // 모듈에 있는 기능 중 M을 그 바깥에서 사용하도록 하겠다는 의미
