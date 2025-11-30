from typing import List

class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        n = len(nums)
        target = sum(nums)
        if target % 2 == 1: return False
        dp = set([0])
        for i in range(n):
            nextDP = set()
            for v in dp:
                nextDP.add(v + nums[i])
                nextDP.add(v)
            dp = nextDP
        return True if target // 2 in dp else False

print(Solution().canPartition([1,5,11,5]))