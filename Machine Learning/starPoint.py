def showStar(su=10):
    if su <0:
        su = abs(su)
    star = '★'*su
    print(star)

# showStar() 함수를 이용하여 별을 su개 만큼 출력하는 프로그램을 작성하세요.
# 만약 매개변수를 입력하지 않으면 10개를 출력하도록 합니다.

showStar(5)
showStar()

for idx in range(1, 11):
    showStar(idx)

showStar(-7)

for item in [3, 5]:
    showStar(item)