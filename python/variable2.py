#  변수 다뤄 보기
# 변수 a에 값 10을 대입/할당 하여라
# 변수 정의 시 타입 명시 안해도 타입 설정됨
a = 10
b = 20
print(a)
print(b)
print(a+3)
print(b)

# 소괄호 또는 콤마로 연결하면 튜플
a, b = ('가가', '나나')
print(a)
print(b)

# 대괄호가 있으면 리스트
[c, d] = ('다다', '라라')
print(c)
print(d)

e = f = '홍길동'
print(e)
print(f)

# swap 기능: 2개의 변수의 값을 서로 맞바꾸는 기법
a, b = b, a
print(a)
print(b)

# 변수 a를 메모리에서 제거
del(a)

print(a)
