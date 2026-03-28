MOD = 10**9+7

n, k = map(int, input().split())
a = list(map(int, input().split()))

dp = [[0] * (k+1) for _ in range(n+1)]
dp[0][0] = 1
for i in range(1, n+1):
    sum_dp = [0] * (k+2)
    for j in range(1, k+2):
        sum_dp[j] = (sum_dp[j-1] + dp[i-1][j-1]) % MOD
    for j in range(k+1):
        left = max(0, j-a[i-1])
        dp[i][j] = (sum_dp[j+1] - sum_dp[left]) % MOD
print(dp[n][k])