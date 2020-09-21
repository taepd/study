# logicalTest03.py

# 파일을 읽습니다
# 훈련 데이터와 테스트 데이터를 7:3으로 분리
# 최종 결과에 대하여 정확도를 구해 봅니다
# 3번 문제에서 hidden layer를 하나(노드 512개) 추가해 본 문제

import numpy as np
from sklearn.model_selection import train_test_split
from tensorflow.python.keras.models import Sequential
from tensorflow.python.keras.layers import Dense
from tensorflow.keras.optimizers import SGD

filename = '../첨부(3주차)/로지스틱_실습파일/logicalTest03.csv'
data = np.loadtxt(filename, delimiter=',', dtype=np.int32)


table_col = data.shape[1]
y_column = 1
x_column = table_col - 1

x = data[:, 0:x_column]
y = data[:, x_column:]

# seed = 1234 가변적 결과를 위해 seed 비활성
x_train, x_test, y_train, y_test = \
    train_test_split(x, y, test_size=0.3)

model = Sequential()

# hidden layer 1번
# input_dim 매개변수는 첫 번째 Dense에서 1번만 적음
model.add(Dense(units=512, input_dim=x_column, activation='relu'))

# output layer
model.add(Dense(units=y_column, activation='sigmoid'))

learning_rate = 0.01
sgd = SGD(lr=learning_rate)

model.compile(loss='binary_crossentropy', optimizer=sgd)

model.fit(x=x_train, y=y_train, epochs=200, verbose=1)

total, hit = 0, 0  #총 개수, 맞춘 개수

for idx in range(len(x_test)):
    result = (model.predict(np.array([x_test[idx]])) > 0.5).astype("int32")
    print(f'테스트용 데이터: {x_test[idx]}')
    print(f'정답: {y_test[idx]}', end=' ')
    print(f'예측값: {result.flatten()}')

    total += 1
    hit += int(y_test[idx] == result.flatten())

accuracy = hit/total
print('정확도: %.4f' % accuracy)
print('finished')


