/*
var v1 = 'v1';
// 10000 codes.. 중에
v1 = 'egoing';  //요런게 나오면 버그가 발생
var v2 = 'v2';
*/

//이를 해결해 주는 것이 객체

var o = {
  v1:'v1',
  v2:'v2',
  f1: function(){
    console.log(this.v1)
  },
  f2: function (){
    console.log(this.v2) //this를 씀으로써 변수명이 변경되어도 메소드(함수)가 잘 작동함
  }
}

o.f1();
o.f2();
