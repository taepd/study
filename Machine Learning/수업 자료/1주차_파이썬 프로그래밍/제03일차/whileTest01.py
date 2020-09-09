# whileTest01.py
# 숫자 5를 입력받고 5단 출력하기
# 5 * 1 = 5
# 5 * 2 = 10
# 음수가 들어오면 절대값으로 변경하여 출력하기

su = abs(int(input('몇 단 출력 : ')))

i = 1
while i<10:
    mystring = '%d * %d = %d' % (su, i, su*i)
    print(mystring)
    i += 1
