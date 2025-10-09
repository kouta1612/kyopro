from typing import List

class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        def helper(perms: List[int], used: List[bool]):
            if len(perms) == len(nums):
                res.append(perms[:])
                return
            for i in range(len(nums)):
                if used[i]: continue
                perms.append(nums[i])
                used[i] = True
                helper(perms, used)
                perms.pop()
                used[i] = False
        helper([], [False] * len(nums))
        return res


print(Solution().permute([1,2,3]))