from typing import List
from heapq import heappush, heappushpop

class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        heaps = []
        for x, y in points:
            dist = x * x + y * y
            if len(heaps) < k: heappush(heaps, (-dist, x, y))
            else: heappushpop(heaps, (-dist, x, y))
        return [[x, y] for _, x, y in heaps]

print(Solution().kClosest([[1, 3], [-2, 2]], 1))