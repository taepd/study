import sys

input = sys.stdin.readline

n = int(input())

class_arr = list(map(int, input().split()))

m, s = map(int, input().split())

ans = 0
for i in range(n):
    class_arr[i] -= m
    ans += 1
    if class_arr[i] > 0:
        ans += (class_arr[i]+1)//(s-1)
print(ans)
