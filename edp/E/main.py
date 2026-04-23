INF = 10**18

N, W = map(int, input().split())
w, v = [0] * N, [0] * N
for i in range(N):
    w[i], v[i] = map(int, input().split())
SUM_V = sum(v)

dp = [[INF] * (SUM_V + 1) for _ in range(N+1)]
dp[0][0] = 0
for i in range(1, N+1):
    for j in range(SUM_V+1):
        dp[i][j] = dp[i-1][j]
        if j-v[i-1] >= 0:
            dp[i][j] = min(dp[i][j], dp[i-1][j-v[i-1]] + w[i-1])
res = 0
for i in range(SUM_V+1):
    if dp[N][i] <= W: res = max(res, i)
print(res)