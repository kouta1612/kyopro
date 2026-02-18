from typing import List

class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1: return 0
        res = 0
        end = 0
        farthest = 0
        for i in range(n-1):
            farthest = max(farthest, i + nums[i])
            if i == end:
                end = farthest
                res += 1
                if end >= n-1: return res
        return -1

print(Solution().jump([2,3,1,1,4]))