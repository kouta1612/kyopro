from typing import List

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        minOK = len(nums) - 1
        for i in range(n - 2, -1, -1):
            if i + nums[i] >= minOK: minOK = i
        return minOK == 0

print(Solution().canJump([2,3,1,1,4]))