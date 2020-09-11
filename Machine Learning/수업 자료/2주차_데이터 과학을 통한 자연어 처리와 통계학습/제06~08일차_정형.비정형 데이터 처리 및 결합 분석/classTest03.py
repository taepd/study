# classTest03.py

# 계산기
# 계산기 A : 3 + 4 = 7
# 계산기 B : 5 + 15 = 20

# step1 : 클래스(탬플릿) 정의
# step2 : 객체 생성
# step3 : 변수에 값을 할당
# step4 : 출력이나 다른 용도로 사용

# 클래스 구성 요소 : 변수, 함수, 생성자(__init__)
# 생성자 : 내부에 들어 있는 변수들의 초기화 용도

class Calculator:  # 클래스 정의
    def __init__(self, data):
        self.result = 0 # 총합을 0으로 초기화
        self.data = data
        print(self.data + '가 생성되었습니다')
        print('계산기 초기 값 :', self.result)

    def calc(self, num):
        self.result += num
        return self.result

# 객체 생성 : 해당 클래스를 이용하여 인스턴스 생성
# Calculator는 생성자 함수를 호출
# 규칙 : 생성자의 이름은 클래스의 이름과 동일해야 함
cal1 = Calculator('계산기 A')
print(cal1)
print(cal1.calc(3))
print(cal1.calc(4))
print('-'*30)

cal2 = Calculator('계산기 B')
print(cal2)
print(cal2.calc(5))
print(cal2.calc(15))

print('finished')
