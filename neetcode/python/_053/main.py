from typing import List

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        dp = [0] * len(nums)
        dp[0] = max(dp[0], nums[0])
        for i in range(1, len(nums)):
            dp[i] = max(dp[i], dp[i-1] + nums[i])
        return max(dp) if max(dp) > 0 else max(nums)

print(Solution().maxSubArray([-2,1,-3,4,-1,2,1,-5,4]))