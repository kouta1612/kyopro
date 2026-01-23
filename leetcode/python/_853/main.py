from typing import List

class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        cars = sorted(zip(position, speed), reverse=True)
        cur = 0.0
        res = 0
        for pos, spd in cars:
            time = (target - pos) / spd
            if time <= cur: continue
            res += 1
            cur = time
        return res

print(Solution().carFleet(12, [10, 8, 0, 5, 3], [2, 4, 1, 1, 3]))