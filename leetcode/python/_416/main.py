from typing import List
from collections import defaultdict

class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        total = sum(nums)
        if total % 2 == 1: return False

        nums.sort()
        n = len(nums)
        target = total // 2
        dp = [False] * (target + 1)
        dp[0] = True
        for i in range(n):
            nextDP = dp[:]
            for v in range(nums[i], target + 1):
                if dp[v-nums[i]]: nextDP[v] = True
            dp = nextDP
        return dp[target]

print(Solution().canPartition([1,5,11,5]))