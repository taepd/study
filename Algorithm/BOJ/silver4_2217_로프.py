import sys

input = sys.stdin.readline

n = int(input())

arr = [int(input()) for __ in range(n)]
arr.sort()
l, mx = len(arr), 0
for i in range(l):
    tmp = min(arr[i:])*(l-i)
    if mx > tmp:
        break
    else:
        mx = tmp

print(mx)