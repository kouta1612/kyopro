from typing import List

class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        nums.sort()
        res = []

        def dfs(i: int, cur: List[int]):
            res.append(cur[:])
            
            for j in range(i, n):
                if j > i and nums[j] == nums[j-1]: continue
                cur.append(nums[j])
                dfs(j+1, cur)
                cur.pop()
        dfs(0, [])
        return res

print(Solution().subsetsWithDup([1, 2, 2]))