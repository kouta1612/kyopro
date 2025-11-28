from typing import List
from collections import defaultdict, deque

class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        indeg = [0] * numCourses
        mapStartToEnds = defaultdict(list)
        for end, start in prerequisites:
            indeg[end] += 1
            mapStartToEnds[start].append(end)
        
        deq = deque()
        for cou in range(numCourses):
            if indeg[cou] == 0: deq.append(cou)
        
        res = []
        while deq:
            s = deq.popleft()
            res.append(s)
            for t in mapStartToEnds[s]:
                indeg[t] -= 1
                if indeg[t] == 0: deq.append(t)
        return res if len(res) == numCourses else []

print(Solution().findOrder(2, [[1, 0]]))
print(Solution().findOrder(4, [[1, 0], [2, 0], [3, 1], [3, 2]]))