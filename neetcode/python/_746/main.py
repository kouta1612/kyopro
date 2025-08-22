from typing import List

class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        dp1 = [1000000] * (len(cost)+1)
        dp1[0] = 0
        for i in range(len(dp1)):
            if i + 1 < len(dp1):
                dp1[i + 1] = min([dp1[i + 1], dp1[i] + cost[i]])
            if i + 2 < len(dp1):
                dp1[i + 2] = min([dp1[i + 2], dp1[i] + cost[i]])
        
        dp2 = [1000000] * (len(cost)+1)
        dp2[0] = dp2[1] = 0
        for i in range(1,len(dp2)):
            if i + 1 < len(dp2):
                dp2[i + 1] = min([dp2[i + 1], dp2[i] + cost[i]])
            if i + 2 < len(dp2):
                dp2[i + 2] = min([dp2[i + 2], dp2[i] + cost[i]])

        return min([dp1[len(dp1)-1],dp2[len(dp2)-1]])

print(Solution().minCostClimbingStairs([10,15,20]))