n = int(input())
a = [list(map(int, input().split())) for _ in range(n)]

score = [0] * (1<<n)
for s in range(1<<n):
    for i in range(n):
        if not s>>i&1: continue
        for j in range(i+1, n):
            if s>>j&1: score[s] += a[i][j]

dp = [0] * (1<<n)
for s in range(1<<n):
    t = s
    while t > 0:
        dp[s] = max(dp[s], dp[s^t] + score[t])
        t = (t-1) & s

print(dp[(1<<n)-1])