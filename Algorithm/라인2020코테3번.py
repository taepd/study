n1 = 73425
n2 = 10007
n3 = 9


def solution(n):
    answer = []
    while n//10 >= 10:
        n_len = len(str(n))
        print(n_len)
        n1 = str(n)[:n_len//2]
        n2 = str(n)[n_len//2:]
        print(n1)
        print(n2)
        break

    return answer


print(solution(n1))
# print(solution(n2))
# print(solution(n3))
