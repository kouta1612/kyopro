from typing import List 
from collections import defaultdict
class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        dp = {0: 1}
        for num in nums:
            nextDP = defaultdict(int)
            for key, val in dp.items():
                nextDP[key + num] += dp[key]
                nextDP[key - num] += dp[key]
            dp = nextDP
        return dp.get(target, 0)

print(Solution().findTargetSumWays([1,1,1,1,1], 3))