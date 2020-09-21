# irisSoftMax01.py
import pandas as pd
from sklearn.preprocessing import LabelEncoder
import numpy as np
from sklearn.model_selection import train_test_split
from keras.utils import np_utils
from tensorflow.python.keras.models import Sequential
from tensorflow.python.keras.layers import Dense
from pandas import DataFrame

filename = '../첨부(3주차)/로지스틱_실습파일/newiris.csv'

df = pd.read_csv(filename)
print(df.columns)
print('-'*30)

print(df['Species'].unique())
print('-'*30)

data = df.values

table_col = data.shape[1]
y_column = 1
x_column = table_col - y_column

x = data[:, 0:x_column]
# label이 문자열이므로 우선 임시로
y_ = data[:, x_column:]
# print(y_)

y_ = y_.ravel()
print(y_)

# y_는 문자열인데, 이것을 숫자형 데이터로 변환
le = LabelEncoder()
y = le.fit_transform(y_)
print(y)

x = x.astype(np.float)
y = y.astype(np.float)

# 데이터셋 분리
x_train, x_test, y_train, y_test = \
    train_test_split(x, y, test_size=0.3)

# one-hot encoding

NB_CLASSES = len(np.unique(y))
print('NB_CLASSES', NB_CLASSES)

y_train = np_utils.to_categorical(y_train, NB_CLASSES, dtype='float32')

print(y_train)

# 모델 생성

model = Sequential()

model.add(Dense(units=NB_CLASSES, input_dim=x_column, activation='softmax'))

model.compile(loss='categorical_crossentropy', optimizer='sgd', metrics=['accuracy'])

# fit()을 하면 history 객체가 dict로 리턴
hist = model.fit(x_train, y_train, epochs=1000, verbose=0)
print(hist.history.keys())
print('-'*30)

print(hist.history['loss'])
print('-'*30)

print(hist.history['accuracy'])
print('-'*30)

# 예측값과 정답 데이터를 저장할 리스트
total_list = []

for idx in range(len(x_test)):
    H = model.predict(np.array([x_test[idx]]))
    pred = np.argmax(H, axis=-1)
    print(f'예측값: {pred}', end=' ')
    print(f'정답: [{int(y_test[idx])}]')
    print(f'가설 정보: {H.flatten()}')
    print('-'*30)
    # item():넘파이 배열을 파이썬 형태로 변경해주는 함수, flatten()과 같은 역할?
    total_list.append((float(pred.item()), y_test[idx]))

myframe = DataFrame(total_list, columns=['예측값', '정답'])
filename = 'irisSoftMaxResult.csv'
myframe.to_csv(filename, index=False)
print(filename + ' 파일 저장됨')

print('finished')
