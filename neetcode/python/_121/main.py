from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        res, buy = 0, prices[0]
        for sell in prices:
            res = max(res, sell-buy)
            buy = min(buy, sell)

        return res

print(Solution().maxProfit([7,1,5,3,6,4]))