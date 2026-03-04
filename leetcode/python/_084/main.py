from types import List

class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        res = 0
        stack = []
        heights.append(0)
        for i, h in enumerate(heights):
            while stack and heights[stack[-1]] > h: 
                height = heights[stack.pop()]
                left = -1
                if stack: left = stack[-1]
                width = i - left - 1
                res = max(res, height * width)
            stack.append(i)
        return res

print(Solution().largestRectangleArea([2,1,5,6,2,3]))