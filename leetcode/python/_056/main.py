from typing import List

class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort()
        res = []
        for start, end in intervals:
            if not res or res[-1][1] < start: 
                res.append([start, end])
            else:
                res[-1] = [min(res[-1][0], start), max(res[-1][1], end)]
        return res

print(Solution().merge([[1,3],[2,6],[8,10],[15,18]]))
print(Solution().merge([[1,4],[4,5]]))
print(Solution().merge([[1,4],[0,4]]))
print(Solution().merge([[1,4],[0,0]]))
print(Solution().merge([[1,4],[0,0]]))