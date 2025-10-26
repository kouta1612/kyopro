from typing import List

class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        res = max(nums)
        maxP, minP = 1, 1
        for n in nums:
            if n == 0: 
                maxP, minP = 1, 1
            else:
                tmp = n * maxP
                maxP = max(tmp, n * minP, n)
                minP = min(tmp, n * minP, n)
                res = max(res, maxP)
        return res

print(Solution().maxProduct([2,3,-2,4]))