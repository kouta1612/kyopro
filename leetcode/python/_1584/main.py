from typing import List
from heapq import heappop, heappush
from math import abs

class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        n = len(points)
        graph = [[0] * n for _ in range(n)]
        for i in range(n):
            x1, y1 = points[i]
            for j in range(i + 1, n):
                x2, y2 = points[j]
                dist = abs(x1 - x2) + abs(y1 - y2)
                graph[i][j] = graph[j][i] = dist
        visited = set()
        heap = [(0, 0)]
        res = 0
        while len(visited) < n:
            cost, i = heappop(heap)
            if i in visited: continue
            visited.add(i)
            res += cost
            for j in range(n):
                if i == j: continue
                if j in visited: continue
                heappush(heap, (graph[i][j], j))
        return res

print(Solution().minCostConnectPoints([[0,0],[2,2],[3,10],[5,2],[7,0]]))