from types import List

class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        res = 0
        heights.append(0)
        stack = []
        for i, h in enumerate(heights):
            while stack and heights[stack[-1]] > h:
                height = heights[stack.pop()]
                j = stack[-1] if stack else -1
                width = i - j - 1
                res = max(res, height * width)
            stack.append(i)
        return res

print(Solution().largestRectangleArea([2,1,5,6,2,3]))