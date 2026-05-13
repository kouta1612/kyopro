n = int(input())
p = list(map(int, input().split()))

dp = [False] * (10001)
dp[0] = True
for i in range(n):
    for j in range(10000, -1, -1):
        if j-p[i] < 0: continue
        if not dp[j-p[i]]: continue
        dp[j] = dp[j-p[i]]
res = 0
for i in range(10001):
    if dp[i]: res += 1
print(res)