n, W = map(int, input().split())
w, v = [], []
for i in range(n):
    in1, in2 = map(int, input().split())
    w.append(in1)
    v.append(in2)

dp = [[float('inf')] * 100001 for _ in range(n+1)]
dp[0][0] = 0
for i in range(1, n+1):
    for j in range(100001):
        dp[i][j] = dp[i-1][j]
        if j-v[i-1] < 0: continue
        dp[i][j] = min(dp[i][j], dp[i-1][j-v[i-1]] + w[i-1])
res = 0
for i in range(100001):
    if dp[n][i] > W: continue
    res = max(res, i)
print(res)