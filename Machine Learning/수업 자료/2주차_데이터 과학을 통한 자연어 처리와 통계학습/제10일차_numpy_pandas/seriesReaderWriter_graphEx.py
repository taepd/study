# seriesReaderWriter.py

from pandas import Series
import matplotlib.pyplot as plt

plt.rc('font', family='Malgun Gothic')


myindex = ['서울', '부산', '광주', '대구', '울산', '목포', '여수']
mylist = [50, 60, 40, 80, 70, 30, 20]
myseries = Series(data=mylist, index=myindex)

print(myseries)
print(type(myseries))

# Pandas의 시리즈나 데이터프레임은 plot이라는 시각화 메서드를 내장
# plot은 matplotlib를 내부에서 임포트하여 사용
myseries.plot(title='한국 지역별 방문객 지수')
# plt.title('한국 지역별 방문객 지수')

meanval = myseries.mean()

average = f'평균 : {int(meanval)}'
plt.axhline(y=meanval, color='r', linewidth=1, linestyle='dashed')
plt.text(x=3, y=meanval + 1, s=average, horizontalalignment='center')


filename = 'series_graph_01.png'
plt.savefig(filename)
print(filename + ' 파일 저장됨')
