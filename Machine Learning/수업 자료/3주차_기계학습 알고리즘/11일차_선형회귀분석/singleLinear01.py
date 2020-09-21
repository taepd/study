# singleLinear01.py
# 카페에서 첨부파일 '회귀분석예제파일.zip' 다운로드해서 압축 해제하세요.
import numpy as np
# sklearn : science-kit(머신러닝을 위핸 패키지)
from sklearn.model_selection import train_test_split
from tensorflow.python.keras.layers import Dense
from tensorflow.python.keras.models import Sequential


"""
첨부한 엑셀 파일을 읽어 옵니다.
훈련/학습 데이터와 테스트 데이터의 비율을 75대 25로 분리
훈련/학습 데이터를 이용하여 선형 회귀 분석을 한 다음,
테스트 데이터를 이용하여 결과를 예측
"""

filename = '../첨부(3주차)/회귀분석예제파일/singleLinear01.csv'
data = np.loadtxt(filename, delimiter=',')
print(type(data))

table_col = data.shape[1]  # 컬럼 수
y_column = 1  # 정답 데이터 컬럼수
x_column = table_col - y_column  # 입력 데이터 컬럼수

x = data[:, 0:x_column]
y = data[:, x_column:]

print(x)
print('-'*30)

print(y)
print('-'*30)

# 입력용 학습, 입력용 테스트, 출력용 학습, 출력용 테스트
# = train_test_split(입력원본, 출력원본, test_size=테스트 데이터의 비율)
# 일반적으로 7:3 으로 나눔

x_train, x_test, y_train, y_test \
    = train_test_split(x, y, test_size=0.25) #  '\': 줄바꿈시 사용

print(x_train)
print('-'*30)

print(y_train)
print('-'*30)

# 모델을 생성하고, 학습을 수행
# 단계1: 모델(작업공간) 생성
model = Sequential()

# 단계2: 레이어를 추가
# Dense: 레이어를 추가하는 데 사용되는 클래스
# units(필수값): 출력값의 크기?, input_dim: 입력데이터의 크기?? 아닌듯?
# activation: 활성화 함수, linear: 선형 회귀분석
# 총 layer 개수 : add() 함수 개수 +1
model.add(Dense(units=y_column, input_dim=x_column, activation='linear'))

# 단계3: 컴파일 수행
# loss: 비용(손실)함수 지정
# optimizer: 경사하강법을 잘 수행하기 위한 가이드 역할
model.compile(loss='mean_squared_error', optimizer='adam')

# 단계4: 훈련/학습 수행
# epochs: 반복 횟수
# batch_size: 한 번에 수행할 데이터의 양
# verbose: 0(진행 결과를 출력하지 않음), 1(기본값, 테스트 시마다 1번씩), 2(epoch당 1번)
# 지도 학습법: 입력 데이터와 출력 데이터를 같이 넣어주는 학습법
model.fit(x_train, y_train, epochs=5000, batch_size=10, verbose=1)

# 단계5: 예측
prediction = model.predict(x_test)

for idx in range(len(y_test)):
    label = y_test[idx]  # 정답 데이터
    pred = prediction[idx]  # 예측치

    print(f'real: {label}, prediction: {pred}')

print('finished')
