from typing import List

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        dp = [0] * n
        for i in range(1, n):
            if prices[i] > prices[i-1]:
                dp[i] = dp[i-1] + prices[i] - prices[i-1]
            else:
                dp[i] = dp[i-1]
        return dp[n-1]
print(Solution().maxProfit([7,1,5,3,6,4]))