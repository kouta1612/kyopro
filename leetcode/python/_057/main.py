from typing import List

class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        if not intervals: return [newInterval]
        res = []
        for i in range(len(intervals)):
            start, end = intervals[i]
            if newInterval[1] < start:
                res.append(newInterval)
                return res + intervals[i:]
            elif end < newInterval[0]:
                res.append([start, end])
            else:
                newInterval = [min(start, newInterval[0]), max(end, newInterval[1])]
        res.append(newInterval)
        return res

print(Solution().insert([[1,3],[6,9]], [2,5]))
print(Solution().insert([[1,2],[3,5],[6,7],[8,10],[12,16]], [4,8]))
print(Solution().insert([], [5,7]))
print(Solution().insert([[1,5]], [2,3]))
print(Solution().insert([[1,5]], [6,8]))
print(Solution().insert([[1,5]], [0,0]))
print(Solution().insert([[1,5]], [0,6]))
print(Solution().insert([[1,5]], [0,7]))
print(Solution().insert([[1,5]], [0,8]))
print(Solution().insert([[1,5]], [0,9]))
print(Solution().insert([[1,5]], [0,10]))