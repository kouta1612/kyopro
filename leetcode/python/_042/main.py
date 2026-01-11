from types import List

class Solution:
    def trap(self, height: List[int]) -> int:
        l, r = 0, len(height) - 1
        lmax, rmax = 0, 0
        res = 0
        while l < r:
            if height[l] <= height[r]:
                if lmax > height[l]: res += lmax - height[l]
                else: lmax = height[l]
                l += 1
            else:
                if rmax > height[r]: res += rmax - height[r]
                else: rmax = height[r]
                r -= 1
        return res

print(Solution().trap([0,1,0,2,1,0,1,3,2,1,2,1]))