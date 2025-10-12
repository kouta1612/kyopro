from typing import List

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        self.memo = {0: 0}
        def helper(rem: int) -> int:
            if rem < 0: return 1<<32
            if rem in self.memo: return self.memo[rem]

            best = 1<<32
            for coin in coins:
                num = helper(rem - coin)
                best = min(best, num + 1)
            self.memo[rem] = best
            return self.memo[rem]
        return -1 if helper(amount) == 1<<32 else self.memo[amount]

print(Solution().coinChange([1,2,5], 11))
print(Solution().coinChange([2], 3))
print(Solution().coinChange([1], 0))
print(Solution().coinChange([1], 1))
print(Solution().coinChange([1], 2))
print(Solution().coinChange([1], 3))
print(Solution().coinChange([1], 4))
print(Solution().coinChange([1], 5))