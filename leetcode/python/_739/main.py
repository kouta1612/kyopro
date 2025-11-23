from typing import List

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        res = [0] * len(temperatures)
        stack = []
        for i, temp in enumerate(temperatures):
            while stack and stack[-1][1] < temp:
                j, t = stack.pop()
                res[j] = i - j
            stack.append((i, temp))
        return res

print(Solution().dailyTemperatures([73, 74, 75, 71, 69, 72, 76, 73]))