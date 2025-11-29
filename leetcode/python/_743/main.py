from typing import List
from collections import defaultdict
from heapq import heappop, heappush

class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        graph = defaultdict(list)
        for s, t, w in times: graph[s].append((t, w))
        visited = set()
        res = 0
        heap = [(0, k)]
        while heap:
            w, node = heappop(heap)
            if node in visited: continue
            visited.add(node)
            res = max(res, w)
            for t, w2 in graph[node]:
                if t in visited: continue
                heappush(heap, (w + w2, t))
        return res if len(visited) == n else -1

print(Solution().networkDelayTime([[2,1,1],[2,3,1],[3,4,1]], 4, 2))