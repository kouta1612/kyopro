n, k = map(int, input().split())
a = list(map(int, input().split()))
dp = [False] * (k+1)
for i in range(1, k+1):
    for j in a:
        if i-j >= 0 and not dp[i-j]:
            dp[i] = True
            break
print("First" if dp[k] else "Second")