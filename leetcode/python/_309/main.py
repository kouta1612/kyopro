from typing import List

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        hold, sell, cool = -1<<30, 0, 0
        for price in prices:
            newhold = max(hold, cool - price)
            newsell = hold + price
            newcool = max(hold, sell, cool)
            hold, sell, cool = newhold, newsell, newcool
        return max(hold, sell, cool)

print(Solution().maxProfit([1,2,3,0,2]))