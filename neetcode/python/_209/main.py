from typing import List

class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        res, j, curSum = int(1e6), 0, 0
        for i in range(len(nums)):
            while j < len(nums) and curSum + nums[j] < target:
                curSum += nums[j]
                j += 1
            res = min(res, (j + 1) - i) if j < len(nums) and curSum + nums[j] >= target else res
            curSum -= nums[i]
        return res if res != int(1e6) else 0

print(Solution().minSubArrayLen(7, [2,3,1,2,4,3]))
print(Solution().minSubArrayLen(4, [1,4,4]))
print(Solution().minSubArrayLen(11, [1,1,1,1,1,1,1,1]))