# for02.py
# 1부터 10까지의 정수 중에서 짝수의 총합과 홀수의 총합을 각각 구해 보세요
odd = even = 0

for idx in range(1, 11):
    if idx % 2 == 0:
        even += idx
    else:
        odd += idx

print('짝수의 총합은 %d입니다. ' % (even))
print('홀수의 총합은 %d입니다. ' % (odd))

# 1부터 50까지의 정수 중에서 3의 배수가 아닌 수의 합
# sumA = 1 + 2 + 4 + ... + 50
# sumB = 3 + 6 + 9 + ... + 48
# sumA - sumB

sumA = sumB = 0

for idx in range(1, 51):
    if idx % 3 == 0:
        sumB += idx
    else:
        sumA += idx
print('정답은 %d입니다.' % (sumA-sumB))

