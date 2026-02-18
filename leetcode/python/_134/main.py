from typing import List

class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        if sum(gas) < sum(cost): return -1
        start, tank = 0, 0
        for i in range(len(gas)):
            tank = tank + gas[i] - cost[i]
            if tank < 0: start, tank = i+1, 0
        return start

print(Solution().canCompleteCircuit([1,2,3,4,5], [3,4,5,1,2]))