from typing import List
from collections import defaultdict

class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        total = sum(nums)
        if total % 2 == 1: return False

        dp = defaultdict(bool)
        dp[0] = True
        for num in nums:
            nextDP = dp.copy()
            for key in dp.keys(): nextDP[key+num] = True
            dp = nextDP
        return dp[total//2]

print(Solution().canPartition([1,5,11,5]))