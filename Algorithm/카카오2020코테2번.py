orders = ["XYZ", "XWY", "WXA"]
course = [2,3,4]

from itertools import combinations as cb

def solution(orders, course):
    answer = []

    for count in course:  # 각 코스 마다
        sum_combo = []  # 코스 별 전체 콤보 리스트
        for i, order in enumerate(orders):  # 각 오더 마다
            order = ''.join(sorted(order))  # 오더를 알파벳 순으로 정렬
            print(order)
            combo = list(cb(order, count))
            for j, c in enumerate(combo):
                combo[j] = ''.join(c)
            sum_combo += combo

        top_combo = 2  # 가장 많은 콤보 수
        _answer = []
        print(sum_combo)

        for combo in set(sum_combo):
            if sum_combo.count(combo) > top_combo:
                _answer = [combo]
                top_combo = sum_combo.count(combo)
            elif sum_combo.count(combo) == top_combo:
                _answer.append(combo)
        answer += _answer
        answer.sort()

    return answer


print(solution(orders, course))
