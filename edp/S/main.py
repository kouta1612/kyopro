MOD = 10**9+7

K = input()
d = int(input())
n = len(K)

dp = [[[0] * 2 for _ in range(d)] for _ in range(n+1)]
dp[0][0][0] = 1
for i in range(n):
    for j in range(d):
        for k in range(2):
            nd = int(K[i])
            limit = 9 if k == 1 else nd
            for l in range(limit+1):
                nj = (j + l) % d
                nk = k == 1 or nd > l
                dp[i+1][nj][nk] += dp[i][j][k]
                dp[i+1][nj][nk] %= MOD
print((dp[n][0][0] + dp[n][0][1] - 1)%MOD)