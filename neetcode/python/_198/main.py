from typing import List

class Solution:
    def rob(self, nums: List[int]) -> int:
        dp = [[0] * 2 for i in range(len(nums))]
        dp[0][1] = nums[0]
        for i in range(1, len(nums)):
            for j in range(2):
                if j == 0:
                    dp[i][j] = max(dp[i-1][0], dp[i-1][1])
                else:
                    dp[i][j] = dp[i-1][0] + nums[i]
        return max(dp[-1][0], dp[-1][1])

print(Solution().rob([1,2,3,1]))