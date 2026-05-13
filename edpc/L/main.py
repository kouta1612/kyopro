n = int(input())
a = list(map(int, input().split()))

dp = [[0] * n for _ in range(n)]
for i in range(n): dp[i][i] = a[i]
for length in range(2, n+1):
    for l in range(n-length+1):
        r = l + length - 1
        dp[l][r] = max(-dp[l+1][r] + a[l], -dp[l][r-1] + a[r])
print(dp[0][n-1])