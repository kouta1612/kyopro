from typing import List
from collections import deque

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        res = [0] * n
        deq = deque() # [i,v]
        for i, t in enumerate(temperatures[:n]):
            while deq and deq[-1][1] < t:
                j, _ = deq.pop()
                res[j] = i - j
            deq.append((i, t))
        return res

print(Solution().dailyTemperatures([73, 74, 75, 71, 69, 72, 76, 73]))