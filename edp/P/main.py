import sys
sys.setrecursionlimit(1000000)

MOD = 10**9+7

n = int(input())
graph = [[] for _ in range(n)]
for i in range(n-1):
    x, y = map(int, input().split())
    x, y = x-1, y-1
    graph[x].append(y)
    graph[y].append(x)

dp = [[-1] * 2 for _ in range(n)]

def dfs(u, c, p: int) -> int:
    if dp[u][c] != -1: return dp[u][c]
    res = 1
    for v in graph[u]:
        if v == p: continue
        if c == 0: res *= dfs(v, 1, u)
        else: res *= ((dfs(v, 0, u) + dfs(v, 1, u)) % MOD)
        res %= MOD
    dp[u][c] = res
    return res

print((dfs(0, 0, -1) + dfs(0, 1, -1)) % MOD)