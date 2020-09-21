# fileIO01.py
# 파일 입출력
# 순서 : open > write/read > close
# open() 텍스트/바이너리 파일을 읽거나 쓰기 위한 함수
# open(file='전체경로+파일이름', mode='w', encoding='utf-8')
# mode : r(read:기본값)/w(write)/a(append)/x(exclusive) t(text:기본값)/b(binary)
myfile01 = open(file='newfile.txt', mode='w', encoding='utf-8')
for idx in range(1, 11):
    # 문자열 '\n'은 줄바꿈을 의미
    data = '%2d번째 줄입니다\n' % (idx)
    myfile01.write(data)

myfile01.close()

# mode='a' : 기존 파일에 추가 작성하기
myfile02 = open(file='newfile.txt', mode='a', encoding='utf-8' )
for idx in range(11, 101):
    data = '%3d번째 줄입니다\n' % (idx)
    myfile02.write(data)
myfile02.close()

print('여러 개 파일 만들기')
for idx in range(1, 11):
    filename = 'somefile'+str(idx).zfill(2)+'.txt'
    myfile = open(filename, 'w', encoding='utf-8') # 옵션 표기를 생략할 수도 있다(encoding은 생략 안되는듯)
    data = '메롱'
    myfile.write(data)
    myfile.close()

print('with 구문 사용하기') # close 자동으로 해줌
with open(file='test.txt', mode='w', encoding='utf-8') as myfile:
    myfile.write('메롱\n')
    myfile.write('하하\n')
    print('가나다라', file=myfile) # print의 출력옵션을 file로 설정해서 입력도 가능

print('-'*20)
with open(file='test.txt', mode='r', encoding='utf-8') as myfile:
    print(myfile.read())
    print(type(myfile.read()))
    myfile.seek(0)
    print(myfile.readlines())

print('finished')
