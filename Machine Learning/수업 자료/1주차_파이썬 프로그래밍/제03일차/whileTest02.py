# whileTest02.py
# cnt = 0
# while True:
#     print('a' + str(cnt))
#     cnt += 1
#     if cnt == 5:
#         break

# 사용자가 입력한 시험 점수에 대한 평균과 개수를 구해봅니다
# 0 이하의 값이 입력되면 프로그램을 종료하도록 합니다.
total = 0 # 총점
count = 0 # 시험 본 횟수
average = 0.0 # 평균 점수

while True:
    jumsu = int(input('점수 입력 : '))
    if jumsu <= 0:
        break
    total += jumsu
    count += 1
average = total / count

print('총 시험 횟수 : {}'.format(count))
print('총점 : {}'.format(total))
print('평균 : {}'.format(average))

print('finished')