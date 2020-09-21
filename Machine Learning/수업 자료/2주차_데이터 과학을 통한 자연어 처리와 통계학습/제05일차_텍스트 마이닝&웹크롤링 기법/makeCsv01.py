# makeCsv01.py

# 임의의 데이터를 만들어서 csv 파일로 기록해보기
"""
pandas(판다스):
    Series(1행 또는 1열의 데이터 집합)
    DataFrame(여러 행 또는 여러 열의 데이터 집합)
    데이터 분석을 위한 패키지
    특정 데이터 읽기/쓰기(csv, 엑셀, 웹 등), 통계 정보, 데이터 베이스 등등

csv파일 : comma separate value 텍스트 파일
"""

import random
import pandas as pd

result = []
mycolumns = ('번호', '이름', '나이')

for idx in range(1, 11):
    sublist = []
    sublist.append(10*idx)  # extend를 활용하면 리스트 형식으로 여러 개 추가 가능
    sublist.append('김철수' + str(idx))
    sublist.append(random.randint(20, 40))
    result.append(sublist)

print(result)
# DataFrame : 2차원 형식의 표
myframe = pd.DataFrame(result, columns=mycolumns)

filename = 'result01.csv'

myframe.to_csv(filename, mode='w', encoding='utf-8')

print('finished')

