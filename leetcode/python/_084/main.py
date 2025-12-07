from types import List

class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        res = 0
        stack = []
        for i, h in enumerate(heights):
            start = i
            while stack and stack[-1][1] > h:
                index, height = stack.pop()
                res = max(res, height * (i - index))
                start = index
            stack.append((start, h))
        while stack:
            i, h = stack.pop()
            res = max(res, h * (len(heights) - i))
        return res

print(Solution().largestRectangleArea([2,1,5,6,2,3]))