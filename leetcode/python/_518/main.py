from typing import List

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [0] * (amount + 1)
        dp[0] = 1
        for coin in coins:
            for v in range(0, amount + 1 - coin):
                dp[v + coin] += dp[v]
        return dp[amount]

print(Solution().change(5, [1,2,5]))