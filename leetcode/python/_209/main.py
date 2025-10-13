from typing import List

class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        res, j, curSum, n = float('inf'), 0, 0, len(nums)
        for i in range(n):
            while j < n and curSum < target:
                curSum += nums[j]
                j += 1
            if curSum >= target:
                res = min(res, j - i)
            curSum -= nums[i]
        return res if res != float('inf') else 0

print(Solution().minSubArrayLen(7, [2,3,1,2,4,3]))
print(Solution().minSubArrayLen(4, [1,4,4]))
print(Solution().minSubArrayLen(11, [1,1,1,1,1,1,1,1]))