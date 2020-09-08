

import sqlite3 # sqlite를 위한 내장 모듈

# conn: 데이터 베이스에 접근하기 위한 객체
# database : 데이터 베이스 파일 이름
conn = sqlite3.connect(database='sqlitedb.db')
print(type(conn))

# cursor(커서) : 데이터베이스 작업을 수행하고 있는 메모리 공간
mycursor = conn.cursor()

try:
    # excute : sql 구문을 실행해주는 함수
    mycursor.execute("drop table sungjuk")
except sqlite3.OperationalError as err:
    print("테이블이 존재하지 않습니다.")

mycursor.execute(
    '''create table sungjuk
    (id text, subject text, jumsu integer)'''
)

datamylist = []

for i in range(9):
    # 이름 추가
    if i<3:
        datamylist.append(['lee'])
    elif i<6:
        datamylist.append(['jo'])
    else:
        datamylist.append(['ko'])
    # 과목 추가
    if i%3 == 0:
        datamylist[i].append('java')
    elif i%3 == 1:
        datamylist[i].append('html')
    else:
        datamylist[i].append('python')
    # 점수 추가
    datamylist[i].append((i+1)*10)
    # 튜플화
    datamylist[i] = tuple(datamylist[i])

sql = "insert into sungjuk(id, subject, jumsu) values(?, ?, ?)"
mycursor.executemany(sql, datamylist)

conn.commit()


print(datamylist)


mycursor.close()
conn.close()


print('finished')

