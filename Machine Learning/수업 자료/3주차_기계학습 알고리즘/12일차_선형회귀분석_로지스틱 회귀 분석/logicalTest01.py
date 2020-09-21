# logicalTest01.py
import numpy as np
from tensorflow.python.keras.models import Sequential
from tensorflow.python.keras.layers import Dense
# from tensorflow.python.keras.optimizers import SGD  # 에러발생 체크
from tensorflow.keras.optimizers import SGD
# 확률적 경사하강법 Stochastic Gradient Descent
# SGD는 손실함수의 기울기를 계산하여서 이 기울기 값에 학습률(Learning Rate)를 계산하여 이 결과 값으로 기존의 가중치 값을 갱신한다.

filename = '../첨부(3주차)/로지스틱_실습파일/logicalTest01.csv'
data = np.loadtxt(filename, delimiter=',')

table_col = data.shape[1]
y_column = 1
x_column = table_col - 1

# 기출 문제
x_train = data[:, 0:x_column]
y_train = data[:, x_column:]

# 풀어 볼 문제
x_test = [[5], [11]]

model = Sequential()

# 퍼셉트론: 전구(0, 1)처럼 0과 1의 값을 가지고 있는 신경망
# 퍼셉트론이 회귀나 로지스틱이나 다른 머신러닝으로 바뀌기 위해서는 함수를 지정해 줄 필요가 있음
# 이 때 사용되는 함수를 활성화 함수(activation function)라고 부름
# 선형 회귀: linear, 로지스틱 회귀: sigmoid 등
model.add(Dense(units=y_column, input_dim=x_column, activation='sigmoid'))

# 비용(손실, loss) 함수는 이진 분류이므로 'binary_crossentropy'를 사용
# optimizer 사용시 지정 문자열을 사용해도 되지만, 객체 생성을 통해 만드는 것도 가능
learning_rate = 0.1  # 학습률

sgd = SGD(lr=learning_rate)  # 객체 생성, lr: 학습률
model.compile(loss='binary_crossentropy', optimizer=sgd)

model.fit(x=x_train, y=y_train, epochs=2000, verbose=0)

# 해당 모델에 훈련용 데이터를 이용하여 확률값을 예측
H2 = model.predict(x_train)
print(H2)
print('-'*30)

for item in x_test:
    H = model.predict(np.array([item]))
    print(H)
    print('-'*30)

    # predict_classes : 정답이 가지고 있는 클래스의 값을 출력해 줌
    # pred = model.predict_classes(np.array([item]))  # deprecated
    pred = (model.predict(np.array([item])) > 0.5).astype("int32")
    print('테스트 데이터:', np.array([item]))
    print(pred)

print('finished')
