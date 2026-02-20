from types import List

class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        l, r = 0, n - 1
        max_left, max_right = 0, 0
        res = 0
        while r != l:
            if height[l] <= height[r]:
                res += max(max_left - height[l], 0)
                max_left = max(max_left, height[l])
                l += 1
            else:
                res += max(max_right - height[r], 0)
                max_right = max(max_right, height[r])
                r -= 1
        return res

print(Solution().trap([0,1,0,2,1,0,1,3,2,1,2,1]))