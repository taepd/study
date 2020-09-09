
# 사전(dict) : 키와 값으로 구성되어 있는 데이터구조
# 중괄호 사용
# 키와 값은 콜론으로 구분하고, 항목들은 콤마로 구분
# 예시 :  {키1:값1, 키2:값2, 키3:값3, ...}
# 순서를 따지지 않는 자료구조
# 관련 함수 : dict()
# 함수 : get(키, 기본값), clear(), del()

mydict = {'name': '홍길동', 'phone': '01011112222', 'birth': '12/25'}

print(mydict)

# 읽기 : 사전 이름에 '키'를 넣어주면 '값'을 구할 수 있음
print(mydict['birth'])

# 쓰기 : 존재하는 키는 수정, 존재하지 않는 키는 입력됨
mydict['phone'] = '01033335555'

mydict['address'] = '마포구 공덕동'
# 존재하지 않는 키는 KeyError 오류 발생
# print(mydict['age'])

# get('찾을키', 기본값) 찾는 키가 없을 때 기본값 리턴
print(mydict.get('age', 10))

# 삭제
del mydict['phone']

print(mydict)

if 'address' in mydict:
    print('주소 있음')
else:
    print('주소 없음')

print(mydict)

mydict.clear()

print(mydict)

mydict['hong'] = ['홍길동', 23]
mydict['park'] = ['박영희', 35]

print(mydict)








