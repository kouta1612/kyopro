from typing import List

class Solution:
    def rob(self, nums: List[int]) -> int:
        def helper(moneys: List[int]) -> int:
            rob1, rob2 = 0, 0
            for money in moneys:
                rob1, rob2 = max(rob2 + money, rob1), rob1
            return rob1
        return max(nums[0], helper(nums[1:]), helper(nums[:-1]))

print(Solution().rob([1,2,3,1]))