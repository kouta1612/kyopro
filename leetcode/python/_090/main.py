from typing import List

class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        res = []

        def dfs(start: int, cur: List[int]):
            res.append(cur[:])
            if start == len(nums): return

            for i in range(start, len(nums)):
                if i > start and nums[i] == nums[i-1]: continue
                cur.append(nums[i])
                dfs(i + 1, cur)
                cur.pop()
        
        dfs(0, [])
        return res

print(Solution().subsetsWithDup([1, 2, 2]))