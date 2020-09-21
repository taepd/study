# softMaxEx01.py
import numpy as np
from sklearn.model_selection import train_test_split
from keras.utils import np_utils
from tensorflow.python.keras.models import Sequential
from tensorflow.python.keras.layers import Dense


filename = '../첨부(3주차)/로지스틱_실습파일/softMaxEx01.csv'
data = np.loadtxt(filename, delimiter=',')

table_col = data.shape[1]
y_column = 1
x_column = table_col - y_column

x = data[:, 0:x_column]
y = data[:, x_column:]

# 정답이 가질 수 있는 클래스 개수
NB_CLASSES = 3

seed = 1234
x_train, x_test, y_train, y_test = \
    train_test_split(x, y, test_size=0.3, random_state=seed)

print(y_train)  # one-hot encoding 적용하기 이전

# np_utils: one-hot encoding을 수행해 줌
y_train = np_utils.to_categorical(y_train, num_classes=3, dtype='float32')

print(y_train)

model = Sequential()

model.add(Dense(units=NB_CLASSES, input_shape=(x_column,), activation='softmax'))


# 모델의 간략한 정보를 출력
model.summary()

# 'sgd' Stochastic Gradient Descent : 확률적 경사하강법
# 데이터 세트에서 무작위로 균일하게 선택한 하나의 예를 의존하여 각 단계의 예측 경사를 계산 > 더 빠른 계산 가능
model.compile(loss='categorical_crossentropy', optimizer='sgd', metrics=['accuracy'])

history = model.fit(x_train, y_train, epochs=1000, verbose=0)
print(history)
print('-'*30)

for idx in range(len(x_test)):
    H = model.predict(np.array([x_test[idx]]))
    pred = np.argmax(H, axis=-1)
    print(f'예측값: {pred}', end=' ')
    print(f'정답: {int(y_test[idx])}')
    print(f'가설 정보: {H.flatten()}')
    print('-'*30)

print('finished')
