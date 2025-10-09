from typing import List

class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        def helper(nums, perm: List[int]):
            if not nums: 
                res.append(perm[:])
                return
            for i in range(len(nums)):
                newNums = nums[:i] + nums[i+1:]
                perm.append(nums[i])
                helper(newNums, perm)
                perm.pop()
        helper(nums, [])
        return res

print(Solution().permute([1,2,3]))