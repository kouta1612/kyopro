n, k = map(int, input().split())
a = list(map(int, input().split()))

dp = [False] * (k+1)
for i in range(k+1):
    for j in range(n):
        if i-a[j] < 0: continue
        if dp[i-a[j]]: continue
        dp[i] = True
        break
print("First" if dp[k] else "Second")