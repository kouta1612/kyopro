from collections import defaultdict
import sys

sys.setrecursionlimit(10**7)

n, m = map(int, input().split())
graph = defaultdict(list)
for i in range(m):
    x, y = map(int, input().split())
    graph[x-1].append(y-1)

dp = [-1] * n

def dfs(i: int) -> int:
    if dp[i] != -1: return dp[i]
    res = 0
    for j in graph[i]:
        res = max(res, dfs(j) + 1)
    dp[i] = res
    return res

res = 0
for i in range(n):
    res = max(res, dfs(i))
print(res)