from typing import List
from collections import defaultdict

class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        graph = defaultdict(list)
        for start, end, cost in flights:
            graph[start].append((end, cost))
        
        res = [float('inf')] * n
        res[src] = 0
        for _ in range(k+1):
            tmp = res[:]
            for start in range(n):
                if res[start] == float('inf'): continue
                for end, cost in graph[start]:
                    tmp[end] = min(tmp[end], cost+res[start])
            res = tmp
        return res[dst] if res[dst] != float('inf') else -1

print(Solution().findCheapestPrice(4, [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], 0, 3, 1))