from typing import List

class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        ng, ok = 0, 500 * len(weights) + 1
        while ok - ng > 1:
            wj = (ok + ng) // 2
            if self.helper(weights, days, wj):
                ok = wj
            else:
                ng = wj
        return ok

    def helper(self, weights: List[int], day, cap: int) -> bool:
        d, s, i, j = 0, 0, 0, 0
        while i < len(weights):
            while j < len(weights) and s + weights[j] <= cap:
                s += weights[j]
                j += 1
            if i == j:
                return False
            if d > day:
                return False
            d += 1
            i = j
            s = 0
        return d <= day

print(Solution().shipWithinDays([1,2,3,4,5,6,7,8,9,10], 5))
print(Solution().shipWithinDays([3,2,2,4,1,4], 3))
print(Solution().shipWithinDays([1,2,3,1,1], 4))