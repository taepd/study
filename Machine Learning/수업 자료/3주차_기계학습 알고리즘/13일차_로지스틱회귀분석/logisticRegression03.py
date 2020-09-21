# logisticRegression03.py
import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import confusion_matrix
from sklearn.metrics import accuracy_score
from sklearn.metrics import classification_report
import matplotlib.pyplot as plt
import seaborn as sns
import numpy as np


filename = '../첨부(3주차)/로지스틱_실습파일/pima-indians-diabetes.csv'

"""
당뇨병 정보를 저장한 파일을 7:3으로 나누세요.
"""

df = pd.read_csv(filename, header=0)
data = df.values
print('data:', data)
print('type(data):', type(data))

# numpy로 파일 호출하는 것과 비교를 위해
df2 = np.loadtxt(filename, delimiter=',', skiprows=1)
print('data2: ', df2)

print('data.shape: ', data.shape)
print('-'*30)

print('df.columns:', df.columns)
print('-'*30)

table_col = data.shape[1]

y_column = 1
x_column = table_col - y_column

x = data[:, 0:x_column]
y = data[:, x_column]

x_train, x_test, y_train, y_test = \
    train_test_split(x, y, test_size=0.3)

# 데이터 정규화
scaler = StandardScaler()
x_train = scaler.fit_transform(x_train)
x_test = scaler.transform(x_test)

# 모델 객체 생성
model = LogisticRegression()
model.fit(x_train, y_train)

train_score = model.score(x_train, y_train)
print(f'train 정확도: {train_score: .3f}')

test_score = model.score(x_test, y_test)
print(f'test 정확도: {test_score: .3f}')

print('회귀 계수')
print(model.coef_)
print(model.intercept_)

print('test result')
prediction = model.predict(x_test)

# confusion_matrix(정답 데이터, 예측 데이터)
cf_matrix = confusion_matrix(y_test, prediction)
print('confusion_matrix:')
print(cf_matrix)
print('-'*30)

# accuracy_score(): 정확도를 구해주는 함수
accuracy = accuracy_score(y_test, prediction)
print(f'accuracy(정확도): {100*accuracy: .3f}')
print('-'*30)

# classification_report(): 주요 분류와 관련된 metrics(지표)에 대한 보고서
cl_report = classification_report(y_test, prediction)
print(cl_report)
print('-'*30)

sns.heatmap(pd.DataFrame(cf_matrix), annot=True, cmap='YlGnBu', fmt='g')

plt.title('confusion matrix')
plt.xlabel('actual label')
plt.ylabel('prediction label')

filename = 'logisticRegression03_01.png'
plt.savefig(filename)
print(filename + ' 파일 저장됨')
