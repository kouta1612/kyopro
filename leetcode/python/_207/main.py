from typing import List
from collections import deque

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        requireMap = {i: [] for i in range(numCourses)}
        degins = [0] * numCourses

        for cur, pre in prerequisites:
            requireMap[pre].append(cur)
            degins[cur] += 1

        deq = deque[int]([i for i in range(numCourses) if degins[i] == 0])
        finished = 0
        while deq:
            cur = deq.popleft()
            finished += 1
            for nxt in requireMap[cur]:
                degins[nxt] -= 1
                if degins[nxt] == 0: deq.append(nxt)
        return numCourses == finished


print(Solution().canFinish(2, [[1,0]]))
print(Solution().canFinish(2, [[1,0],[0,1]]))