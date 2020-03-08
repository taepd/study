var http = require('http');
var fs = require('fs');
var url = require('url'); // 모듈 url 가리킴

var app = http.createServer(function(request,response){
    var _url = request.url;
    var queryData = url.parse(_url, true).query;  // parse: 검색하다
    var title = queryData.id;
    if(_url == '/'){                // '/' <'루트로 갔을 때'를 의미
      title = 'Welcome';
    }
    if(_url == '/favicon.ico'){
      return response.writeHead(404);
    }
    response.writeHead(200);
    fs.readFile(`data/${queryData.id}`, 'utf8', function(err, description){ //`data/${queryData.id}` 여긴 ``로 감싸야 한다. ${}는 변수이기 때문에 ''로 감쌀 경우 문자열로 인식되기 때문에 'data/'+${queryData.id}로 표현해야 함
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
    response.end(template);   //response.end() <사용자에게 전송할 데이터 함수
    })
});
app.listen(3000);
