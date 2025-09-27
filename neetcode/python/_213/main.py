from typing import List

class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) < 2:
            return nums[0]
        return max(self.helper(nums[:len(nums)-1]), self.helper(nums[1:]))

    def helper(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [[0] * 2 for i in range(n)]
        dp[0][1] = nums[0]
        for i in range(1, n):
            for j in range(2):
                if j == 0:
                    dp[i][j] = max(dp[i-1][0], dp[i-1][1])
                else:
                    dp[i][j] = dp[i-1][0] + nums[i]
        return max(dp[n-1][0], dp[n-1][1])
print(Solution().rob([1,2,3,1]))