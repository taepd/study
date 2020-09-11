# mystudentEx.py
# mystudent.xml 파일을 읽어서 students.csv 만들기
# students.db 파일에 students 테이블을 생성하고, 데이터를 추가하세요.
# pandas, DataFrame, sqlite, xml 패키지
# 추가 사항 : 총점과 평균도 같이 csv 파일과 db에 입력

import pandas as pd
import sqlite3
from xml.etree.ElementTree import parse

result = []

# parse : xml 파싱 메소드
tree = parse('../첨부(2주차)/mystudent.xml')

myroot = tree.getroot()
mylist = [elem for elem in myroot]
print(mylist)

# mystudent.xml 파일을 읽어서 students.csv 만들기

# 컬럼(태그)명 얻기
mycolumns = [item.tag for item in mylist[0]]

# 총점과 평균 컬럼 추가
mycolumns.extend(('총점', '평균'))

print(mycolumns)

# 세부 데이터값 얻기
for idx in range(len(mylist)):  # 자식태그(student)길이만큼 반복
    sublist = [item.text for item in mylist[idx]]

    # 총점과 평균 추가
    total = 0
    avg = 0
    for i in range(len(sublist)):
        if i != 0:
            total += int(sublist[i])
        avg = total/(len(sublist)-1)
    sublist.append(total)
    sublist.append(avg)

    result.append(sublist)
print(result)


# DateFrame 이용해서 csv 파일 생성
# DataFrame : 2차원 형식의 표
myframe = pd.DataFrame(result, columns=mycolumns)

filename = 'mystudentEx.csv'

myframe.to_csv(filename, mode='w', encoding='utf-8')

# students.db 파일에 students 테이블을 생성하고, 데이터를 추가하세요.


conn = sqlite3.connect('sqlitedb.db')
mycursor = conn.cursor()

try:
    # excute : sql 구문을 실행해주는 함수
    mycursor.execute("drop table studentEx")
except sqlite3.OperationalError as err:
    print("테이블이 존재하지 않습니다.")

mycursor.execute(
    '''create table studentEx
    (name text, kor integer, eng integer, math integer, total integer, average integer)'''
)

sql = 'insert into studentEx(name, kor, eng, math, total, average) values(?, ?, ?, ?, ?, ?)'
# for item in mylist:
#     columnlist = item.split(',')
#     mycursor.execute(sql, columnlist)

mycursor.executemany(sql, result)
conn.commit()

mycursor.close()
conn.close()
