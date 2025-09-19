from typing import List

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy, profit = prices[0], 0
        for i in range(1, len(prices)):
            profit = max(profit, prices[i] - buy)
            buy = min(buy, prices[i])
        return profit

print(Solution().maxProfit([7,1,5,3,6,4]))