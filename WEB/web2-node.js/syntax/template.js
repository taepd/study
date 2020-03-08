
var name = 'taepd';
var letter = 'fajdks '+name+'\nfdkajs adskljv '+name+' fjdaksjf';  // \n: 줄바꿈 명령어


// template literals: ``(backtic)으로 감싸고 변수를 ${variable}로 표현하면 그 사이에서 띄어쓰기 등이 자유롭게 표현가능
var letter = `fajdks ${name}


fdkajs adskljv ${name} ${1+1} fjdaksjf`;

console.log(letter);
