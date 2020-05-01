var fs = require('fs'); //fs모듈 쓰기 위해
fs.readFile('sample.txt', 'utf8', function(err, data){
  console.log(data);
});
