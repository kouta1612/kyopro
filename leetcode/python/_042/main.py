from types import List

class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        lMaxHeights, rMaxHeights = [0] * n, [0] * n
        for i in range(1, n):
            lMaxHeights[i] = max(lMaxHeights[i-1], height[i-1])
        for i in range(n - 2, -1, -1):
            rMaxHeights[i] = max(rMaxHeights[i+1], height[i+1])
        res = 0
        for i in range(1, n - 1):
            res += max(min(lMaxHeights[i], rMaxHeights[i]) - height[i], 0)
        return res

print(Solution().trap([0,1,0,2,1,0,1,3,2,1,2,1]))