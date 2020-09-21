# CountVectorizer01.py
from sklearn.feature_extraction.text import  CountVectorizer

# CountVectorizer: 문자열에서 단어 토큰을 생성하여 BOW로 인코딩된 벡터를 생성해 줌
# df(document frequency)
# min_df=2 : 최소 빈도가 2번 이상인 단어만 사전에 등록(문장 당 1회로 계산. 한 문장에서 여러 번 나와도 빈도 1 누적)

vectorizer = CountVectorizer(min_df=2, stop_words=['친구'])
print(type(vectorizer))

sentences = ['우리 아버지 여자 친구 이름은 홍길동 홍길동', '홍길동 여자 친구 이름은 심순애 심순애', '여자 친구 있나요.']

# 단어 사전
mat = vectorizer.fit(sentences)
print(type(mat))

print(mat.vocabulary_)  # 알파벳 순으로 index가 붙는다

print(sorted(mat.vocabulary_.items()))

# 토큰
features = vectorizer.get_feature_names()
print(type(features))
print(features)

print('불용어')
print(vectorizer.get_stop_words())

sentence = [sentences[0]]
print('sentence: ', sentence)

myarray = vectorizer.transform(sentence).toarray()
print(type(myarray))
print('myarray: ', myarray)

"""
sentence: ['우리 아버지 여자 친구 이름은 홍길동 홍길동']
단어 사전: {'여자': 0, '이름은': 1, '홍길동': 2}
myarray: [[1 1 2]] 
-> sentence에 단어 사전의 토큰 중 '여자' 1번, '이름은' 1번, '홍길동' 2번 
포함되어 있다는 것을 ndarray로 리턴 
"""


print('finished')
