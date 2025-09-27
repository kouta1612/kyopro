from typing import List

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        res, cursum = nums[0], 0
        for num in nums:
            if cursum < 0:
                cursum = 0
            cursum += num
            res = max(res, cursum)
        return res

print(Solution().maxSubArray([-2,1,-3,4,-1,2,1,-5,4]))