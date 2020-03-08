var Links = {
  setColor:function(color){
    //var alist = document.querySelectorAll('a');
    //var i = 0;
    //while(i < alist.length){
    //  alist[i].style.color = color;
    //  i = i + 1;
    //  }
    $('a').css('color',color); //jquery적용 놀랍다 ㅠ
  }
}
var Body = {
  setColor:function(color){
    document.querySelector('body').style.color= color;
  }, // 객체 안의 매소드는 무순서 배열이므로 콤마로 구별
  setBackgroundColor:function(color){
    document.querySelector('body').style.backgroundColor= color;
  }
}
function nightDayHandler(self){
    var target= document.querySelector('body');
if(self.value === 'night'){
  Body.setBackgroundColor('black');
  Body.setColor('white');
  self.value ='day'
  Links.setColor('powderblue');
  }
else {
  Body.setBackgroundColor('white');
  Body.setColor('black');
  self.value ='night'
  Links.setColor('blue');
  }
}
