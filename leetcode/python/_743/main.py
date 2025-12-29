from typing import List
from collections import defaultdict
from heapq import heappop, heappush

class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        graph = {i: [] for i in range(n)}
        for u, v, t in times: graph[u-1].append((v-1, t))

        dist = {}
        heap = [(0, k - 1)]
        while heap:
            t, u = heappop(heap)
            if u in dist: continue
            dist[u] = t
            if len(dist) == n: return max(dist.values())
            for v, w in graph[u]: heappush(heap, (t + w, v))
        return -1

print(Solution().networkDelayTime([[2,1,1],[2,3,1],[3,4,1]], 4, 2))