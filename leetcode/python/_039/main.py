from typing import List

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.res = []
        def helper(i, total: int, combs: List[int]):
            if i >= len(candidates): return
            if total > target: return
            if total == target:
                self.res.append(combs[:])
                return
            for j in range(i, len(candidates)):
                combs.append(candidates[j])
                helper(j, total + candidates[j], combs)
                combs.pop()
        helper(0, 0, [])
        return self.res

print(Solution().combinationSum([2,3,6,7], 7))
print(Solution().combinationSum([2,3,5], 8))
print(Solution().combinationSum([2], 1))