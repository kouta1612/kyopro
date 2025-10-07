from typing import List

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [1<<15] * (amount + 1)
        dp[0] = 0

        for i in range(1, amount + 1):
            for coin in coins:
                if i-coin < 0: continue
                dp[i] = min(dp[i], 1 + dp[i-coin])
        return dp[amount] if dp[amount] != 1<<15 else -1

print(Solution().coinChange([1,2,5], 11))
print(Solution().coinChange([2], 3))
print(Solution().coinChange([1], 0))
print(Solution().coinChange([1], 1))
print(Solution().coinChange([1], 2))
print(Solution().coinChange([1], 3))
print(Solution().coinChange([1], 4))
print(Solution().coinChange([1], 5))