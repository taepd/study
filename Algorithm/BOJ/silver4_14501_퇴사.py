
n = int(input())

arr = []
for __ in range(n):
    d, p = map(int, input().split())
    arr.append([d, p])

dp = [0] * 20
for i in range(len(arr)):
    d, p = arr[i]
    dp[i+d] = max(dp[i+d], p+max(dp[:i+1]))

print(max(dp[:n+1]))


# 역산하는 방법
n=int(input())
t=[]
p=[]
for i in range(n):
    T,P=map(int,input().split())
    t.append(T)
    p.append(P)

dp=[0]* (n+1)

for j in range(n-1,-1,-1):

    if t[j]+j>n:
        dp[j]=dp[j+1]
    else:
        dp[j]=max(dp[j+1],p[j]+dp[j+(t[j])])
print(dp[0])