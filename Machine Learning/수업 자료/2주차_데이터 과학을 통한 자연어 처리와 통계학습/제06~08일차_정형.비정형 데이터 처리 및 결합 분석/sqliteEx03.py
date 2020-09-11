# sqliteEx03.py
import sqlite3


class SqliteDB:
    def __init__(self, dbname):
        print('생성자 출력')
        self.conn = sqlite3.connect(dbname)
        self.cursor = self.conn.cursor()

    def __del__(self):  # 소멸자(마감 처리 용도)
        self.cursor.close()
        self.conn.close()

    def getJoinData(self):  # 조인 데이터
        sql = '''
        select st.id, st.name, st.birth, sg.subject, sg.jumsu 
        from students st join sungjuk sg 
        on st.id = sg.id
        '''

        result = self.cursor.execute(sql)
        return result

    def getSubQuery(self, name):
        sql = '''
        select * from sungjuk 
        where id = (select id from students where name = '%s')
        '''

        result = self.cursor.execute(sql % (name))
        return result

    def getJumsu(self, name):
        sql = '''
        select jumsu from sungjuk 
        where id = (select id from students where name = '%s')
        '''

        result = self.cursor.execute(sql % (name))

        total = 0 # 총점
        cnt = 0 # 행 갯수

        for row in result:
            total += row[0]
            cnt += 1

        if cnt == 0:
            return None
        average = total / cnt

        return (total, average)


dbname = 'sqlitedb.db'
mydb = SqliteDB(dbname)

dataset = mydb.getJoinData()
for row in dataset:
    print(row)
print('-' * 30)

dataset = mydb.getSubQuery('이문세')
for (id, subject, jumsu) in dataset:
    print('아이디 :', id, end='', sep='')
    print(', 과목 :', subject, end='', sep='')
    print(', 점수 :', jumsu, end='', sep='')
    print()
print('-' * 30)

# 고아라, 심형래(없는 데이터) 점수 구하기
dataset = mydb.getJumsu('고아라')
if dataset != None:
    print('총점 : ', dataset[0])
    print('평균 : ', dataset[1])
else:
    print('존재하지 앟는 회원입니다')
print('-' * 30)

dataset = mydb.getJumsu('심형래')
if dataset != None:
    print('총점 : ', dataset[0])
    print('평균 : ', dataset[1])
else:
    print('존재하지 앟는 회원입니다')
print('-' * 30)

print('finished')
