su = 3
fruit = '사과'

# 인덱스 기반 매개변수 대입
print('positional argument')
str1 = '나는 {}를 {}개 먹었습니다.'
print(str1.format(fruit, su))

# 이 방법 추천
str2 = '나는 {0}를 {1}개 먹었습니다.'
print(str2.format(fruit, su))

str3 = '나는 {1}를 {0}개 먹었습니다'
print(str3.format(su, fruit))

print('keyword argument')
str4 = '나는 {abc}를 {defg}개 먹었습니다.'
print(str4.format(defg=su, abc=fruit))

# 2가지 혼합 방식
str5 = '나는 {abc}를 {}개 먹었습니다.'
print(str5.format(su, abc=fruit))

# # 이렇게 하면 안된다. positional argument가 앞에 오고 키워드 인자는 뒤에 와야 함
# str6 = '나는 {abc}를 {}개 먹었습니다.'
# print(str6.format(abc=fruit, su))

name = '김철수'
fruit = '사과'
su1 = 8

# 서식 지정자 %s(string), %d(decimal)
# %f(float): 기본 값으로 소수점 6자리까지 표시
# %c(문자 1개), %o(8진수), %x(16진수)
# %% : %문자를 표현할 때 사용
myformat = '%s가 %s를 %d개 먹었습니다.'
print(myformat % (name, fruit, su1))

su1 = 4
su2 = 9
# 4 곱하기 9는 36입니다.

myformat2 = '%d 곱하기 %d는 %d입니다.'
print(myformat2 % (su1, su2, su1*su2))

# pow(a, b) : a의 b 제곱
print(pow(5, 2))

# 2.0의 10.0승은 1024.0입니다.
su3 = 2.0
su4 = 10.0
myformat3 = '%f의 %f승은 %f입니다.'
print(myformat3 % (su3, su4, pow(su3,su4)))

rate = 0.4567
print('비율 :  %.3f%%' % (100*rate))


