# 리스트의 모든 요소들의 합을 구해주는 함수 arrsum
def arrsum(data):
    total = 0
    for item in data:
        total += item
    return total

mylist = [10, 20, 30]
result = arrsum(mylist)
print(result)

mydata = (1, 2, 3)
result = arrsum(mydata)
print(result)

myset = set((11, 22, 33))
result = arrsum(myset)
print(result)