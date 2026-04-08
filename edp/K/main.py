n, k = map(int, input().split())
a = list(map(int, input().split()))

dp = [False] * (k+1)
for x in range(1, k+1):
    for v in a:
        if x-v >= 0 and dp[x-v] == False:
            dp[x] = True
            break
print("First" if dp[k] else "Second")