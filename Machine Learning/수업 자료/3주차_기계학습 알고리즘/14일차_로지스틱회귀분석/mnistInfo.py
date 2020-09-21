# mnistInfo.py
# 손글씨 데이터셋을 다운로드하고, 데이터의 구조를 살펴보도록 합니다.
# 임의의 하나의 데이터를 이용하여 시각화 해봅니다.

from tensorflow.python.keras.datasets import mnist
import matplotlib.pyplot as plt

(x_train, y_train), (x_test, y_test) = mnist.load_data()

print('x_train.shape: ', x_train.shape)
print('-'*30)

print('x_train.dtype: ', x_train.dtype)
print('-'*30)

print('x_train.ndim: ', x_train.ndim)
print('-'*30)

print('y_train: ', y_train)
print('-'*30)

print('x_test.shape: ', x_test.shape)
print('-'*30)

print('len(y_test): ', len(y_test))
print('-'*30)

print('y_test: ', y_test)
print('-'*30)

digit = x_train[107]  # 숫자 1개
plt.imshow(digit)
filename = 'mnist_image.png'
plt.savefig(filename)
print(filename + ' 파일 저장됨')

print('finished')
