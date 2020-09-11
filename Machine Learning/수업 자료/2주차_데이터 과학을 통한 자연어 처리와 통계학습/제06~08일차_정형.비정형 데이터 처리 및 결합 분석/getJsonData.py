# getJsonData.py
# open > read > loads

import json


def get_Json_Data():
    print('함수 호출됨')
    filename = '../첨부(2주차)/jumsu.json'
    myfile = open(filename, 'rt', encoding='utf-8')
    print(type(myfile)) # <class '_io.TextIOWrapper'>

    # 그냥 json 파일을 텍스트로 읽기만 하면
    # TypeError: the JSON object must be str, bytes or bytearray, not TextIOWrapper
    # 에러가 발생

    # read()함수를 호출해서 str 타입으로 변경
    myfile = myfile.read()
    print(type(myfile)) # <class 'str'>

    # loads(str) : 문자열 형식의 데이터를 이용하여 json 타입으로 변환 함수수
    jsonData = json.loads(myfile)
    # json.loead()거치면 list안에 dict로 요소를 갖는 json 포맷으로 접근할 수 있다
    print(type(jsonData)) # <class 'list'>
    print(jsonData)
    print('-'*30)

    for oneitem in jsonData:
        print(oneitem.keys())
        print(oneitem.values())
        print('이름 :', oneitem['name'])

        kor = float(oneitem['kor'])
        eng = float(oneitem['eng'])
        math = float(oneitem['math'])

        total = kor + eng + math
        print('총점 :', total)

        if 'hello' in oneitem.keys():
            message = oneitem['hello']
            print('message :', message)

        # 임시 변수를 만들어서 gender를 모두 대문자로 일괄 처리
        _gender = oneitem['gender'].upper()

        if _gender == 'M':
            print('성별: 남자')
        elif _gender =='F':
            print('성별: 여자')
        else:
            print('미정')




# __name__ : 파이썬이 내장하고 있는 내부 변수
# 애플리케이션 이름이 저장되어 있음
# 해당 애플리케이션이 스스로 실행하면 '__main__' 값이 대입됩니다

if __name__ == '__main__':
    print('나 스스로 실행되었습니다.')
    get_Json_Data()
else:
    print('다른 프로그램이 호출했습니다.')