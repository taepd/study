# logisticRegression02.py
import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
from sklearn.linear_model import LogisticRegression
import numpy as np
from sklearn.metrics import confusion_matrix
from sklearn.metrics import accuracy_score
from sklearn.metrics import classification_report
import matplotlib.pyplot as plt
import seaborn as sns


filename = '../첨부(3주차)/로지스틱_실습파일/titanic.csv'
data = pd.read_csv(filename)
print(data.columns)
print('-'*30)

"""
Index(['PassengerId', 'Survived', 'Pclass', 'Name', 'Sex', 'Age', 'SibSp',
       'Parch', 'Ticket', 'Fare', 'Cabin', 'Embarked'],
      dtype='object')
"""
# Survived 컬럼: 생사 여부(1이 생존)

# 코딩 변경: 데이터 분석에 맞도록 사용자가 값을 변경하는 작업
# unique(): 중복된 데이터는 배제하고 1개씩만 표시
print(data['Sex'].unique())
data['Sex'] = data['Sex'].map({'female': 1, 'male': 0})
print(data['Sex'].unique())

# 결측치(missing value): 누락된 데이터
# 출력 결과에 nan이라고 표현되는 부분을 말함
print(data['Age'].unique())

# 결측치에 대하여 나머지 항목들의 평균 값으로 치환
# inplace: 새로운 객체를 생성하지 않고 해당 객체를 변경. 기본값(False)
data['Age'].fillna(value=data['Age'].mean(), inplace=True)
print(data['Age'].unique())

print(data['Pclass'].unique())  # 좌석 등급

result = data.groupby('Pclass')['Pclass'].count()
print('좌석 등급별 인원 수')
print(result)

# dummy 컬럼 만들기
# 파생 컬럼 생성: FirstClass(1등석일때만 값1), SecondClass(2등석일때만 값1)
data['FirstClass'] = data['Pclass'].apply(lambda x: 1 if x == 1 else 0)
data['SecondClass'] = data['Pclass'].apply(lambda x: 1 if x == 2 else 0)

x_data = data[['Sex', 'Age', 'FirstClass', 'SecondClass']]
y_data = data['Survived']

# 데이터셋 분리 작업
x_train, x_test, y_train, y_test = \
    train_test_split(x_data, y_data)

# 정규화
scaler = StandardScaler()
# fit_transform(): fit과 transform 함께 해줌
x_train = scaler.fit_transform(x_train)

# fit_transform 함수를 사용하여 이미 한 번 fit했으므로 두 번째 문장에서는
# transform 함수만 호출하면 됨
x_test = scaler.transform(x_test)

# 모델 생성하기
model = LogisticRegression()
model.fit(x_train, y_train)

# 주의 : 상관 분석은 인과  관계가 아니라 연관성과 관련 있음

# coef_는 w 값을 의미
# 회귀 분석에서 w의 의미는 y에 데이터 대한 인과 관계의 정도를 의미
# 성별과 일등석 탑승 여부가 생사를 판단하는 데 가장 영향력을 많이 준다고 볼수 있음
print(model.coef_)
print('-'*30)

print(model.intercept_)
print('-'*30)

# 샘플 데이터 예측하기
# ['Sex', 'Age', 'FirstClass', 'SecondClass']
soo = np.array([0.0, 20.0, 0.0, 0.0])
hee = np.array([1.0, 17.0, 1.0, 0.0])
minho = np.array([0.0, 32.0, 1.0, 0.0])
sample = np.array([soo, hee, minho])
print(sample)

sample = scaler.transform(sample)
print(sample)

print(model.predict(sample))

# predict_proba(): 확률값 ndarray로 리턴 (1과 0의 경우 모두 확률값 출력)
print(model.predict_proba(sample))

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

filename = 'logisticRegression02_01.png'
plt.savefig(filename)
print(filename + ' 파일 저장됨')


