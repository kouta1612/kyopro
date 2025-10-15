from typing import List

class Solution:
    def maxArea(self, height: List[int]) -> int:
        res = 0
        l, r = 0, len(height) - 1
        while l < r:
            res = max(res, (r-l) * min(height[l], height[r]))
            if height[l] <= height[r]: l += 1
            else: r -= 1
        return res

print(Solution().maxArea([1, 8, 6, 2, 5, 4, 8, 3, 7]))