from typing import List

class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        cars = sorted([[pos, sp] for pos, sp in zip(position, speed)], reverse=True)
        pre, fleet = 0, 0
        for pos, sp in cars:
            t = (target - pos) / sp
            if pre < t: 
                fleet += 1
                pre = t
        return fleet

print(Solution().carFleet(12, [10, 8, 0, 5, 3], [2, 4, 1, 1, 3]))