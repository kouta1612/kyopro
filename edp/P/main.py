import sys
sys.setrecursionlimit(100000)

MOD = 10**9+7

n = int(input())

graph = [[] for _ in range(n)]
for i in range(n-1):
    x, y = map(int, input().split())
    x, y = x-1, y-1
    graph[x].append(y)
    graph[y].append(x)

dp = [[1] * 2 for _ in range(n)]

def dfs(u, p: int):
    for v in graph[u]:
        if v == p: continue
        dfs(v, u)

        dp[u][0] *= (dp[v][0] + dp[v][1])
        dp[u][0] %= MOD

        dp[u][1] *= dp[v][0]
        dp[u][1] %= MOD

dfs(0, -1)
print((dp[0][0] + dp[0][1]) % MOD)