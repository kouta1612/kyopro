from typing import List

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        def helper(i, sum: int, comb: List[int]):
            if sum == target:
                res.append(comb[:])
                return
            if sum > target: return
            if i >= len(candidates): return

            helper(i + 1, sum, comb)

            comb.append(candidates[i])
            helper(i, sum + candidates[i], comb)
            comb.pop()
        helper(0, 0, [])
        return res

print(Solution().combinationSum([2,3,6,7], 7))
print(Solution().combinationSum([2,3,5], 8))
print(Solution().combinationSum([2], 1))