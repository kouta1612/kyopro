from typing import List

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        res, cursum = nums[0], nums[0]
        for i in range(1, len(nums)):
            cursum = max(cursum + nums[i], nums[i])
            res = max(res, cursum)
        return res

print(Solution().maxSubArray([-2,1,-3,4,-1,2,1,-5,4]))