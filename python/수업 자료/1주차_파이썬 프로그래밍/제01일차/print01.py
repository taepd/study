# # print 함수: 문장을 출력
# print('동해물과' '백두산이')
# print('동해물과' '백두산이' '마르고' '닳도록')
#
# # 콤마를 붙이면 띄어쓰기가 됨
# print('동해물과', '백두산이', '마르고', '닳도록')
#
# # 실행을 위한 단축키: Shift + F10
# # end 옵션의 기본값은 Enter
# print('안녕하세요', end=' ')
# print('홍길동님')
#
# #input() 함수
# print('이름을 입력')
# name = input()
# age = input('나이 입력')
# print('이름 :', name, ',나이 :', age)
#
# # 데이터 형변환: (바뀔타입)바꿀데이터
# # int는 정수형, str은 문자열형
# newage = int(age) + 5
# print('5년뒤 나이 :' + str(newage))

kor = int(input('국어 점수 입력: '))
eng = int(input('영어 점수 입력: '))
math = int(input('수학 점수 입력: '))

total = kor + eng + math
# print에 콤마를 찍으면 문자열로 인식
print('총점 :', total)
