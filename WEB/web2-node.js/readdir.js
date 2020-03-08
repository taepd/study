var testFolder = './data';
var fs = require('fs');

fs.readdir(testFolder, function(error, filelist){
  console.log(filelist);
})

// 파일리스트를 배열의 형태로 리턴해주는 코드
