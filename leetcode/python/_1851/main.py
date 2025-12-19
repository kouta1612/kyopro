from typing import List
from heapq import heappush, heappop

class Solution:
    def minInterval(self, intervals: List[List[int]], queries: List[int]) -> List[int]:
        intervals.sort()
        res, i = {}, 0
        heap = []
        for q in sorted(queries):
            while i < len(intervals) and intervals[i][0] <= q:
                l, r = intervals[i]
                heappush(heap, (r - l + 1, r))
                i += 1
            while heap and heap[0][1] < q:
                heappop(heap)
            res[q] = heap[0][0] if heap else -1
        return [res[q] for q in queries]

print(Solution().minInterval([[1, 4], [2, 8], [3, 6]], [2, 3, 4]))