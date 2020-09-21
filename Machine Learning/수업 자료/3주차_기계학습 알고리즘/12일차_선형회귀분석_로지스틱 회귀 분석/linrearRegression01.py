# linearRegression01.py
# 사이킷-런을 이용한 회귀 분석
# 결정 계수(coefficient of Determination;R^2, R-Square) : 실제 값이 예측 값과 얼마 정도의 일치성을 보이는지 나타내는 척도
# 값은 0부터 1사이의 값, 1에 가까울수록 설명력이 좋음
# R-squared = 1 - Σ(y-H)**2 / Σ(y-bar_y)**2
# y label, H:예측값, bar_y: label 평균값

import numpy as np
from sklearn.linear_model import LinearRegression
import matplotlib.pyplot as plt

plt.rc('font', family='Malgun Gothic')

filename = '../첨부(3주차)/회귀분석예제파일/linearTest01.csv'  # 학습용 데이터셋

# skiprows : 머리글 1행은 제외
training = np.loadtxt(filename, delimiter=',', skiprows=1)
print(training)

x_column = training.shape[1] - 1

x_train = training[:, 0:x_column]
y_train = training[:, x_column]

# 모델 객체 생성
model = LinearRegression()

# 학습
model.fit(x_train, y_train)

print(f'기울기(w): {model.coef_}')  # coefficient : 계수
print(f'절편(b): {model.intercept_}')  # intercept : 절편
print(f'잔차(cost)의 제곱 합: {model.residues}')  # resiudes : 잔차

# 시각화
plt.title('그래프')
plt.xlabel('x')
plt.ylabel('y')
plt.plot(x_train, y_train, 'bo')  # 회귀선

train_pred = model.predict(x_train)

plt.plot(x_train, train_pred, 'r')  # 회귀선
filename = 'linearRegression.png'
plt.savefig(filename)
print(filename + ' 파일 저장됨')

filename = '../첨부(3주차)/회귀분석예제파일/linearTest02.csv'  # 테스트용 데이터셋
testing = np.loadtxt(filename, delimiter=',', skiprows=1)
print(testing)

x_column = testing.shape[1] - 1

x_test = testing[:, 0:x_column]
y_test = testing[:, x_column]

print(y_test)
# 산술 연산에 의한 결정계수 구하기
y_test_mean = np.mean(np.ravel(y_test))

# ravel() : 다차원 배열을 1차원으로 바꾸는 것(원래 값을 변경), cf)flatten(): 새로운 값으로 저장
# RSS(residual sum of squares)) 잔차(실제값과 예측값의 차이)의 제곱의 총합
RSS = np.sum((np.ravel(y_test) - np.ravel(model.predict(x_test)))**2)  # SSR이라고도 함

# TSS(total sum of square)) 편차의 제곱의 총합
TSS = np.sum((np.ravel(y_test) - y_test_mean)**2)  # SST라고도 함


# 결정계수 = 1 - RSS/TSS
R_Squared = 1 - (RSS/TSS)
print('R_Squared 01 :', R_Squared)

# score: R_Squared 함수
print('R_Squared 02 :', model.score(x_test, y_test))


print('finished')
