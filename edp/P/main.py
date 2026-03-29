from collections import defaultdict
import sys

sys.setrecursionlimit(10**7)

MOD = 10**9 + 7

n = int(input())
graph = defaultdict(list)
for i in range(n-1):
    x, y = map(int, input().split())
    x, y = x-1, y-1
    graph[x].append(y)
    graph[y].append(x)

dp = [[1,1] for _ in range(n)]

def dfs(v, par: int):
    white, black = 1, 1
    for nv in graph[v]:
        if nv == par: continue
        dfs(nv, v)
        white *= (dp[nv][0] + dp[nv][1])
        white %= MOD
        black *= dp[nv][0]
        black %= MOD
    dp[v][0], dp[v][1] = white, black

dfs(0, -1)
print((dp[0][0] + dp[0][1]) % MOD)