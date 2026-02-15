from typing import List

class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        n = len(candidates)
        candidates.sort()
        res = []

        def dfs(i, rem: int, cur: List[int]):
            if rem == 0:
                res.append(cur[:])
                return
            if rem < 0: return

            for j in range(i, n):
                if j > i and candidates[j] == candidates[j-1]: continue
                cur.append(candidates[j])
                dfs(j+1, rem-candidates[j], cur)
                cur.pop()
        dfs(0, target, [])
        return res

print(Solution().combinationSum2([10, 1, 2, 7, 6, 1, 5], 8))