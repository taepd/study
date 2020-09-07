# randomExam01.py
# 주사위를 10번 던져서 나온 눈의 총합을 구해주는 주사위 프로그램
# 단 시도 횟수가 입력되지 않으면 5번 시도
import random

def dice(su = 5):
    total = 0
    record = []
    for i in range(su):
        dPoint = random.randint(1,6)
        record.append(dPoint)
        total += dPoint
    print('나온 주사위 눈 기록: ', record)
    print('{}번 던진 주사위 눈의 합은 {}입니다'.format(su, total))

sido = 10 # 시도횟수
dice(sido)

dice()