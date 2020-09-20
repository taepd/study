ball1 = [1, 2, 3, 4, 5, 6]
order1 = [6, 2, 5, 1, 4, 3]
ball2 = [11, 2, 9, 13, 24]
order2 = [9, 2, 13, 24, 11]

def solution(ball, order):
    answer = []

    while ball:
        for item in order:
            tmp = []
            if item == ball[0] or item == ball[-1]:
                ball.remove(item)
                answer.append(item)
                order.remove(item)
                break
            else:
                if item not in tmp:
                    tmp.append(item)
            order = tmp + order

    return answer


print(solution(ball1, order1))
print(solution(ball2, order2))