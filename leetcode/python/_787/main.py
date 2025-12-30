from typing import List
from collections import defaultdict
from heapq import heappop, heappush

class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        graph = {i: [] for i in range(n)}
        for u, v, c in flights: graph[u].append((v, c))
        heap = [(0, src, 0)]
        visited = set()
        res = float('inf')
        while heap:
            cost, start, move = heappop(heap)
            if move > k + 1: continue
            if (start, move) in visited: continue
            if start == dst:
                res = min(res, cost)
                continue

            visited.add((start, move))
            for end, w in graph[start]:
                if (end, move + 1) in visited: continue
                heappush(heap, (cost + w, end, move + 1))
        return res if res != float('inf') else -1

print(Solution().findCheapestPrice(4, [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], 0, 3, 1))