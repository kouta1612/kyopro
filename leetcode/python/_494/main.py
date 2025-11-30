from typing import List

class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        dp = {}
        for num in nums:
            if len(dp) == 0:
                dp[num] = dp.get(num, 0) + 1
                dp[-num] = dp.get(-num, 0) + 1
                continue
            nextDP = {}
            for key, val in dp.items():
                if key + num not in nextDP:
                    nextDP[key + num] = 0
                if key - num not in nextDP:
                    nextDP[key - num] = 0
                nextDP[key + num] += dp[key]
                nextDP[key - num] += dp[key]
            dp = nextDP
        return dp[target] if target in dp else 0

print(Solution().findTargetSumWays([1,1,1,1,1], 3))