from typing import List

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        preMap = {i: [] for i in range(numCourses)}
        for crs, pre in prerequisites:
            preMap[crs].append(pre)
        seen = set()

        def dfs(crs: int) -> bool:
            if crs in seen: return False
            if not preMap[crs]: return True

            seen.add(crs)
            for pre in preMap[crs]:
                if not dfs(pre): return False
            seen.remove(crs)
            preMap[crs] = []

            return True

        for n in range(numCourses):
            if not dfs(n): return False
        return True

print(Solution().canFinish(2, [[1,0]]))
print(Solution().canFinish(2, [[1,0],[0,1]]))