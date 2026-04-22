n = int(input())
a = [list(map(int, input().split())) for _ in range(n)]

score = [0] * (1<<n)
for s in range(1<<n):
    for i in range(n):
        if not s>>i&1: continue
        for j in range(i+1, n):
            if not s>>j&1: continue
            score[s] += a[i][j]

dp = [0] * (1<<n)
for s in range(1<<n):
    t = s
    while True:
        dp[s] = max(dp[s], score[t] + dp[s^t])
        t = (t-1)&s
        if t == 0: break
print(dp[(1<<n)-1])