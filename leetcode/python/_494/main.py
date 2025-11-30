from typing import List 
from collections import defaultdict
class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        dp = defaultdict(int)
        for num in nums:
            if len(dp) == 0:
                dp[num] += 1
                dp[-num] += 1
                continue
            nextDP = defaultdict(int)
            for key, val in dp.items():
                nextDP[key + num] += dp[key]
                nextDP[key - num] += dp[key]
            dp = nextDP
        return dp[target]

print(Solution().findTargetSumWays([1,1,1,1,1], 3))