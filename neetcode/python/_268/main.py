from typing import List

class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        n = len(nums)
        
        s = set()
        for num in nums:
            s.add(num)
        
        for v in range(n + 1):
            if v not in s:
                return v
        
        return -1

print(Solution().missingNumber([3,0,1]))