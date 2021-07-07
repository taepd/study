import sys

input = sys.stdin.readline

n = int(input())

dp = []
for __ in range(n):
    dp.append(list(map(int, input().split())))

for i in range(1, n):
    for j in range(i+1):
        if j == 0:
            dp[i][j] += dp[i-1][j]
        elif j == i:
            dp[i][j] += dp[i-1][i-1]
        else:
            dp[i][j] += max(dp[i-1][j-1], dp[i-1][j])

print(max(dp[n-1]))



