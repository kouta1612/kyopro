from typing import List

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [1<<32] * (amount + 1)
        dp[0] = 0
        coins.sort()
        for i in range(1, amount + 1):
            for j in range(len(coins)):
                if i - coins[j] < 0: break
                dp[i] = min(dp[i], dp[i - coins[j]] + 1)
        return dp[amount] if dp[amount] != 1<<32 else -1

print(Solution().coinChange([1,2,5], 11))
print(Solution().coinChange([2], 3))
print(Solution().coinChange([1], 0))
print(Solution().coinChange([1], 1))
print(Solution().coinChange([1], 2))
print(Solution().coinChange([1], 3))
print(Solution().coinChange([1], 4))
print(Solution().coinChange([1], 5))