n = int(input())
a = list(map(int, input().split()))

prefix = [0] * (n+1)
for i in range(n): prefix[i+1] = prefix[i] + a[i]

dp = [[0] * n for _ in range(n)]
for length in range(2, n+1):
    for l in range(n-length+1):
        r = l + length - 1
        dp[l][r] = float('inf')
        for k in range(l, r):
            dp[l][r] = min(dp[l][r], dp[l][k] + dp[k+1][r])
        dp[l][r] += prefix[r+1] - prefix[l]
print(dp[0][n-1])