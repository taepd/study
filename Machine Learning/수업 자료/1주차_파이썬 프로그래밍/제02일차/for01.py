# for01.py
# range() 함수
# range(start, end, step)
for idx in range(1, 11):
    print(idx)
print('-'*30)

for idx in range(11):
    print(idx)
print('-'*30)

for idx in range(1, 10, 2):
    print(idx)
print('-'*30)

for idx in range(10, 1, -1):
    print(idx)
print('-'*30)

# 1부터 10까지의 총합 구하기
total = 0

for i in range(1, 11):
    total += i

print('총합 : %d' % (total))

# 1 + 4 + 7 + ... + 100 = 1717
total = 0

for i in range(1, 101, 3):
    total += i

print('총합 : %d' % (total))

# 97 + 92 + 87 + .. + 2 = 990
total = 0

for i in range(97, 1, -5):
    total += i

print('총합 : %d' % (total))

# 1*1 + 6*6 + ... + 96*96 = 63670
total = 0

for i in range(1, 97, 5):
    total += pow(i,2)
    # total += i ** 2
    # total += i*i

print('총합 : %d' % (total))

print(abs(-15)) # 절대값

# 사용자가 숫자를 하나 입력받고, 1부터 해당 수까지의 총합 구하기
# 숫자 입력 : 5
# 출력 결과 : 1부터 5까지의 합은 15입니다.
total = 0
su = abs(int(input('숫자 입력 : ')))

for i in range(1, su+1):
    total += i

print('1부터 %d까지의 합은 %d입니다.' % (su, total))



