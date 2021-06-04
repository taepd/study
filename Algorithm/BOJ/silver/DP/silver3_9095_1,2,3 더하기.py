"""
https://yongku.tistory.com/entry/%EB%B0%B1%EC%A4%80-9095%EB%B2%88-1-2-3-%EB%8D%94%ED%95%98%EA%B8%B0-%ED%8C%8C%EC%9D%B4%EC%8D%ACPython
규칙을 찾은 다음 이를 바탕으로 DP

이 문제는 DP(Dynamic Programming) 문제이다.

이 문제를 풀 때 DP 접근을 위해 패턴이나 규칙을 찾기 위해 경우의 수를 풀어서 썼다.



1 -> (1) -> 1개

2 -> (1+1), (2) -> 2개

3 -> (1+1+1), (1+2), (2+1), (3) -> 4개

4 -> (1+1+1+1), (1+1+2), (1+2+1), (1+3), (2+1+1), (2+2), (3+1) -> 7개

5 -> (1+1+1+1+1), (1+1+1+2), (1+1+2+1), (1+1+3), (1+2+1+1), (2+1+1+1), (1+2+2), (2+1+2), (2+2+1), (1+3+1), (3+1+1), (2+3), (3+2) -> 13개



위의 규칙을 봤을 때, 4번째 경우의 수는 첫 번째와 두 번째, 세 번째 경우의 수를 합한 것과 같다는 것.

5번째 경우의 수는 2, 3, 4번째 경우의 수의 합과 같다는 것을 볼 수 있다.



따라서, 위의 규칙을 보면 하나의 점화식이 나온다.

n이 3보다 클 때(n>3), f(n) = f(n-1) + f(n-2) + f(n-3)
"""
n = int(input())

dp = [0] * 12
dp[1], dp[2], dp[3] = 1, 2, 4
for i in range(4, 12):
    dp[i] = dp[i-1] + dp[i-2] + dp[i-3]

for _ in range(n):
    k = int(input())
    print(dp[k])
