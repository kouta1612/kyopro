A, B = map(int, input().split())
a = list(map(int, input().split()))
b = list(map(int, input().split()))

dp = [[0] * (B+1) for _ in range(A+1)]
for i in range(A, -1, -1):
    for j in range(B, -1, -1):
        if i == A and j == B: continue
        res = -10**9
        if i+1 <= A: res = max(res, a[i] - dp[i+1][j])
        if j+1 <= B: res = max(res, b[j] - dp[i][j+1])
        dp[i][j] = res

total = sum(a) + sum(b)
print((total+dp[0][0])//2)