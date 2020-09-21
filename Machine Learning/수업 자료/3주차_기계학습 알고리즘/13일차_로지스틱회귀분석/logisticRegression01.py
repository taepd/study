# logisticRegression01.py
# 카페 https://cafe.naver.com/ugcadman/1113  아이리스 데이터셋
import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import confusion_matrix
from sklearn.metrics import accuracy_score
from sklearn.metrics import classification_report
import matplotlib.pyplot as plt
import seaborn as sns

plt.rc('font', family='Malgun Gothic')

filename = '../첨부(3주차)/로지스틱_실습파일/iris.csv'
data = pd.read_csv(filename, header=0)

print(data.shape)
print('-'*30)

print(data.columns)
print('-'*30)
"""
csv 파일을 이용하여 데이터를 불러옴
학습용 데이터와 훈련용 데이터를 7:3으로 나눔
데이터 속성들의 값의 차이가 너무 크면 학습이 잘 안됨 따라서 정규화 필요
데이터를 정규화: StandardScaler 클래스를 사용하여 평균 0, 표준 편차 1인
표준 정규 분포로 표준화를 수행 
confusion matrix 및 각 지표에 대하여 확인
HeatMap을 그려 봄
"""
# 파일의 컬럼명을 이용해서 data 호출
x_data = data[['SepalLength', 'SepalWidth', 'PetalLength', 'PetalWidth']]
y_data = data['Name']

# 총 150행 중에서 훈련 105행, 테스트 45행

x_train, x_test, y_train, y_test = \
    train_test_split(x_data, y_data, test_size=0.3)

# 데이터 정규화
scaler = StandardScaler()
# fit은 한 번만 해주면 된다. 모수를 추출하여 분석하는 용도
x_train = scaler.fit_transform(x_train)
x_test = scaler.transform(x_test)

# 모델 객체 생성
model = LogisticRegression()
model.fit(x_train, y_train)

# score(): 결정계수 'R-squared'를 계산해주는 함수
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

filename = 'logisticRegression01_01.png'
plt.savefig(filename)
print(filename + ' 파일 저장됨')



print('finished')
