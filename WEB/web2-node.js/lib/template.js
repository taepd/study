module.exports = {
  HTML: function(title, list, body, control){
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
  }, list: function(filelist){
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
}
