var members = ['피카츄','파이리','꼬부기'];
console.log(members[1]);   // 배열은 대괄호. 숫자 인덱싱으로 호출

var i = 0;
while (i<members.length) {
  console.log(members[i]);
  i = i + 1;
}                          // 배열은 while 문을 이용해서 전체 호출가능

var roles = {'번개':'피카츄',   // 번개는 key, 피카츄는 value
              '불':'파이리',
            '물':'꼬부기'
          };                // 객체는 중괄호. 이름으로 호출
          console.log(roles.번개);
          console.log(roles['번개']); // 두 가지 방식 모두 가능

for(var n in roles){
  console.log('object=> ', n, 'value => ', roles[n]);
}                           // for문 이용해서 변수 설정해주고 호출 가능
