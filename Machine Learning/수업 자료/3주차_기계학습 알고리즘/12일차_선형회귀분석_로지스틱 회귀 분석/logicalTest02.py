# logicalTest02.py
# 로지스틱 회귀 연습문제
# 테스트 데이터) x_test = [[2, 1], [6, 5], [11, 6]]
import numpy as np
from tensorflow.python.keras.models import Sequential
from tensorflow.python.keras.layers import Dense
from tensorflow.keras.optimizers import SGD

filename = '../첨부(3주차)/로지스틱_실습파일/logicalTest02.csv'

data = np.loadtxt(filename, delimiter=',')

table_col = data.shape[1]
y_column = 1
x_column = table_col - 1

x_train = data[:,  0:x_column]
y_train = data[:, x_column:]

x_test = [[2, 1], [6, 5], [11, 6]]

model = Sequential()

model.add(Dense(units=y_column, input_dim=x_column, activation='sigmoid'))

learning_rate = 0.1

sgd = SGD(lr=learning_rate)

model.compile(loss='binary_crossentropy', optimizer=sgd)

model.fit(x=x_train, y=y_train, epochs=2000, verbose=0)

# 0: 강아지, 1: 고양이
def GetCategory(mydata):
    mylist = ['강아지', '고양이']
    print(f'예측: {mydata}, {mylist[mydata[0]]}')

# flatten() : 차원을 1차원으로 만들어 주는 함수
for item in x_test:
    H = model.predict(np.array([item]))
    print('예측 확률치:', H.flatten())
    pred = (model.predict(np.array([item])) > 0.5).astype("int32")
    print('테스트 데이터:', np.array([item]))
    # print(pred.flatten())
    GetCategory(pred.flatten())

