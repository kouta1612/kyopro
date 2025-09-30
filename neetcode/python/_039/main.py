from typing import List


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        dp = [[] for _ in range(target + 1)]
        dp[0] = [[]]
        for c in candidates:
            for t in range(c, target + 1):
                for comb in dp[t-c]:
                    newcomb = comb.copy()
                    newcomb.append(c)
                    dp[t].append(newcomb)
        return dp[target]

print(Solution().combinationSum([2,3,6,7], 7))
print(Solution().combinationSum([2,3,5], 8))
print(Solution().combinationSum([2], 1))