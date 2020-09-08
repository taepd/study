# variantArgs01.py
# 가변 인자 : * 기호가 매개변수로 사용시 tuple로 인식

def func(*args):
    total = 0
    for item in args:
        total += item
    print('총합 : ', total)
    
func(1, 2)
func(5, 6, 7)

