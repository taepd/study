# jsonTest02.py
# 첨부 파일 some.json을 이용하여 각 정보를 출력해보세요.

import json

# open()
filename = '../첨부(2주차)/some.json'
myfile = open(filename, 'r', encoding='utf-8')
print(myfile)

# read()
myfile = myfile.read()
print(myfile)

# loads()
jsonData = json.loads(myfile)
print(jsonData)

for key, values in jsonData.items():
    print(key)
    for key, values in values.items():
        print(key,":", values)








