from typing import List

class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        if sum(nums) % 2 == 1: return False
        total = sum(nums)
        dp = [False] * (total + 1)
        dp[0] = True
        for num in nums:
            nextDP = dp.copy()
            for i in range(total // 2 + 1):
                if not dp[i]: continue
                if i + num > total: continue
                nextDP[i + num] = True
            dp = nextDP
        return dp[total // 2]

print(Solution().canPartition([1,5,11,5]))