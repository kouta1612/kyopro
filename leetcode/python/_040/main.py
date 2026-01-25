from typing import List

class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        res = []
        
        def dfs(start, cur: int, path: List[int]):
            if cur == target:
                res.append(path[:])
                return

            for i in range(start, len(candidates)):
                if i > start and candidates[i] == candidates[i-1]: continue
                if cur + candidates[i] > target: break
                path.append(candidates[i])
                dfs(i + 1, cur + candidates[i], path)
                path.pop()

        dfs(0, 0, [])
        return res

print(Solution().combinationSum2([10, 1, 2, 7, 6, 1, 5], 8))