l, m, n = map(int, input())

if l == m == n:
    ans = 10000 + l*1000
elif l != m and m != n and l != n:
    ans = max(l, m, n) * 100
else:
    pass

print(ans)