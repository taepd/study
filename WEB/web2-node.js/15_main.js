var http = require('http');
var fs = require('fs');
var url = require('url'); //require는 요구한다 안의 http,fs,url은 모듈
var app = http.createServer(function(request,response){
    var _url = request.url;
    var queryData = url.parse(_url, true).query;
    console.log(queryData.id);
    if(_url == '/'){
      _url = '/index.html';
    }
    if(_url == '/favicon.ico'){
      response.writeHead(404);
      response.end();
    return;
    }
    response.writeHead(200);
    response.end(queryDate.id);

});
app.listen(3000);
