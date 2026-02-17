from typing import List

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        hold, sold, cool = float('-inf'), float('-inf'), 0
        for i in range(n):
            prev_hold = hold
            prev_sold = sold
            prev_cool = cool
            hold = max(prev_hold, prev_cool - prices[i])
            sold = prev_hold + prices[i]
            cool = max(prev_sold, prev_cool)
        return max(hold, sold, cool)

print(Solution().maxProfit([1,2,3,0,2]))