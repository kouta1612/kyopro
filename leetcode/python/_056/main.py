from typing import List

class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort()
        res = []
        newInterval = []
        for i in range(len(intervals)):
            if not newInterval: newInterval = intervals[i][:]
            elif newInterval[1] < intervals[i][0]:
                res.append(newInterval[:])
                newInterval = intervals[i][:]
            elif newInterval[0] > intervals[i][1]:
                res.append(intervals[i])
            else:
                newInterval = [min(newInterval[0], intervals[i][0]), max(newInterval[1], intervals[i][1])]
        res.append(newInterval)
        return res

print(Solution().merge([[1,3],[2,6],[8,10],[15,18]]))
print(Solution().merge([[1,4],[4,5]]))
print(Solution().merge([[1,4],[0,4]]))
print(Solution().merge([[1,4],[0,0]]))
print(Solution().merge([[1,4],[0,0]]))