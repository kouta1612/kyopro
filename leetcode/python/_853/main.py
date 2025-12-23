from typing import List

class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        n = len(speed)
        items = [(position[i], (target - position[i]) / speed[i]) for i in range(n)]
        items.sort()

        stack = []
        for pos, sec in reversed(items):
            if not stack or stack[-1] < sec: stack.append(sec)
        return len(stack)

print(Solution().carFleet(12, [10, 8, 0, 5, 3], [2, 4, 1, 1, 3]))