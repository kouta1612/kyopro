from typing import List

class Solution:
    def rob(self, nums: List[int]) -> int:
        def helper(moneys: List[int]) -> int:
            if not moneys: return 0
            if len(moneys) == 1: return moneys[0]

            dp = [0] * (len(moneys) + 1)
            dp[1] = moneys[0]
            for i in range(1, len(moneys)):
                dp[i + 1] = max(dp[i], dp[i-1] + moneys[i])
            return dp[len(moneys)]
        return max(nums[0], helper(nums[1:]), helper(nums[:-1]))

print(Solution().rob([1,2,3,1]))