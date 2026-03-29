MOD = 10**9 + 7

n = int(input())
a = [list(map(int, input().split())) for _ in range(n)]
dp = [0] * (1<<n)
dp[0] = 1
for s in range(1<<n):
    i = bin(s).count("1")
    if i >= n: continue

    for j in range(n):
        if s & 1<<j: continue
        if a[i][j] == 0: continue
        dp[s|1<<j] += dp[s]
        dp[s|1<<j] %= MOD
print(dp[(1<<n)-1])