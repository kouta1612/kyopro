from typing import List

class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        ng, ok = 0, 1<<31
        while ng + 1 < ok:
            wj = (ng + ok) // 2
            total = 0
            for pile in piles:
                total += (pile + wj - 1) // wj
            if total <= h: ok = wj
            else: ng = wj
        return ok

print(Solution().minEatingSpeed([3, 6, 7, 11], 8))
print(Solution().minEatingSpeed([30, 11, 23, 4, 20], 5))
print(Solution().minEatingSpeed([30, 11, 23, 4, 20], 6))
print(Solution().minEatingSpeed([2, 2], 2))