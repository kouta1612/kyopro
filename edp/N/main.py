n = int(input())
a = list(map(int, input().split()))
sum = [0] * (n+1)
for i in range(1, n+1): sum[i] = sum[i-1] + a[i-1]

dp = [[0] * n for _ in range(n)]
for length in range(2, n+1):
    for l in range(n - length + 1):
        r = l + length - 1
        res = float('inf')
        for k in range(l, r):
            res = min(res, dp[l][k] + dp[k+1][r])
        dp[l][r] = res + sum[r+1] - sum[l]
print(dp[0][n-1])