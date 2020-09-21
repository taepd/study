# tfidf_preprocessing.py
# data_in 폴더의 csv 파일 활용

import pandas as pd
from sklearn.feature_extraction.text import TfidfVectorizer
import numpy as np
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LogisticRegression
import os

DATA_IN_PATH = '../첨부(3주차)/data_in/'
TRAIN_CLEAN_DATA = 'train_clean.csv'

train_data = pd.read_csv(DATA_IN_PATH + TRAIN_CLEAN_DATA)
print(train_data.info())
print('-'*30)

print(train_data.columns)
print('-'*30)
#
print(train_data['sentiment'].unique())
print('-'*30)

myseries = train_data.groupby(by=['sentiment'], as_index=False)['sentiment']
print(type(myseries))  # <class 'pandas.core.groupby.generic.DataFrameGroupBy'>
result = myseries.count()
print(type(result))  # <class 'pandas.core.frame.DataFrame'>
print(result)

# 위 count()와 동일한 결과 출력
myseries1 = train_data.groupby('sentiment').size()
print(type(myseries1))  # <class 'pandas.core.series.Series'>
print(myseries1)

# 리뷰와 정답 데이터를 리스트화
reviews = list(train_data['review'])
sentiments = list(train_data['sentiment'])

# analyzer: word/char
# max_features: 최대 길이
# ngram_range(n, m): n개 부터 m까지의 단어묶음을 하나로 취급
vectorizer = TfidfVectorizer(min_df=0.0, analyzer='char',
                             max_features=5000, ngram_range=(1, 3))

# vectorizer.fit_transform(reviews)
# vectorizer.fit()을 통해 학습하여 생성된 단어사전을 transform 한다
# (0, 2438)	0.00536795359202064 형태로 변환
# 해석: 0번째 행에 단어사전 key가 2438인 요소의 문장 내 가중치가 0.00536... 이라는 것
x = vectorizer.fit_transform(reviews)  
y = np.array(sentiments)
print('타입 x:', type(x))
# print('x :\n', x)
# print('-'*30)

features = vectorizer.get_feature_names()
print('토큰 갯수: ', len(features))
print('토큰화된 단어 리스트: ', features)

x_train, x_test, y_train, y_test = \
    train_test_split(x, y, test_size=0.2, random_state=42)

model = LogisticRegression(class_weight='balanced')

model.fit(x_train, y_train)

predicted = model.predict(x_test)

print(f'정확도: {model.score(x_test, y_test): .4f}')

TEST_CLEAN_DATA = 'test_clean.csv'

test_data = pd.read_csv(DATA_IN_PATH + TEST_CLEAN_DATA)
test_data_vec = vectorizer.transform(test_data['review'])

test_predicted = model.predict(test_data_vec)
print('test_predicted: ', test_predicted)

DATA_OUT_PATH = './data_out/'
if not os.path.exists(DATA_OUT_PATH):
    os.makedirs(DATA_OUT_PATH)

myframe = pd.DataFrame({'id': test_data['id'], 'sentiment': test_predicted})
saved_file_name = 'model_tfidf_answer.csv'
# quoting = 3은 큰따옴표를 무시
myframe.to_csv(DATA_OUT_PATH + saved_file_name, index=False, quoting=3)
print('finished')

