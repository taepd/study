/*
var M = {
  v:'v',
  f:function(){
    console.log(this.v);
  }
}
*/

var part = require('./mpart.js');  // 호출하면 모듈로 지정한 m의 객체가 호출됨
console.log(part);
//M.f();
part.f(); // 동일한 결과가 출력된다.
