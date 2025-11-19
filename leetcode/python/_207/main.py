from typing import List
from collections import deque

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        mapFromTo = { i: [] for i in range(numCourses) }
        for t, s in prerequisites:
            mapFromTo[s].append(t)
        
        visiting, visited = set(), set()

        def dfs(i: int) -> bool:
            if i in visiting and i not in visited: return True
            if i in visiting: return False
            visiting.add(i)
            for ni in mapFromTo[i]:
                if dfs(ni): return True
            visited.add(i)
            return False

        for i in range(numCourses):
            if dfs(i): return False
        return True

print(Solution().canFinish(2, [[1,0]]))
print(Solution().canFinish(2, [[1,0],[0,1]]))