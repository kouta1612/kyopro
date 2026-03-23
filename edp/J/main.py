from collections import Counter

n = int(input())
a = list(map(int, input().split()))
dp = [[[-1.0 for _ in range(n+1)] for _ in range(n+1)] for _ in range(n+1)]

def dfs(i, j, k: int) -> float:
    if i < 0 or j < 0 or k < 0: return 0
    if i == 0 and j == 0 and k == 0: return 0
    if dp[i][j][k] != -1.0: return dp[i][j][k]

    res = float(n)
    res += dfs(i-1, j, k) * i
    res += dfs(i+1, j-1, k) * j
    res += dfs(i, j+1, k-1) * k
    res /= i+j+k

    dp[i][j][k] = res
    return res

cnt = Counter(a)
print(dfs(cnt[1], cnt[2], cnt[3]))