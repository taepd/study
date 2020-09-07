# defaultArgs01.py
def func01(a, b):
    return 2*a+b
print(func01(3, 5))

# TypeError: func01() missing 2 required positional arguments: 'a' and 'b'
# print(func01())

# TypeError: func01() takes 2 positional arguments but 3 were given
# print(func01(3, 5, 3))

# 옵션 매개변수
def func02(a=2, b=1): # 매개변수 기본값 설정
    return 2*a+b


# positional arguments(위치 기반 매개변수)
print(func02())
print('-'*30)

print(func02(3))
print('-'*30)

print(func02(3, 5))
print('-'*30)

# keyword arguments(키워드 기반 매개변수)
print(func02(b=2, a=1))
print('-'*30)

print(func02(2, b=1))
print('-'*30)

# SyntaxError: positional argument follows keyword argument
# print(func02(b=1, 2))









print('finished')