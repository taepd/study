# dataframeReaderWriter01.py
import numpy as np
from pandas import DataFrame

mylist = [10 * onedata for onedata in range(1, 26)]

print(mylist)
print('-' * 30)

myindex = ['이순신', '김유신', '강감찬', '광해군', '연산군']
mycolumns = ['서울', '부산', '광주', '목포', '경주']
myframe = DataFrame(np.reshape(mylist, (5, 5)), index=myindex, columns=mycolumns)

print(type(myframe))
print(myframe)
print('-' * 30)

# 행 데이터 가져오고 싶을 때
# iloc : i는 정수(행 인덱스), loc는 location
# 대괄호 하나는 Series
result = myframe.iloc[1]
print(type(result))
print(result)

print('-' * 30)

# 대괄호 둘은 DataFrame, 보통 한 행을 출력하면 Series, 두 행 이상이면 DataFrame을 사용
result = myframe.iloc[[1, 3]]
print(result)
print('-' * 30)

# 숫자 색인을 이용하여 짝수행만 출력
result = myframe.iloc[0::2]
print(result)
print('-' * 30)

# loc
result = myframe.loc['이순신']
print(type(result))
print(result)
print('-' * 30)

# 이순신과 강감찬 출력
result = myframe.loc[['이순신', '강감찬']]
print(result)
print('-' * 30)

result = myframe.loc[['강감찬'], ['광주']]
print(result)
print('-' * 30)

# 연산군과 광해군의 광주/목포 출력
result = myframe.loc[['연산군', '광해군'], ['광주', '목포']]
print(result)
print('-' * 30)

# 슬라이싱을 이용할 때는 대괄호 안씀
result = myframe.loc['김유신': '광해군', '광주': '목포']
print(result)
print('-' * 30)

# 불리언을 활용한 출력
result = myframe.loc[[False, True, True, False, True]]
print(result)
print('-' * 30)

# 연산 결과 불리언 값이 리턴
print(myframe['부산'] <= 100)
print('-' * 30)

# 따라서 loc안에 넣으면 위 불리언을 활용한 출력을 사용할 수 있음
result = myframe.loc[myframe['부산'] <= 100]
print(result)
print('-' * 30)

# 목포의 값이 140인 항목 조회
result = myframe.loc[myframe['목포'] == 140]
print(result)
print('-' * 30)

# all()과 any()함수를 사용하는 예시
# 부산이 70이상이고, 목포가 140인 항목들
# result = myframe.loc[myframe['부산'] >= 70  or myframe['목포'] >= 140] # 이렇게 되지 않는다
cond1 = myframe['부산'] >= 70
cond2 = myframe['목포'] >= 140

df = DataFrame([cond1, cond2])
print(df)
print('-' * 30)

print(df.all())
print('-' * 30)

print(df.any())
print('-' * 30)

result = myframe.loc[df.all()]
print(result)
print('-' * 30)

result = myframe.loc[df.any()]
print(result)
print('-' * 30)

print(type(myframe))
print(myframe)
print('-' * 30)

# lambda 입력 매개변수 : 하고자 하는 일
aa = lambda x: x + 3

print(aa(10))

result = myframe.loc[lambda df: df['광주'] >= 130]
print(result)
print('-' * 30)

myframe.loc[['이순신', '강감찬'], ['부산']] = 30
print(myframe)
print('-' * 30)

# 김유신부터 광해군까지, 경주의 실적을 80으로 변경하기
myframe.loc['김유신':'광해군', ['경주']] = 80
print(myframe)
print('-' * 30)

# 일괄 변경
myframe.loc[['연산군'], :] = 55
print(myframe)
print('-' * 30)

myframe.loc[:, ['광주']] = 60
print(myframe)
print('-' * 30)

print('finished')
