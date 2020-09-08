# seasonTest.py
# 해당 월과 계절을 출력해주는 프로그램 작성
month = int(input('달을 입력하세요.'))

# 입력: 9
# 9월은 가을입니다.

if 3 <= month <= 5:
    season = '봄'
elif 6 <= month <= 8:
    season = '여름'
elif 9 <= month <= 11:
    season = '가을'
elif month in [12, 1, 2]:
    season = '겨울'
else:
    season ='무제'

print('%d월은 %s입니다' % (month, season))