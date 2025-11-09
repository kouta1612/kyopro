from typing import List

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        maxReach = 0
        for i, num in enumerate(nums):
            if i > maxReach: return False
            maxReach = max(maxReach, i + num)
            if maxReach >= n - 1: return True
        return True

print(Solution().canJump([2,3,1,1,4]))