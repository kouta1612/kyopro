MOD = 10**9+7

n = int(input())
a = [list(map(int, input().split())) for _ in range(n)]

dp = [0] * (1<<n)
dp[0] = 1
for s in range(0, 1<<n):
    i = bin(s).count('1')
    for j in range(n):
        if (not s>>j&1) and a[i][j]:
            dp[s|(1<<j)] += dp[s]
            dp[s|(1<<j)] %= MOD
print(dp[(1<<n)-1])