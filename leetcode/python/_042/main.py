from types import List

class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        l, r = 0, n-1
        lmax, rmax = 0, 0
        res = 0
        while l != r:
            if height[l] <= height[r]:
                res += max(lmax - height[l], 0)
                lmax = max(lmax, height[l])
                l += 1
            else:
                res += max(rmax - height[r], 0)
                rmax = max(rmax, height[r])
                r -= 1
        return res

print(Solution().trap([0,1,0,2,1,0,1,3,2,1,2,1]))