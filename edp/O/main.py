MOD = 10**9+7

n = int(input())
a = [list(map(int, input().split())) for _ in range(n)]

dp = [0] * (1<<n)
dp[0] = 1
for mask in range(1<<n):
    i = bin(mask).count('1')
    for j in range(n):
        if mask>>j & 1: continue
        if a[i][j] == 0: continue
        dp[mask|1<<j] += dp[mask]
        dp[mask|1<<j] %= MOD
print(dp[(1<<n) - 1])