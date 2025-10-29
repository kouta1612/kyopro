from typing import List

class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort()
        res = []
        for interval in intervals:
            if not res or res[-1][1] < interval[0]: 
                res.append([interval[0], interval[1]])
            else:
                res[-1] = [min(res[-1][0], interval[0]), max(res[-1][1], interval[1])]
        return res

print(Solution().merge([[1,3],[2,6],[8,10],[15,18]]))
print(Solution().merge([[1,4],[4,5]]))
print(Solution().merge([[1,4],[0,4]]))
print(Solution().merge([[1,4],[0,0]]))
print(Solution().merge([[1,4],[0,0]]))