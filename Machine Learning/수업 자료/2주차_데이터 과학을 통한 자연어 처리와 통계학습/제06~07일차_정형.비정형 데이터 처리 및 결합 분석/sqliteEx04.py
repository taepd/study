# sqliteEx04.py
# 텍스트의 파일을 읽어서 sqlite DB에 추가하기

filename = '../첨부(2주차)/mem.txt'

myfile = open(filename, 'r', encoding='utf-8')
mylist = [item.strip() for item in myfile.readlines()]
print(mylist)

myfile.close()

import sqlite3

conn = sqlite3.connect('sqlitedb.db')
mycursor = conn.cursor()

try:
    # excute : sql 구문을 실행해주는 함수
    mycursor.execute("drop table members")
except sqlite3.OperationalError as err:
    print("테이블이 존재하지 않습니다.")

mycursor.execute(
    '''create table members
    (id text, name text)'''
)

sql = 'insert into members(id, name) values(?, ?)'
# for item in mylist:
#     columnlist = item.split(',')
#     mycursor.execute(sql, columnlist)

mycursor.executemany(sql, [item.split(',') for item in mylist])
conn.commit()

mycursor.close()
conn.close()

print('finished')
