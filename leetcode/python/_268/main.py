from typing import List

class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        xor, n = len(nums), len(nums)

        for i in range(n):
            xor ^= i ^ nums[i]
        
        return xor

print(Solution().missingNumber([3,0,1]))