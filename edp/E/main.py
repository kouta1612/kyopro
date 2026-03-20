n, w = list(map(int, input().split()))
ws, vs = [], []
MAX_V = 100000

for i in range(n):
    inputs = list(map(int, input().split()))
    ws.append(inputs[0])
    vs.append(inputs[1])
dp = [[float('inf')] * (MAX_V+1) for _ in range(n+1)]
dp[0][0] = 0
for i in range(1, n+1):
    for j in range(MAX_V+1):
        dp[i][j] = dp[i-1][j]
        if j-vs[i-1] < 0: continue
        dp[i][j] = min(dp[i][j], dp[i-1][j-vs[i-1]] + ws[i-1])
res = 0
for i in range(MAX_V+1):
    if dp[n][i] > w: continue
    res = max(res, i)
print(res)