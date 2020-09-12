info = ["java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"]
query = ["java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"]

import re

def solution(info, query):
    answer = []

    # info 요소 문자열을 리스트로 변환
    for i, str in enumerate(info):
        info[i] = str.split(' ')
    for one_query in query:
        one_query = one_query.replace('and', '').replace('  ',' ').split()
        _answer = 0
        for one_info in info:
            count = 0  # 조건에 부합하는 수
            for i in range(len(one_query)-1):
                if one_info[i] == one_query[i] or one_query[i] == '-':
                    count += 1
            if int(one_info[-1]) >= int(one_query[-1]):
                count += 1
            if count == 5:
                _answer += 1
        answer.append(_answer)

    return answer

print(solution(info, query))
