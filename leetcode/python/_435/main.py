from typing import List

class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort(key=lambda x: x[1])
        res, prevEnd = 0, float('-inf')
        for start, end in intervals:
            if start >= prevEnd:
                prevEnd = end
            else:
                res += 1
        return res

print(Solution().eraseOverlapIntervals([[1,2],[2,3],[3,4],[1,3]]))
print(Solution().eraseOverlapIntervals([[1,2],[1,2],[1,2]]))
print(Solution().eraseOverlapIntervals([[1,2],[2,3]]))
print(Solution().eraseOverlapIntervals([[1,2],[2,3],[3,4]]))
print(Solution().eraseOverlapIntervals([[1,2],[2,3],[3,4],[1,3]]))
print(Solution().eraseOverlapIntervals([[1,2],[2,3],[3,4],[1,3]]))