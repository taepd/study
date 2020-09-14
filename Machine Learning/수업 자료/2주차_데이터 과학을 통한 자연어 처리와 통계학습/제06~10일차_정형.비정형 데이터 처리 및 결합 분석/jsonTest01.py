# jsonTest.py
import json

data = {'age': 30, 'name': '홍길동', 'address': '강남구 역삼동', 'broadcast': {'mbc': 11, 'kbs': 0, 'sbs': 6}}
print(type(data))
# dumps() : 데이터를 읽어서 str 형태로 변환 함수
json_str = json.dumps(data, ensure_ascii=False, indent=4, sort_keys=True)

print(json_str)
print(type(json_str)) # <class 'str'>

# loads() : str을 dict로 바꿔주는 함수
json_data = json.loads(json_str)

print(json_data)
print(type(json_data)) # <class 'dict'>
print('-'*30)

print(json_data['name'])
print(json_data['age'])

