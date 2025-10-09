class Solution:
    def myPow(self, x: float, n: int) -> float:
        def helper(x: float, n: int) -> float:
            if n == 0: return 1
            if n % 2 == 0:
                v = helper(x, n // 2)
                return v * v
            return x * helper(x, n - 1)

        sign = 1 if x >= 0 or abs(n) % 2 == 0 else -1
        res = helper(abs(x), abs(n))
        return res * sign if n >= 0 else sign * 1 / res

print(Solution().myPow(2.00000, 10))
print(Solution().myPow(2.10000, 3))
print(Solution().myPow(2.00000, -2))
print(Solution().myPow(2.00000, 0))
print(Solution().myPow(2.00000, 1))
print(Solution().myPow(2.00000, 2))
print(Solution().myPow(2.00000, 3))