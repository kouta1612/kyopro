from typing import List

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = [[]]

        def dfs(i: int, vals: List[int]):
            if i == len(nums): return

            dfs(i + 1, vals)

            vals.append(nums[i])
            res.append(vals[:])
            dfs(i + 1, vals)
            vals.pop()

        dfs(0, [])
        return res

print(Solution().subsets([1,2,3]))