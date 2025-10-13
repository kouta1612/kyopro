from typing import List

class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        res = 0
        for i in range(len(nums) + 1):
            res ^= i
        for num in nums:
            res ^= num
        return res

print(Solution().missingNumber([3,0,1]))