from types import List

class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        nums = [1] + nums + [1]
        n = len(nums)
        dp = [[0] * n for _ in range(n)]
        for length in range(2, n):
            for l in range(n - length):
                r = l + length
                for i in range(l + 1, r):
                    dp[l][r] = max(dp[l][r], dp[l][i] + dp[i][r] + nums[l] * nums[i] * nums[r])
        return dp[0][n-1]

print(Solution().maxCoins([3,1,5,8]))