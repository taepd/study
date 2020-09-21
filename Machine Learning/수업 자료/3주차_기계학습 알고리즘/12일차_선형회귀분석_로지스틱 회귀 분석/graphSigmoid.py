# graphSigmoid.py
# 시그모이드 함수를 그려 보자
import numpy as np
import matplotlib.pyplot as plt

def sigmoid(weight, x, b=0, asc=True):
    if asc is True:
        return 1/(1 + np.exp(-(weight * x + b)))
    else:
        return 1/(1 + np.exp((weight * x + b)))

# np.arange() : 파이썬 range()와 유사
x = np.arange(-5.0, 5.1, 0.1)


# weight가 커질 수록 계단함수에 가까워지고, bias가 커질수록 중심이 왼쪽으로 이동
weight, bias = 1, 0
y1 = sigmoid(weight, x)
mylabel = f'y={weight}*x +{bias}'
plt.plot(x, y1, color='g', label=mylabel)

weight, bias = 5, 0
y2 = sigmoid(weight, x, bias)
mylabel = f'y={weight}*x +{bias}'
plt.plot(x, y2, color='b', label=mylabel)

weight, bias = 5, 3
y3 = sigmoid(weight, x, bias)
mylabel = f'y={weight}*x +{bias}'
plt.plot(x, y3, color='r', label=mylabel)

# 반전시킨 경우
weight, bias = 5, 3
y4 = sigmoid(weight, x, bias, False)
mylabel = f'y={weight}*x +{bias}'
plt.plot(x, y4, color='y', label=mylabel)


plt.axhline(y=0, color='black', linewidth=1, linestyle='dashed')
plt.axhline(y=1, color='black', linewidth=1, linestyle='dashed')

plt.title('sigmoid function')
plt.ylim(-0.1, 1.1)
plt.legend(loc='best')

filename = 'sigmoid_function.png'
plt.savefig(filename)
print(filename + ' 파일 저장됨')

print('finished')
