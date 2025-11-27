from typing import List
from heapq import heappush, heappop

class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        heaps = []
        for x, y in points:
            dist = x * x + y * y
            heappush(heaps, (dist, x, y))
        res = []
        for _ in range(k):
            _, x, y = heappop(heaps)
            res.append((x, y))
        return res

print(Solution().kClosest([[1, 3], [-2, 2]], 1))