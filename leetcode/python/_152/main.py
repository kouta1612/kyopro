from typing import List

class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        n, res = len(nums), max(nums)
        curMax, curMin = 1, 1
        for num in nums:
            if num == 0: 
                curMax, curMin = 1, 1
            else:
                tmp = curMax * num
                curMax = max(tmp, curMin * num, num)
                curMin = min(tmp, curMin * num, num)
                res = max(res, curMax)
        return res

print(Solution().maxProduct([2,3,-2,4]))