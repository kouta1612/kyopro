from typing import List
from collections import defaultdict
from heapq import heappop, heappush

class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        graph = defaultdict(list)
        for s, t, w in flights: graph[s].append((t, w))
        best = defaultdict(lambda: defaultdict(lambda: float('inf')))
        best[src][k + 1] = 0
        heap = [(0, src, k + 1)]
        while heap:
            cost, s, remain = heappop(heap)
            if s == dst: return cost
            if remain == 0: continue
            for to, w in graph[s]:
                if cost + w < best[to][remain - 1]:
                    best[to][remain - 1] = cost + w
                    heappush(heap, (best[to][remain - 1], to, remain - 1))
        return -1

print(Solution().findCheapestPrice(4, [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], 0, 3, 1))