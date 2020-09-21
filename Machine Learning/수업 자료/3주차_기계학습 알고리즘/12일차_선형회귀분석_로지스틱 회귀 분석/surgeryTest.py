# surgeryTest.py
import numpy as np
from sklearn.model_selection import train_test_split
from tensorflow.python.keras.models import Sequential
from tensorflow.python.keras.layers import Dense


filename = '../첨부(3주차)/로지스틱_실습파일/surgeryTest.csv'
data = np.loadtxt(filename, delimiter=',')

print('data.shape:', data.shape)
table_col = data.shape[1]
y_column = 1
x_column = table_col - 1

x = data[:, 0:x_column]
y = data[:, x_column:]

# seed = 0
# x_train, x_test, y_train, y_test = \
#     train_test_split(x, y, test_size=0.2, random_state=seed)

x_train, x_test, y_train, y_test = \
    train_test_split(x, y, test_size=0.2)

model = Sequential()

model.add(Dense(units=30, input_dim=x_column, activation='relu'))
model.add(Dense(units=y_column, activation='sigmoid'))

model.compile(loss='binary_crossentropy', optimizer='adam', metrics=['accuracy'])

model.fit(x_train, y_train, epochs=30, batch_size=10, verbose=1)

# 모델 관련 속성
# input 텐서의 정보
print('model.inputs:', model.inputs)
print('-'*30)

# output 텐서의 정보
print('model.outputs:', model.outputs)
print('-'*30)

# model.add() 함수를 사용한 레이어들의 주소 정보
print('model.layers:', model.layers)
print('-'*30)

# metrics : 성능에 대한 지표
# 기본값으로 비용 함수는 무조건 보여 줌
# 더 추가하려면 compile 함수의 매개변수 metrics에 리스트 형식을 넣어주면 된다
print('model.metrics:', model.metrics)
print('model.metrics:', model.metrics_names)
print('-'*30)

pred = (model.predict(x_test) > 0.5).astype("int32")
for idx in range(len(pred)):
    label = y_test[idx]
    print(f'정답: {label}, 예측: {pred[idx]}')



