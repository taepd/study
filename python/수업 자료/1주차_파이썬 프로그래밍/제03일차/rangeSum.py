# rangeSum.py
# 정수 2개를 입력 받아서, 앞수에서 뒷수 사이에 있는 모든 정수의 합을 구하세요.
# 앞수 : 2, 뒷수 : 4이면 2+3+4=9 출력

# 출력 예시 : 2부터 4까지의 총합은 9입니다.

a ,b = map(int, input().split())

if a > b :
    a , b = b , a
mylist = [idx for idx in range(a, b+1)]
print('%d부터 %d까지의 총합은 %d입니다.' % (a, b, sum(mylist)))
