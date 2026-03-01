from typing import List

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        buy, sold, cool = float('-inf'), 0, 0
        for i in range(n):
            pre_buy, pre_sold, pre_cool = buy, sold, cool
            buy = max(buy, pre_cool - prices[i])
            sold = max(sold, pre_buy + prices[i])
            cool = max(cool, pre_sold)
        return max(buy, sold, cool)

print(Solution().maxProfit([1,2,3,0,2]))