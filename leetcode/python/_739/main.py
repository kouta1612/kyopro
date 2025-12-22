from typing import List

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        res = [0] * n
        stack = [] # [i,v]
        for i, t in enumerate(temperatures):
            while stack and stack[-1][1] < t:
                j, _ = stack.pop()
                res[j] = i - j
            stack.append((i, t))
        return res

print(Solution().dailyTemperatures([73, 74, 75, 71, 69, 72, 76, 73]))