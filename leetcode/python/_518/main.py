from typing import List

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [[0] * (len(coins) + 1) for _ in range(amount + 1)]
        dp[0] = [1] * (len(coins) + 1)
        for i in range(1, amount + 1):
            for j in range(len(coins) - 1, -1, -1):
                dp[i][j] = dp[i][j + 1]
                if i - coins[j] >= 0:
                    dp[i][j] += dp[i-coins[j]][j]
        return dp[amount][0]

print(Solution().change(5, [1,2,5]))