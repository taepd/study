/*
function a(){
  console.log('A');
}
*/

var a = function(){   //function(): 익명함수. 익명함수는 변수를 지정해줘서 그 값으로 호출 할 수 있음
  console.log('A');
}

function slowfunc(callback){
  callback();
}

slowfunc(a);    // 인자 a가 함수이기 때문에 콜백 함수에 a가 인자가 되어 함수 a가 실행된다.
