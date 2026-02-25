from typing import List

class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        n = len(candidates)
        candidates.sort()
        res = []

        def dfs(start, remain: int, path: List[int]):
            if remain == 0:
                res.append(path[:])
                return
            if remain < 0: return

            for i in range(start, n):
                if i > start and candidates[i] == candidates[i-1]: continue
                path.append(candidates[i])
                dfs(i + 1, remain-candidates[i], path)
                path.pop()
        dfs(0, target, [])
        return res

print(Solution().combinationSum2([10, 1, 2, 7, 6, 1, 5], 8))