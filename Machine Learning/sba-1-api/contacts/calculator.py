class Calculator:
    def __init__(self, num1, num2):
        self.num1 = num1
        self.num2 = num2
    def sum(self):
        return self.num1 + self.num2
    def sub(self):
        return self.num1 - self.num2
    def mul(self):
        return self.num1 * self.num2
    def div(self):
        return self.num1 / self.num2    

if __name__ == '__main__':
    calc = Calculator(6, 2)
    sum_result = calc.sum()
    print(f'덧셈결과: {sum_result}')
    sub_result = calc.sub()
    print(f'뺄셈결과: {sub_result}')
    mul_result = calc.mul()
    print(f'곱셈결과: {mul_result}')
    div_result = calc.div()
    print(f'나눗셈결과: {div_result}')
