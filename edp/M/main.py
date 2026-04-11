MOD = 10**9+7

n, K = map(int, input().split())
a = list(map(int, input().split()))

dp = [0] * (K+1)
dp[0] = 1

for i in range(1, n+1):
    prefix = [0] * (K+2)
    for j in range(1, K+2): prefix[j] = prefix[j-1] + dp[j-1]

    next_dp = [0] * (K+1)
    for j in range(K+1): 
        left = prefix[j-a[i-1]] if j-a[i-1] >= 0 else 0
        next_dp[j] += prefix[j+1] - left
        next_dp[j] %= MOD
    dp = next_dp
print(dp[K])