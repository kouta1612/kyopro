from typing import List
from collections import defaultdict
from heapq import heappop, heappush

class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        graph = defaultdict(list)
        for u, v, c in flights: graph[u].append((v, c))

        dist = [[float('inf')] * (k + 2) for _ in range(n)]
        dist[src][k+1] = 0

        heap = [(0, src, k+1)]
        while heap:
            cost, u, rem = heappop(heap)
            if u == dst: return cost
            if dist[u][rem] < cost: continue
            if rem == 0: continue
            for v, c in graph[u]:
                if cost+c >= dist[v][rem-1]: continue
                dist[v][rem-1] = cost+c
                heappush(heap, (cost+c, v, rem-1))
        return -1

print(Solution().findCheapestPrice(4, [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], 0, 3, 1))