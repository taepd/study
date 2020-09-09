# xmlEx03.py

from xml.etree.ElementTree import parse

# parse : xml 파싱 메소드
tree = parse('../첨부(2주차)/xmlEx_03.xml')
myroot = tree.getroot()
print(type(myroot))
print('-'*30)

# 속성들의 키를 list 형식으로 반환
print(myroot.keys())
print('-'*30)

#
print(myroot.items())
print('-'*30)

print(myroot.get('설명'))
print('-'*30)

print(myroot.get('qwert', '없을 경우 기본값'))
print('-'*30)

print(myroot.findall('가족'))
print('-'*30)

family = myroot.find('가족')
print(family)

# children = family.getchildren() # deprecated된 메서드
children = [item for item in family]
# print(children)

for person in children:
    # print(person)
    elem = [item for item in person]
    # print(elem)
    for abc in elem:
        print(abc.text)
        if abc.text == '이순자':
            print(abc.attrib['정보'])

print('-'*30)

allfamily = myroot.findall('가족')
for onefamily in allfamily:
    for member in onefamily:
        name = member.find('이름')
        # 하위 엘리먼트 대신 속성으로 기록된 경우 처리
        if name != None:
            print(name.text)
        else:
            print(member.attrib['이름'])

print('-'*30)


print('finished')

