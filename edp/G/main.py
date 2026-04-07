from collections import defaultdict
import sys
sys.setrecursionlimit(100000)

n, m = map(int, input().split())
graph = defaultdict(list)
for i in range(m):
    x, y = map(int, input().split())
    graph[x-1].append(y-1)

dp = [-1] * n

def dfs(u: int) -> int:
    if dp[u] != -1: return dp[u]

    res = 0
    for v in graph[u]:
        res = max(res, dfs(v) + 1)
    
    dp[u] = res
    return dp[u]

res = 0
for u in range(n):
    res = max(res, dfs(u))

print(res)