from typing import List

class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        start, total, cur = 0, 0, 0
        for i in range(len(gas)):
            total += gas[i] - cost[i]
            cur += gas[i] - cost[i]
            if cur < 0: cur, start = 0, i + 1
        return start if total >= 0 else -1

print(Solution().canCompleteCircuit([1,2,3,4,5], [3,4,5,1,2]))