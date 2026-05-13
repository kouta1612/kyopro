import sys
sys.setrecursionlimit(100000)

n = int(input())
a = list(map(int, input().split()))

rem = [0] * 4
for i in range(n): rem[a[i]] += 1
dp = [[[-1] * 301 for _ in range(301)] for _ in range(301)]
dp[0][0][0] = 0

def dfs(i, j, k: int) -> float:
    if dp[i][j][k] != -1: return dp[i][j][k]
    res = n
    if i > 0: res += i * dfs(i-1, j, k)
    if j > 0: res += j * dfs(i+1, j-1, k)
    if k > 0: res += k * dfs(i, j+1, k-1)
    dp[i][j][k] = res / (i+j+k)
    return dp[i][j][k]

print(dfs(rem[1], rem[2], rem[3]))