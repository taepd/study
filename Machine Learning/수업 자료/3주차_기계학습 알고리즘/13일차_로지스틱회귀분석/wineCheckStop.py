# wineCheckStop.py
import pandas as pd
from tensorflow.python.keras.models import Sequential
from tensorflow.python.keras.layers import Dense
import os
from tensorflow.python.keras.callbacks import ModelCheckpoint
from tensorflow.python.keras.callbacks import EarlyStopping
import matplotlib.pyplot as plt
import numpy as np
"""
콜백 함수 : 시스템이 어떠한 요구 사항을 충족했을 때, 스스로 동작하는 함수
ModelCheckPoint: 매 epoch마다 모델을 자동으로 저장해주는 콜백 함수
EarlyStopping: 학습이 진행되는 동안 개선의 여지가 보이지 않으면 강제로 스톱해주는 콜백 함수
"""
"""
파일을 불러와 15%만 샘플링한다
모델을 생성한 다음 학습
매 epoch마다 모델을 저장
콜백함수 객체 생성
fit() 함수의 callbacks 매개변수에 콜백 객체를 대입
"""

filename = '../첨부(3주차)/로지스틱_실습파일/wine.csv'
df_wine = pd.read_csv(filename, header=None)

print(df_wine.shape)
print('-'*30)


# sample(): 샘플링 함수
# frac: fraction 비율 지정
df = df_wine.sample(frac=0.15)
print(df.shape)

data = df.values
table_col = data.shape[1]

y_column = 1
x_column = table_col - y_column

x = data[:, 0:x_column]
y = data[:, x_column:]

model = Sequential()

model.add(Dense(units=30, input_dim=x_column, activation='relu'))
model.add(Dense(units=12, activation='relu'))
model.add(Dense(units=8, activation='relu'))
model.add(Dense(units=y_column, activation='sigmoid'))

model.compile(loss='binary_crossentropy', optimizer='adam', metrics=['accuracy'])

model_dir = './model/'  # 모델을 저장할 폴더

if not os.path.exists(model_dir):
    os.mkdir(model_dir)
# epoch : 에포크
# val_loss : 검증용 데이터셋의 손실 오차

model_name = model_dir + '{epoch:02d}-{val_loss:.4f}.hdf5'

# filepath: 파일을 저장할 경로, monitor: 모니터링할 대상
# loss(학습셋 오차), val_loss(검증용셋 오차), acc(학습 정확도), val_acc(검증용셋 정확도)
# save_best_only: 이전 단계보다 모델이 더 개선되었을 경우에만 저장
mcp = ModelCheckpoint(filepath=model_name, monitor='val_loss', verbose=1,
                      save_best_only=True)

# patience=100: 테스트의 오차가 개선되지 않더라도 100번 기다림
es = EarlyStopping(monitor='val_loss', patience=100)

"""
validation_split: 훈련에 반영하지 않고, 테스트용으로 사용할 데이터셋 비율
                  실제 학습에 사용되지는 않고, 매 epoch의 끝자락에서
                  metrics를 평가하는 용도로 사용
callbacks: 콜백 함수 객체들을 리스트 형식으로 지정해 줌
History 객체: fit() 함수의 반환 객체
"""
history = model.fit(x, y, epochs=3500, batch_size=500,
                    validation_split=0.2, callbacks=[mcp, es])
val_loss = history.history['val_loss']
print(val_loss)
print('-'*30)

accuracy = history.history['accuracy']
print(accuracy)
print('-'*30)

# 비용 함수와 정확도에 대한 시각화를 수행
x_len = np.arange(len(accuracy))

plt.plot(x_len, val_loss, 'ro', markersize=3)
plt.plot(x_len, accuracy, 'bo', markersize=3)

filename = 'wineTest.png'
plt.savefig(filename)
print(filename + ' 파일 저장됨')


print('finished')
