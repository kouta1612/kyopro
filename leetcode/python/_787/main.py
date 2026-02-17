from typing import List
from collections import defaultdict
from heapq import heappop, heappush

class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        INF = float('inf')
        dist = [INF] * n
        dist[src] = 0
        for _ in range(k+1):
            tmp = dist[:]
            for u, v, c in flights:
                if dist[u] == INF: continue
                tmp[v] = min(tmp[v], dist[u]+c)
            dist = tmp
        return dist[dst] if dist[dst] != INF else -1

print(Solution().findCheapestPrice(4, [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], 0, 3, 1))