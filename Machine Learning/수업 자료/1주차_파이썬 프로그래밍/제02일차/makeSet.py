# makeSet.py
mylist = [1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5]
print(len(mylist))

# 집합 : 중복을 허락하지 않는 자료 구조
# 관련 함수 : set()
# 특징 : 합집합, 교집합, 차집합 등의 함수를 제공
# 함수 : add, update, remove, intersection, union, difference

myset = set(mylist)
print(myset)

newlist = list(myset)
print(newlist)

set1 = set([1, 2, 3])
print(set1)
print('-'*30)

set1.add(4)
print(set1)
print('-'*30)

# update는 iterable에 대해서 가능
set1.update([5, 6, 7])
print(set1)
print('-'*30)

set1.remove(4)
print(set1)
print('-'*30)

set3 = set([1, 2, 3, 4])
set4 = set([3, 4, 5, 6])

set5 = set3.intersection(set4)
print(set5)
print('-'*30)

set6 = set3.union(set4)
print(set6)
print('-'*30)

set7 = set3.difference(set4)
print(set7)
print('-'*30)

# 차집합은 교환 법칙이 성립하지 않는다.
set8 = set4.difference(set3)
print(set8)
print('-'*30)

# 다음은 어떤 자료 구조로 표현하면 좋을까요?
# 1) 회원 가입 정보 > 사전
# 2) 로또 번호 생성기 > set
# 3) 게시물의 제목 정보 > 리스트






