from typing import List

class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        costs = [float('inf')] * n
        costs[src] = 0
        for _ in range(k + 1):
            tmps = costs.copy()
            for start, end, cost in flights:
                if costs[start] == float('inf'): continue
                if costs[start] + cost >= tmps[end]: continue
                tmps[end] = costs[start] + cost
            costs = tmps
        return costs[dst] if costs[dst] != float('inf') else -1

print(Solution().findCheapestPrice(4, [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], 0, 3, 1))