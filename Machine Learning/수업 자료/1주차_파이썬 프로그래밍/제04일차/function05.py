# function05.py
# 함수의 마지막에는 return 구문이 들어갑니다
# 만약 명시하지 않으면 return None라는 구문이 숨어 있습니다.

# None : 리턴하지 않는, 의미가 없는
# void, vacant, empty, no response

def namePrint(name, age):
    print('{}님의 나이는 {}살입니다.'.format(name, age))

name = '제시카'
age = 20
result = namePrint(name, age)
print(result)

if result == None:
    print('데이터를 구하지 못했습니다.')
else:
    print('참 잘했어요')

print('-'*20)

def gugudan(su):
    rng = range(1, 10) # 1부터 9까지
    for i in rng:
        print('{} * {} = {}'.format(su, i, (su*i)))

dan = 3
gugudan(dan)
print('-'*20)

danList = [2, 4, 7]
for i in danList:
    gugudan(i)
    print()

print('-'*20)

# 2단이면 [2, 4, 6, .. , 18]로 출력되는 함수를 만들어 보세요
def Gugu(n):
    gugulist = [i*n for i in range(1, 10)]
    print(gugulist)

Gugu(2)
print('-'*20)

# 2단부터 4단까지 list로 출력 함수
def Gugu2(n, m):
    for x in range(n, m+1):
        gugulist = [i*x for i in range(1, 10)]
        print(gugulist)

Gugu2(2, 4)

print('finished')

