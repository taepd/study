# abs01.py
# 어떠한 숫자에 대하여 절대값으로 만들어 주는 함수 만들기
def absolute(n):
    if n < 0:
        n = -n
    return n

su = -5
result = absolute(su)
print('결과01: {}'.format(result))

mylist = [2, -4, -7]

res = [absolute(item) for item in mylist]
print(res)

print('finished')

