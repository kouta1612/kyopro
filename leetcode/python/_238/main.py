from typing import List

class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        res = [1] * len(nums)

        left = 1
        for i in range(len(nums)):
            res[i] *= left
            left *= nums[i]
        
        right = 1
        for i in reversed(range(len(nums))):
            res[i] *= right
            right *= nums[i]
        
        return res

print(Solution().productExceptSelf([1, 2, 3, 4]))