from typing import List

class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort()
        res, remove = [], 0
        for start, end in intervals:
            if not res or res[1] <= start:
                res = [start, end]
            else:
                res = [res[0], min(res[1], end)]
                remove += 1
        return remove

print(Solution().eraseOverlapIntervals([[1,2],[2,3],[3,4],[1,3]]))
print(Solution().eraseOverlapIntervals([[1,2],[1,2],[1,2]]))
print(Solution().eraseOverlapIntervals([[1,2],[2,3]]))
print(Solution().eraseOverlapIntervals([[1,2],[2,3],[3,4]]))
print(Solution().eraseOverlapIntervals([[1,2],[2,3],[3,4],[1,3]]))
print(Solution().eraseOverlapIntervals([[1,2],[2,3],[3,4],[1,3]]))