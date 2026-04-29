INF = 10**18

n = int(input())
a = list(map(int, input().split()))

dp = [[INF] * n for _ in range(n)]
for i in range(n): dp[i][i] = 0

prefix = [0] * (n+1)
for i in range(n): prefix[i + 1] = prefix[i] + a[i]

for length in range(2, n+1):
    for l in range(n-length+1):
        r = l + length - 1
        for x in range(l, r):
            dp[l][r] = min(dp[l][r], dp[l][x] + dp[x+1][r] + prefix[r+1] - prefix[l])
print(dp[0][n-1])