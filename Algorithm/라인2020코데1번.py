boxes = [[1, 2], [2, 1], [3, 3], [4, 5], [5, 6], [7, 8]]


def solution(boxes):
    list_x = [item[0] for item in boxes]
    list_y = [item[1] for item in boxes]
    for item in list_x:
        if item in list_y:
            list_y.remove(item)
    answer = len(list_y)

    return answer


print(solution(boxes))