from typing import List


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []

        def helper(i: int, cur: List[int], total: int):
            if total == target:
                res.append(cur.copy())
                return
            if i == len(candidates) or total > target:
                return
            
            cur.append(candidates[i])
            helper(i, cur, total + candidates[i])
            cur.pop()

            helper(i + 1, cur, total)

        helper(0, [], 0)

        return res

print(Solution().combinationSum([2,3,6,7], 7))
print(Solution().combinationSum([2,3,5], 8))
print(Solution().combinationSum([2], 1))