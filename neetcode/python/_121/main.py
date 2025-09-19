from typing import List

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        best = prices[0]
        res = 0
        for i in range(1, len(prices)):
            res = max(res, prices[i] - best)
            best = min(best, prices[i])
        return res

print(Solution().maxProfit([7,1,5,3,6,4]))