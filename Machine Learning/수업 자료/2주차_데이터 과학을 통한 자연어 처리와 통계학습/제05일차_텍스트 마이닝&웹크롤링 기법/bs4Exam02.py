# bs4Exam02.py
# 카페 400번 문서에서
# 첨부(2주차).zip파일, 파이썬 Konlpy 설정하기.txt 파일 다운로드
# 참조파일(fruits.html)을 이용하여 필요한 정보를 추출해 보도록 합니다
# BeautifulSoup 패키지 : html 문서에서 데이터를 추출하고자 할 때 사용하는 패키지

from bs4 import BeautifulSoup
# open 함수 : 운영체제 내의 파일을 열고자 할 때 사용하는 내장 함수
# 파일 이름 : 'fruits.html', 'r'은 read(읽기)
html = open('../첨부(2주차)/fruits.html', 'r', encoding='utf-8') # fruits.html

# 파서: html 문서가 제대로 만들어진 것인지 검증하는 객체
# soup = BeautifulSoup(해당문서, '파싱문자열')
soup = BeautifulSoup(html, 'html.parser')
print(type(soup))

# print(soup.prettify()) # 문서 구조 잘 보이게 출력

body = soup.select_one('body')
ptag = body.find('p')

# 읽기
print(ptag)
print(ptag['class'])
print(ptag['align'])

# 쓰기
# print(ptag['id']) # 'id'가 없는데 읽어서 keyError 발생
ptag['id'] = 'apple'
print(ptag['id'])
print(ptag)
print('-'*30)

body_tag = soup.find('body')
print(body_tag)
print('-'*30)

idx = 0
# white character : 눈에 보이지 않는 글자들
for child in body_tag.children:
    idx += 1
    print(str(idx) + '번째 요소 :', child)
    print('#'*20)
print('-'*30)

mydiv = soup.find('div')
print(mydiv)
print('나의 부모는')
print(mydiv.parent)
print('-'*30)

# attrs 매개변수는 속성(attribute)을 이용하여 찾고자 할 때 사용
mytag = soup.find('p', attrs={'class': 'hard'})
print(mytag)
print('-'*30)

print(mytag.find_parent())
print('-'*30)

print('mytag 태그 상위 부모 태그들의 이름')
parents = mytag.find_parents()
for p in parents:
    print(p.name) # .name으로 태그 이름만 출력




