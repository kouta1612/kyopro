from typing import List

class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        res = max(nums)
        curMax, curMin = 1, 1
        for n in nums:
            curMax, curMin = max(curMax * n, curMin * n, n), min(curMax * n, curMin * n, n)
            res = max(res, curMax)
        return res

print(Solution().maxProduct([2,3,-2,4]))