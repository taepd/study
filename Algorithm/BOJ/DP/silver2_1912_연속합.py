import sys

input = sys.stdin.readline

n = int(input())

arr = list(map(int, input().split()))

for i in range(1, len(arr)):
    arr[i] = max(arr[i] + arr[i-1], arr[i])

print(max(arr))