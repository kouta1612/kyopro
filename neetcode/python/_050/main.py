class Solution:
    def myPow(self, x: float, n: int) -> float:
        def helper(x: float, n: int) -> float:
            if n == 0: return 1
            if n % 2 == 0: 
                val = helper(x, n // 2)
                return val * val
            return x * helper(x, n - 1)
        res = helper(x, abs(n))
        return res if n >= 0 else 1 / res

print(Solution().myPow(2.00000, 10))
print(Solution().myPow(2.10000, 3))
print(Solution().myPow(2.00000, -2))
print(Solution().myPow(2.00000, 0))
print(Solution().myPow(2.00000, 1))
print(Solution().myPow(2.00000, 2))
print(Solution().myPow(2.00000, 3))