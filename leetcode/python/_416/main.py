from typing import List

class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        if sum(nums) % 2 == 1: return False
        n = len(nums)
        target = sum(nums) // 2
        dp = set([0])
        for i in range(n):
            nextDP = set()
            for v in dp:
                nextDP.add(v + nums[i])
                nextDP.add(v)
            dp = nextDP
        return True if target in dp else False

print(Solution().canPartition([1,5,11,5]))