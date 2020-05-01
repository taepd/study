var f = function(){          // js에선 함수는 구문이면서 그것 자체가 값이 될 수 있다. 즉, 변수로 지정할 수 있음
 console.log(1+1);
 console.log(1+2);
}
var a = [f];    //배열의 원소로서 함수가 존재할 수 있음
a[0]();

var o = {
 func:f    //property : key와 value로 구성된 것
}
o.func();
