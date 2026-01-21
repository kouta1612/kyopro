from typing import List
from heapq import heappush, heappop

class Solution:
    def minInterval(self, intervals: List[List[int]], queries: List[int]) -> List[int]:
        intervals.sort()
        qs = sorted([q, i] for i, q in enumerate(queries))
        i = 0
        heap = []
        res = [-1] * len(qs)
        for v, qi in qs:
            while i < len(intervals) and intervals[i][0] <= v:
                l, r = intervals[i]
                heappush(heap, (r-l+1, r))
                i += 1
            while heap and heap[0][1] < v:
                heappop(heap)
            if heap:
                res[qi] = heap[0][0]
        return res

print(Solution().minInterval([[1, 4], [2, 8], [3, 6]], [2, 3, 4]))