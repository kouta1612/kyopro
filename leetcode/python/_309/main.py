from typing import List

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        hold, sold, rest = float('-inf'), float('-inf'), 0
        for price in prices:
            pre_hold, pre_sold, pre_rest = hold, sold, rest
            hold = max(pre_hold, pre_rest - price)
            sold = pre_hold + price
            rest = max(pre_rest, pre_sold)
        return max(sold, rest)

print(Solution().maxProfit([1,2,3,0,2]))