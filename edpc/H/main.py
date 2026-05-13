h, w = map(int, input().split())
grid = []
MOD = 10**9 + 7
for _ in range(h):
    row = input()
    grid.append(row)
dp = [[0] * w for _ in range(h)]
dp[0][0] = 1
for i in range(1, h):
    if grid[i][0] == "#": continue
    dp[i][0] = dp[i-1][0]
for i in range(1, w):
    if grid[0][i] == "#": continue
    dp[0][i] = dp[0][i-1]
for i in range(1, h):
    for j in range(1, w):
        if grid[i][j] == "#": continue
        dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MOD
print(dp[h-1][w-1])
