from typing import List

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        dp = [0] * (len(prices) + 1)
        for i in range(1, len(prices)):
            if prices[i] > prices[i-1]:
                dp[i + 1] = dp[i] + prices[i] - prices[i-1]
            else:
                dp[i + 1] = dp[i]
        return dp[len(prices)]
print(Solution().maxProfit([7,1,5,3,6,4]))