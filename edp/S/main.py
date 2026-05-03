MOD = 10**9+7

K, D = input(), int(input())

N = len(K)
dp = [[[0] * 2 for _ in range(D)] for _ in range(N+1)]
dp[0][0][0] = 1

for i in range(N):
    for j in range(D):
        for k in range(2):
            if dp[i][j][k] == 0: continue
            
            digit = int(K[i])
            limit = digit if k == 0 else 9
            for x in range(limit+1):
                nj, nk = (j+x)%D, k == 1 or digit != x
                dp[i+1][nj][nk] += dp[i][j][k]
                dp[i+1][nj][nk] %= MOD

print((dp[N][0][0] + dp[N][0][1] - 1)%MOD)