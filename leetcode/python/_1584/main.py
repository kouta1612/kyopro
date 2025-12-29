from typing import List
from heapq import heappop, heappush
from math import abs

class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        n = len(points)
        visited = set()
        minCosts = [float('inf')] * n
        minCosts[0] = 0
        res = 0
        for _ in range(n):
            u = -1
            for i in range(n):
                if i in visited: continue
                if u == -1 or minCosts[u] > minCosts[i]: u = i
            visited.add(u)
            res += minCosts[u]
            for v in range(n):
                if v in visited: continue
                ux, uy = points[u]
                vx, vy = points[v]
                dist = abs(ux - vx) + abs(uy - vy)
                minCosts[v] = min(minCosts[v], dist)
        return res

print(Solution().minCostConnectPoints([[0,0],[2,2],[3,10],[5,2],[7,0]]))