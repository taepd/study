from itertools import product

n, m = map(int, input().split())

for e in product([i for i in range(1, n+1)], repeat=m):
    print(*e)