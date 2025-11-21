from typing import List

class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        res = [1] * n
        left, right = 1, 1
        for i, num in enumerate(nums):
            res[i] *= left
            left *= num
        for i in range(n - 1, -1, -1):
            res[i] *= right
            right *= nums[i]
        return res

print(Solution().productExceptSelf([1, 2, 3, 4]))