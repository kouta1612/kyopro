from typing import List

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        memo = {}

        def helper(amount: int) -> int:
            if amount == 0: return 0
            if amount < 0 : return -1
            if amount in memo: return memo[amount]

            res = 1<<32
            for coin in coins:
                num = helper(amount - coin)
                if num == -1: continue
                res = min(res, 1 + num)
            memo[amount] = res if res != 1<<32 else -1
            return memo[amount]
        return helper(amount)

print(Solution().coinChange([1,2,5], 11))
print(Solution().coinChange([2], 3))
print(Solution().coinChange([1], 0))
print(Solution().coinChange([1], 1))
print(Solution().coinChange([1], 2))
print(Solution().coinChange([1], 3))
print(Solution().coinChange([1], 4))
print(Solution().coinChange([1], 5))