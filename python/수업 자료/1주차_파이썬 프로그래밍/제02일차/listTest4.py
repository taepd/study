
# list 자료 구조
# 순서를 가지고 있는 데이터 유형
# 인덱싱, 슬라이싱이 가능하고, 대괄호 사용
# 모든 유형의 데이터 사용이 가능
# 관련 함수 : list()
# 조작을 위한 함수들 : append(), len(), insert(),
#                   reverse(), remove(), clear(), extend()
mylist = ['강감찬', '김유신']
print(mylist)

mylist.append('이순신')
mylist.append('안중근')
print(mylist)
print(len(mylist))

# 마지막 요소 구하기
print(mylist[len(mylist)-1])

mylist.insert(2, '이성계')
print(mylist)

# mylist.clear()

mylist.sort()
print(mylist)

mylist.reverse()
print(mylist)

# 읽기
print(mylist[2])
# 쓰기
mylist[2] = '이완용'
print(mylist)

mylist.remove('김유신')

newlist = ['윤봉길', '신사임당', '강감찬']
mylist.extend(newlist)

print(mylist.count('강감찬'))
print(mylist)

# '이완용'은 몇번째 있나요?(힌트: index 함수 사용)
print(mylist.index('이완용'))
print(mylist.index('강감찬', 4))

# 슬라이싱 테스트
print(mylist[4:6])
print(mylist[1::2])
print(mylist[::2])

anydata = [10, '가가', 12.34, [10,20,30]]
print(anydata)
