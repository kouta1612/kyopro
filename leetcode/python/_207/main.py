from typing import List
from collections import deque

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        mapFromTo = { i: [] for i in range(numCourses) }
        for t, s in prerequisites:
            mapFromTo[s].append(t)
        
        seen, finished = set(), set()

        def dfs(i: int) -> bool:
            if i in seen and i not in finished: return True
            if i in seen: return False
            seen.add(i)
            for ni in mapFromTo[i]:
                if dfs(ni): return True
            finished.add(i)
            return False

        for i in range(numCourses):
            if dfs(i): return False
        return True

print(Solution().canFinish(2, [[1,0]]))
print(Solution().canFinish(2, [[1,0],[0,1]]))