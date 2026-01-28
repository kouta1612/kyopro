from typing import List
from collections import defaultdict
from heapq import heappop, heappush

class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        res = float('inf')

        graph = defaultdict(list)
        for start, end, price in flights:
            graph[start].append((end, price))

        best = {}
        heap = [(0, src, k)]
        while heap:
            cost, start, remain = heappop(heap)
            if cost >= res: continue
            if (start, remain) in best and best[(start, remain)] <= cost: continue
            best[(start, remain)] = cost
            if start == dst: 
                res = min(res, cost)
                continue
            if remain < 0: continue

            for end, price in graph[start]:
                heappush(heap, (cost + price, end, remain - 1))
        return res if res != float('inf') else -1

print(Solution().findCheapestPrice(4, [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], 0, 3, 1))