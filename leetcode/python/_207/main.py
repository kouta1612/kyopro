from typing import List

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        preMap = { i: [] for i in range(numCourses) }
        for cur, pre in prerequisites:
            preMap[cur].append(pre)
        visit = set()

        def dfs(cur: int) -> bool:
            if cur in visit: return False
            if not preMap[cur]: return True
            visit.add(cur)
            for pre in preMap[cur]:
                if not dfs(pre): return False
            visit.remove(cur)
            preMap[cur] = []
            return True

        for cou in range(numCourses):
            if not dfs(cou): return False
        return True

print(Solution().canFinish(2, [[1,0]]))
print(Solution().canFinish(2, [[1,0],[0,1]]))