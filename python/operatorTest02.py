
x = 5

# 복합 대입 연산자
x += 3
print('x :', x)
print('-'*30)

x *= 4
print('x :', x)
print('-'*30)

x %= 5
print('x :', x)
print('-'*30)

x -= 1
print('x :', x)
print('-'*30)

x += 7
print('x :', x)
print('-'*30)

# ; 한 줄에 여러 개의 서로 다른 코딩을 하고자 할 때 사용
# 1부터 10까지의 합은?
total = 0
i = 1
while i<=10:
    total += i
    i+= 1
print(total)