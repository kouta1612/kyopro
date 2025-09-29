class Solution:
    def myPow(self, x: float, n: int) -> float:
        def helper(x: float, n: int) -> float:
            if n == 0:
                return 1.0
            if n % 2 == 1:
                return x * helper(x, n - 1)
            else:
                v = helper(x, n // 2)
                return v * v
        v = helper(x, abs(n))
        return v if n >= 0 else 1 / v

print(Solution().myPow(2.00000, 10))
print(Solution().myPow(2.10000, 3))
print(Solution().myPow(2.00000, -2))
print(Solution().myPow(2.00000, 0))
print(Solution().myPow(2.00000, 1))
print(Solution().myPow(2.00000, 2))
print(Solution().myPow(2.00000, 3))