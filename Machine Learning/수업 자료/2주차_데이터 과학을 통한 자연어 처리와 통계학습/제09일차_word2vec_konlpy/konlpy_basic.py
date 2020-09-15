# konlpy_basic
from konlpy.tag import Komoran


text = '세일즈 우먼인 아름다운 그녀가 아버지 가방에 들어 가시나 ㅎㅎ'

komo = Komoran()  # Komoran 인스턴스 생성
print(type(komo))

# pos : 단어와 품사를 튜플로 만들어서 리스트 형태로 반환
# POS(Part of Speach) Tagging
# 토큰으로 구분된 단어를 품사로 매칭되는 구조로 구분하고, 이를 기반으로 개체의 의미로 구분하는 과정으로 가리킴
result = komo.pos(text)
print(result)

# 형태소 : 의미있는 최소의 단위
# 텍스트 마이닝 : 수많은 텍스트에서 의미있는 데이터만 추려내는 행위

print('전체 확인하기')
for my_item in result:
    some_data = f'단어 : {my_item[0]}, 품사: {my_item[1]}'
    print(some_data)
print('-'*30)

print('3글자 이상의 명사만 추출해보기')
only_nouns = []

for my_item in result:
    if my_item[1] in ['NNG', 'NNP']:
        if len(my_item[0]) >= 3:
            some_data = f'단어 : {my_item[0]}, 품사: {my_item[1]}'
            only_nouns.append(my_item[0])
        else:
            print(f'{my_item[0]}은(는) 제외합니다.')

print(only_nouns)
#############################################
print('명사만 추출해보기')
nouns = komo.nouns(text)
print(nouns)
#############################################
# userdic 매개 변수: 사용자 정의 사전을 활용하는 방법
sentence = '국정 농단 태블릿 PC, 최순실, 가나다라'
komo = Komoran(userdic='../첨부(2주차)/user_dic.txt')
print(komo.pos(sentence))


print('finished')
