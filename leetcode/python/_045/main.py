from typing import List

class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1: return 0

        farthest, end, res = 0, 0, 0
        for i in range(n):
            farthest = max(farthest, i + nums[i])
            if i == end:
                end = farthest
                res += 1
                if end >= n - 1: break
        return res

print(Solution().jump([2,3,1,1,4]))