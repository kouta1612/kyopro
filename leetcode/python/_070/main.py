class Solution:
    def climbStairs(self, n: int) -> int:
        dp = [0] * (n + 1)
        dp[0] = dp[1] = 1
        for i in range(2, n + 1):
            dp[i] = dp[i-1] + dp[i-2]
        return dp[n]

print(Solution().climbStairs(2))
print(Solution().climbStairs(3))
print(Solution().climbStairs(4))
print(Solution().climbStairs(5))
print(Solution().climbStairs(6))
print(Solution().climbStairs(7))
print(Solution().climbStairs(8))
print(Solution().climbStairs(9))
print(Solution().climbStairs(10))