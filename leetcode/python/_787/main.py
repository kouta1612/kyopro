from typing import List
from collections import defaultdict

class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        dp = [float('inf')] * n
        dp[src] = 0
        for _ in range(k+1):
            next_dp = dp[:]
            for start, end, cost in flights:
                if dp[start] == float('inf'): continue
                next_dp[end] = min(next_dp[end], dp[start] + cost)
            dp = next_dp
        return dp[dst] if dp[dst] != float('inf') else -1

print(Solution().findCheapestPrice(4, [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], 0, 3, 1))