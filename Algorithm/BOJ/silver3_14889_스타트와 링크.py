from itertools import combinations

n = int(input())
arr = [list(map(int, input().split())) for __ in range(n)]

combo = combinations(, n//2)

print(combo)