var http = require('http');
var fs = require('fs');
var url = require('url'); // 모듈 url 가리킴
var qs = require('querystring');

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
      <a href="/create">create</a>
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
// list를 배열의 형태로 호출해서 반복문을 이용해 자동 출력되게 함
var app = http.createServer(function(request,response){
    var _url = request.url; // url을 호출 ex) id=html/
    var queryData = url.parse(_url, true).query;  // parse: 검색하다
    var pathname = url.parse(_url, true).pathname; // pathname 호출
    if(pathname === '/'){
      if(queryData.id === undefined){ //홈은 id값이 없으므로

        fs.readdir('./data',  function(err, filelist){
          var title = 'Welcome';
          var description = 'Hellow, Node.js';
          var list = templateList(filelist);
          var template = templateHTML(title, list, `<h2>${title}</h2>${description}`);
          response.writeHead(200);  //서버에 파일 전송 성공시 '200' , 실패시 '404'
          response.end(template);   //response.end() <사용자에게 전송할 데이터 함수
        });
      } else {
        fs.readdir('./data', function(err, filelist){
          fs.readFile(`data/${queryData.id}`, 'utf8', function(err, description){ //`data/${queryData.id}` 여긴 ``로 감싸야 한다. ${}는 변수이기 때문에 ''로 감쌀 경우 문자열로 인식되기 때문에 'data/'+${queryData.id}로 표현해야 함
            var title = queryData.id;
            var list = templateList(filelist);
            var template = templateHTML(title, list, `<h2>${title}</h2>${description}`);
            response.writeHead(200);  //서버에 파일 전송 성공시 '200' , 실패시 '404'
            response.end(template);   //response.end() <사용자에게 전송할 데이터 함수
          });
        });
      }
    } else if(pathname === '/create'){
      fs.readdir('./data', function(err, filelist){
        var title = 'WEB - create';
        var list = templateList(filelist);
        var template = templateHTML(title, list, `
          <form action="http://localhost:3000/create_process"
          method="post">
          <p><input type="text" name="title" placeholder="title"></p>
          <p>
            <textarea name="description" placeholder="description"></textarea>
          </p>
          <p>
            <input type="submit">
          </p>
          </form>
          `);
        response.writeHead(200); //서버에 파일 전송 성공시 '200' , 실패시 '404'
        response.end(template);   //response.end() <사용자에게 전송할 데이터 함수
      });
    } else if(pathname === '/create_process'){
      var body = '';
      request.on('data', function(data){
        body = body + data;            //콜백이 실행될 때마다 body에 data 추가
      });
      request.on('end', function(){
        var post = qs.parse(body);
        var title = post.title;
        var description = post.description
        fs.writeFile(`data/${title}`, description, 'utf8',
        function(err){
          response.writeHead(302, {Location: `/?id=${title}`});  //302는 리다이렉션으로 보내는 것
          response.end();
        })  // 한글 입력하면 오류가 나는 문제 발생. 파일생성은 문제 없으나 페이지는 오류 일으킴
      });

    } else {
      response.writeHead(404);
      response.end('not found');
    }

});
app.listen(3000);
