var http = require('http');
var fs = require('fs');
var url = require('url'); // 모듈 url 가리킴

function templateHTML(title, list, body){
  return `
    <!doctype html>
    <html>
    <head>
      <title>WEB1 - ${title}</title>
      <meta charset="utf-8">
    </head>
    <body>
      <h1><a href="/">WEB</a></h1>
      ${list}
      ${body}
    </body>
    </html>
  `;
}
function templateList(filelist){
  var list = '<ul>';
  var i = 0;
  while (i < filelist.length) {
    list = list +`<li><a href="/?id=${filelist[i]}">${filelist[i]}</a></li>`;
    i = i + 1;
  }
  list = list+'</ul>';
  return list;
}

var app = http.createServer(function(request,response){
    var _url = request.url;
    var queryData = url.parse(_url, true).query;  // parse: 검색하다
    var pathname = url.parse(_url, true).pathname;
    if(pathname === '/'){
      if(queryData.id === undefined){

        fs.readdir('./data', function(err, filelist){
          var title = 'Welcome';
          var description = 'Hellow, Node.js';
          var list = templateList(filelist);
          var template = templateHTML(title, list, `<h2>${title}</h2>${description}`);
          response.writeHead(200);
          response.end(template);   //response.end() <사용자에게 전송할 데이터 함수
        })
      } else {
        fs.readdir('./data', function(err, filelist){
          fs.readFile(`data/${queryData.id}`, 'utf8', function(err, description){ //`data/${queryData.id}` 여긴 ``로 감싸야 한다. ${}는 변수이기 때문에 ''로 감쌀 경우 문자열로 인식되기 때문에 'data/'+${queryData.id}로 표현해야 함
            var title = queryData.id;
            var list = templateList(filelist);
            var template = templateHTML(title, list, `<h2>${title}</h2>${description}`);
            response.writeHead(200);
            response.end(template);   //response.end() <사용자에게 전송할 데이터 함수
          });
        });
      }
    } else {
      response.writeHead(404);
      response.end('not found');
    }

});
app.listen(3000);
