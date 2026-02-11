from typing import List
from heapq import heappush, heappop

class Solution:
    def minInterval(self, intervals: List[List[int]], queries: List[int]) -> List[int]:
        n = len(queries)
        qs = [[v, i] for i, v in enumerate(queries)]
        intervals.sort()
        qs.sort()

        heap = []
        res = [0] * n
        i = 0
        for qv, qi in qs:
            while i < len(intervals):
                start, end = intervals[i]
                if start <= qv: 
                    heappush(heap, (end-start+1, end, qi))
                    i += 1
                else: 
                    break
            while heap and heap[0][1] < qv:
                heappop(heap)
            res[qi] = heap[0][0] if heap else -1
        return res

print(Solution().minInterval([[1, 4], [2, 8], [3, 6]], [2, 3, 4]))