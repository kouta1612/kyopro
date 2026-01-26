from typing import List

class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        nums.sort()
        res = []

        def dfs(start: int, path: List[int]):
            res.append(path[:])
            for i in range(start, n):
                if i > start and nums[i] == nums[i-1]: continue
                path.append(nums[i])
                dfs(i+1, path)
                path.pop()
        dfs(0, [])
        return res

print(Solution().subsetsWithDup([1, 2, 2]))