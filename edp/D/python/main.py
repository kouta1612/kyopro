n, w = list(map(int, input().split()))
ws, vs = [], []
for i in range(n):
    inputs = list(map(int, input().split()))
    ws.append(inputs[0])
    vs.append(inputs[1])
dp = [[0] * (w+1) for _ in range(n)]
for i in range(n):
    for j in range(w+1):
        dp[i][j] = dp[i-1][j]
        if j-ws[i-1] < 0: continue
        dp[i][j] = max(dp[i][j], dp[i-1][j-ws[i-1]] + vs[i-1])
print(dp[n-1][w])