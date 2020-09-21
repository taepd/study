# dataframeGraph02.py
import pandas as pd
import matplotlib.pyplot as plt
filename = '../첨부(2주차)/ex802.csv'

plt.rc('font', family='Malgun Gothic')

# index_col : 해당 컬럼을 인덱스로 활용
myframe = pd.read_csv(filename, index_col='type', encoding='utf-8')
print(myframe)
myframe.index.name = '자동차 유형'
myframe.columns.name = '도시(city)'

myframe.plot(kind='bar', rot=0, title='차량 유형별 지역 등록 대수', legend=True)
plt.legend(loc='best')
# plt.legend(loc=4)


filename = 'graph02.png'
plt.savefig(filename)
print(filename + ' 파일 저장')

# 전치 활용: T
myframeT = myframe.T
print(myframeT)

myframeT.plot(kind='bar', rot=0, title='지역별 차량 유형 등록 대수', legend=True)
filename = 'graph03.png'
plt.savefig(filename)
print(filename + ' 파일 저장')


# stacked=True
myframeT.plot(kind='bar', rot=0, stacked=True, title='지역별 차량 유형 등록 대수', legend=True)
filename = 'graph04.png'
plt.savefig(filename)
print(filename + ' 파일 저장')

print('finished')
