from typing import List
from collections import defaultdict

class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        total = sum(nums)
        if total % 2 == 1: return False

        dp = {0}
        for num in nums:
            nextDP = dp.copy()
            for key in dp: nextDP.add(key+num)
            dp = nextDP
            if total//2 in dp: return True
        return False

print(Solution().canPartition([1,5,11,5]))