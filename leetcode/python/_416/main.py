from typing import List
from collections import defaultdict

class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        total = sum(nums)
        target = total // 2
        if total % 2 == 1: return False

        dp = [False] * (target+1)
        dp[0] = True
        for num in nums:
            for i in range(target, num-1, -1):
                dp[i] |= dp[i-num]
        return dp[target]

print(Solution().canPartition([1,5,11,5]))