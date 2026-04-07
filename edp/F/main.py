s, t = input(), input()
ns, nt = len(s), len(t)

dp = [[0] * (nt+1) for _ in range(ns+1)]
for i in range(1, ns+1):
    for j in range(1, nt+1):
        if s[i-1] == t[j-1]: dp[i][j] = dp[i-1][j-1] + 1
        else: dp[i][j] = max(dp[i-1][j], dp[i][j-1])
res = []
i, j = ns, nt
while i > 0 and j > 0:
    if s[i-1] == t[j-1]:
        i -= 1
        j -= 1
        res.append(s[i])
    elif dp[i-1][j] > dp[i][j-1]: i -= 1
    else: j -= 1
print("".join(res[::-1]))