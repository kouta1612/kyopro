MOD = 10**9+7

N, K = map(int, input().split())
a = list(map(int, input().split()))

dp = [[0] * (K+1) for _ in range(N+1)]
dp[0][0] = 1

for i in range(1, N+1):
    prefix = [0] * (K+2)
    for j in range(K+1): prefix[j+1] = prefix[j] + dp[i-1][j]
    for j in range(K+1):
        left = prefix[j-a[i-1]] if j-a[i-1] >= 0 else 0
        dp[i][j] = prefix[j+1]-left
        dp[i][j] %= MOD
print(dp[N][K])