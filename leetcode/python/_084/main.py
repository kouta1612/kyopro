from types import List

class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        heights.append(0)
        res = 0
        stack = []
        for i, h in enumerate(heights):
            while stack and heights[stack[-1]] > h: 
                j = stack.pop()
                width = i - (stack[-1] if stack else -1) - 1
                res = max(res, width * heights[j])
            stack.append(i)
        return res

print(Solution().largestRectangleArea([2,1,5,6,2,3]))