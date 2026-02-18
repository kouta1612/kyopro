from typing import List

class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        if sum(gas) < sum(cost): return -1

        now = 0
        res = -1
        for i in range(len(gas)):
            if now + gas[i] < cost[i]:
                now = 0
                res = -1
                continue
            now = now + gas[i] - cost[i]
            if res == -1: res = i
        return res

print(Solution().canCompleteCircuit([1,2,3,4,5], [3,4,5,1,2]))