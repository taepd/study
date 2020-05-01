var http = require('http');
var fs = require('fs');
var url = require('url'); // 모듈 url 가리킴
var qs = require('querystring');

function templateHTML(title, list, body, control){
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
      ${control}
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

        fs.readdir('./data', function(err, filelist){
          var title = 'Welcome';
          var description = 'Hellow, Node.js';
          var list = templateList(filelist);
          var template = templateHTML(title, list,
             `<h2>${title}</h2>${description}`,
             `<a href="/create">create</a>`);
          response.writeHead(200);  //서버에 파일 전송 성공시 '200' , 실패시 '404'
          response.end(template);   //response.end() <사용자에게 전송할 데이터 함수
        });
      } else {
        fs.readdir('./data', function(err, filelist){
          fs.readFile(`data/${queryData.id}`, 'utf8', function(err, description){ //`data/${queryData.id}` 여긴 ``로 감싸야 한다. ${}는 변수이기 때문에 ''로 감쌀 경우 문자열로 인식되기 때문에 'data/'+${queryData.id}로 표현해야 함
            var title = queryData.id;
            var list = templateList(filelist);
            var template = templateHTML(title, list,
              `<h2>${title}</h2>${description}`,
              `<a href="/create">create</a>
               <a href="/update?id=${title}">update</a>
               <form action="delete_process" method="post">
                <input type="hidden" name="id" value="${title}">
                <input type="submit" value="delete">
               </form>`); // 삭제는 get방식이면 안된다(링크방식 포함) 따라서 form의 post 메소드 이용
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
          <form action="/create_process"
          method="post">
          <p><input type="text" name="title" placeholder="title"></p>
          <p>
            <textarea name="description" placeholder="description"></textarea>
          </p>
          <p>
            <input type="submit">
          </p>
          </form>
          `,''); // create 페이지에서 update 링크는 필요없으니 공백만 추가
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
        })
      });
    } else if(pathname === '/update'){
      fs.readdir('./data', function(err, filelist){
        fs.readFile(`data/${queryData.id}`, 'utf8', function(err, description){ //`data/${queryData.id}` 여긴 ``로 감싸야 한다. ${}는 변수이기 때문에 ''로 감쌀 경우 문자열로 인식되기 때문에 'data/'+${queryData.id}로 표현해야 함
          var title = queryData.id;
          var list = templateList(filelist);
          var template = templateHTML(title, list,
            `
              <form action="/update_process" method="post">
              <input type="hidden" name="id" value="${title}"
              <p><input type="text" name="title" placeholder="title" value="${title}"></p>
              <p>
                <textarea name="description" placeholder="description">${description}</textarea>
              </p>
              <p>
                <input type="submit">
              </p>
              </form>
              `,
            `<a href="/create">create</a> <a href="/update?id=${title}">update</a>`);
            //같은 ${title}값을 사용하지만, input 2개의 라인에 하나는 id 하나는 title에 값을 전달함으로써, id는 원래 기존값을 부여받고 title 값은 수정 됨으로써 데이터의 흐름에 따라 작동
          response.writeHead(200);  //서버에 파일 전송 성공시 '200' , 실패시 '404'
          response.end(template);   //response.end() <사용자에게 전송할 데이터 함수
        });
      });
    } else if(pathname === '/update_process'){
      var body = '';
      request.on('data', function(data){
        body = body + data;            //콜백이 실행될 때마다 body에 data 추가
      });
      request.on('end', function(){
        var post = qs.parse(body);
        var id = post.id;
        var title = post.title;
        var description = post.description
        fs.rename(`data/${id}`, `data/${title}`, function(error){
          fs.writeFile(`data/${title}`, description, 'utf8',
          function(err){
            response.writeHead(302, {Location: `/?id=${title}`});  //302는 리다이렉션으로 보내는 것
            response.end();
          })
        })
      });
    } else if(pathname === '/delete_process'){
      var body = '';
      request.on('data', function(data){
        body = body + data;            //콜백이 실행될 때마다 body에 data 추가
      });
      request.on('end', function(){
        var post = qs.parse(body);
        var id = post.id;
        fs.unlink(`data/${id}`, function(error){
          response.writeHead(302, {Location: `/`});  //302는 리다이렉션으로 보내는 것
          response.end();
        })
      });
    }
      else {
      response.writeHead(404);
      response.end('not found');
    }

});
app.listen(3000);
