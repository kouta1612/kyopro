MOD = 10**9+7

N, K = map(int, input().split())
a = list(map(int, input().split()))

dp = [[0] * (K+1) for _ in range(N+1)]
for i in range(N+1): dp[i][0] = 1

for i in range(1, N+1):
    prefix = [0] * (K+2)
    for j in range(1, K+2): prefix[j] = prefix[j-1] + dp[i-1][j-1]
    for j in range(K+1):
        dp[i][j] = prefix[j+1] - prefix[max(0, j-a[i-1])]
        dp[i][j] %= MOD
print(dp[N][K])