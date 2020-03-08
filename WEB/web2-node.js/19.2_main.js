var http = require('http');
var fs = require('fs');
var url = require('url'); // 모듈 url 가리킴

var app = http.createServer(function(request,response){
    var _url = request.url;
    var queryData = url.parse(_url, true).query;  // parse: 검색하다
    var pathname = url.parse(_url, true).pathname;

    if(pathname === '/'){
      if(queryData.id === undefined){  //홈은 id값이 없으므로
        var title = 'Welcome';
        var description = 'Hellow, Node.js';
          var template = `
          <!doctype html>
          <html>
          <head>
            <title>WEB1 - ${title}</title>
            <meta charset="utf-8">
          </head>
          <body>
            <h1><a href="/">WEB</a></h1>
            <ul>
              <li><a href="/?id=HTML">HTML</a></li>
              <li><a href="/?id=CSS">CSS</a></li>
              <li><a href="/?id=JavaScript">JavaScript</a></li>
            </ul>
            <h2>${title}</h2>
            <p>${description}</p>
          </body>
          </html>
        `;
        response.writeHead(200);
        response.end(template);   //response.end() <사용자에게 전송할 데이터 함수

      } else {
        fs.readFile(`data/${queryData.id}`, 'utf8', function(err, description){ //`data/${queryData.id}` 여긴 ``로 감싸야 한다. ${}는 변수이기 때문에 ''로 감쌀 경우 문자열로 인식되기 때문에 'data/'+${queryData.id}로 표현해야 함
        var title = queryData.id;
        var template = `
        <!doctype html>
        <html>
        <head>
          <title>WEB1 - ${title}</title>
          <meta charset="utf-8">
        </head>
        <body>
          <h1><a href="/">WEB</a></h1>
          <ul>
            <li><a href="/?id=HTML">HTML</a></li>
            <li><a href="/?id=CSS">CSS</a></li>
            <li><a href="/?id=JavaScript">JavaScript</a></li>
          </ul>
          <h2>${title}</h2>
          <p>${description}</p>
        </body>
        </html>
      `;
      response.writeHead(200);
      response.end(template);   //response.end() <사용자에게 전송할 데이터 함수
      })
    }

    } else {
      response.writeHead(404);
      response.end('not found');
    }



});
app.listen(3000);
