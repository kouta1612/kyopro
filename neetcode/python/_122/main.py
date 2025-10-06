from typing import List

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        now, res = prices[0], 0
        for price in prices:
            if now < price:
                res += price - now
            now = price
        return res
print(Solution().maxProfit([7,1,5,3,6,4]))