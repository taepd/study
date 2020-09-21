# extAndLog.py
import numpy as np
import matplotlib.pyplot as plt

def some_function1(h):
    return -np.log(h)


def some_function2(h):
    return -np.log(1-h)
# 1e-8 : 1 * 10^-8 ; 0에 가까운 매우 작은 값 설정
x1 = np.arange(1e-8, 0.51, 0.01)
y1 = some_function1(x1)

plt.plot(x1, y1, 'r', label='-nplog(h)')

x2 = np.arange(0.5, 1.0, 0.001)
y2 = some_function2(x2)

plt.plot(x2, y2, 'g', label='-nplog(1-h)')

plt.grid(True)
plt.xlim(-0.2, 1.2)
plt.ylim(0.0, 5.0)
plt.xlabel('weight')
plt.ylabel('cost')
plt.title('logistic cost function')

filename = 'logistic_function.png'
plt.savefig(filename)
print(filename + ' 파일 저장됨')

