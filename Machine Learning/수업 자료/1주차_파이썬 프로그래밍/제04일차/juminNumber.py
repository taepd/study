# 주민번호는 반드시 14자리이어야 함
# 6번째 항목은 반드시 '-'이어야 함
# 2번째 항목은 '0'또는 '1'이어야 함

def findSsn(juminNo):
    if len(juminNo) != 14:
        return False
    if juminNo[6] != '-':
        return  False
    if juminNo[2] not in ['0','1']:
        return False
    if juminNo[7] not in ['0', '1', '2', '3']:
        return False
    if not(juminNo[0:6].isdigit() and (juminNo[7:]).isdigit()):
        return False

    return True
juminList = ['701226-1710566', '7012261710566', '703266-1710566', '701226-5710566' ]

for juminNo in juminList:
    result = findSsn(juminNo)
    if result == True:
        print('{}는 올바른 주민 번호'.format(juminNo))
    else:
        print('{}는 잘못된 주민 번호'.format(juminNo))
print('-'*30)

