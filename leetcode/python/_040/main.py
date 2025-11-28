from typing import List

class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        candidates.sort()

        def dfs(i: int, total: int, cur: List[int]):
            if total == target:
                res.append(cur.copy())
                return
            if total > target or i == len(candidates): return
            
            cur.append(candidates[i])
            dfs(i + 1, total + candidates[i], cur)
            cur.pop()

            while i + 1 < len(candidates) and candidates[i] == candidates[i+1]:
                i += 1
            dfs(i + 1, total, cur)

        dfs(0, 0, [])
        return res

print(Solution().combinationSum2([10, 1, 2, 7, 6, 1, 5], 8))