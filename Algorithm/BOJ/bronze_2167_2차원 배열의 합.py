"""

시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	15590	9054	7166	60.082%
문제
2차원 배열이 주어졌을 때 (i, j) 위치부터 (x, y) 위치까지에 저장되어 있는 수들의 합을 구하는 프로그램을 작성하시오. 배열의 (i, j) 위치는 i행 j열을 나타낸다.

입력
첫째 줄에 배열의 크기 N, M(1 ≤ N, M ≤ 300)이 주어진다. 다음 N개의 줄에는 M개의 정수로 배열이 주어진다. 배열에 포함되어 있는 수는 절댓값이 10,000보다 작거나 같은 정수이다. 그 다음 줄에는 합을 구할 부분의 개수 K(1 ≤ K ≤ 10,000)가 주어진다. 다음 K개의 줄에는 네 개의 정수로 i, j, x, y가 주어진다(i ≤ x, j ≤ y).

출력
K개의 줄에 순서대로 배열의 합을 출력한다. 배열의 합은 231-1보다 작거나 같다.

예제 입력 1
2 3
1 2 4
8 16 32
3
1 1 2 3
1 2 1 2
1 3 2 3
예제 출력 1
63
2
36
"""

"""
dp를 이용한 풀이 1행과 1열도 dp값을 계산하기 위해 dp배열을 (n+1) * (m+1)로 해줘야 함
"""

import sys
input = sys.stdin.readline


# n, m = map(int, input().split())
# arr = [0 for i in range(n)]
# for i in range(n):
#     arr[i]=list(map(int, input().split()))
# dp = [[0]*(m+1) for _ in range(n+1)]
# for i in range(1, n+1):
#     for j in range(1, m+1):
#         dp[i][j] = arr[i-1][j-1] + dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1]
#
# for _ in range(int(input())):
#     i, j, x, y = map(int, input().split())
#     print(dp[x][y] - dp[i-1][y] - dp[x][j-1] + dp[i-1][j-1])

"""
가로 방향으로 누적값을 기록한 dp를 배열에 직접 기록하여 합을 구하는 전략
"""

import sys
input = sys.stdin.readline

N, M = map(int, input().split())
ss = [[0] for _ in range(N)]
for i in range(N):
    s = 0
    r = input().split()
    for j in range(M):
        s += int(r[j])
        ss[i].append(s)
print(ss)
for _ in range(int(input())):
    a, b, c, d = map(int, input().split())
    s = 0
    for i in range(a-1, c):
        s += (ss[i][d]-ss[i][b-1])
    print(s)
