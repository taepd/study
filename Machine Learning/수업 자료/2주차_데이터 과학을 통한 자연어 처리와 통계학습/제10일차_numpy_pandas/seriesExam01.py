# seriesExam01.py
import matplotlib.pyplot as plt
from pandas import Series

plt.rc('font', family='Malgun Gothic')

myindex = ['강감찬', '홍길동', '이순신', '최영']
members = Series(data=[20, 60, 80, 40], index=myindex)
print(members)

# kind는 line, bar, barh, pie, kde(커널 밀도 추정)
# rot : 눈금 rotation
# ylim : y축 상하한값
# color : 색상 지정
# legend : 범례
# label : 범례에 들어갈 문자열

# use_index
members.plot(kind='bar', rot=30, ylim=[0, members.max() + 5],
             color=['r', 'g', 'b', 'y'], use_index=True)

plt.title('학생들 국어 시험')
plt.xlabel('학생 이름')
plt.ylabel('점수')
# 격자 추가
# plt.grid(True)

# series 요소 각각에 연산됨
ratio = 100 * members / members.sum()
print(type(ratio))
print(ratio)

for idx in range(members.size):
    value = str(members[idx]) + '건'  # 60건
    ratioval = '%.1f%%' % (ratio[idx])  # 20.0%
    plt.text(x=idx, y=members[idx] + 1, s=value, horizontalalignment='center')
    plt.text(x=idx, y=members[idx]/2, s=ratioval, horizontalalignment='center')

meanval = members.mean()

average = f'평균 : {int(meanval)}건'
plt.axhline(y=meanval, color='r', linewidth=1, linestyle='dashed')
plt.text(x=0, y=meanval + 1, s=average, horizontalalignment='center')

filename = 'graph01.png'
plt.savefig(filename)
print(filename + ' 파일 저장됨')

print('finished')
