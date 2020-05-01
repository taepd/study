var fs = require('fs');

/*
//readFileSync
console.log('A');
var result = fs.readFileSync('syntax/sample.txt', 'utf8');
console.log(result);
console.log('C');   //ABC로 출력. 동기적 방식
*/


console.log('A');
fs.readFile('syntax/sample.txt', 'utf8', function(err, result){
  console.log(result);
});
console.log('C');   // 이 때는 ACB순으로 출력된다. 비동기적 방식

/* readFile은 인자로(경로,옵션(선택적),콜백)을 갖는다.
이 중 콜백은 function이고 매개변수는 첫 매개변수로 error를 두 번째로 파일의 내용을 인자로 주기로 약속되어 있음
*/
