class Solution:
    def getSum(self, a: int, b: int) -> int:
        MASK = 0xffffffff
        MAX_INT = 0x7fffffff
        while b != 0:
            a, b = (a^b)&MASK, ((a&b)<<1)&MASK
        return a if a <= MAX_INT else ~(a^MASK)

print(Solution().getSum(1, 2))
print(Solution().getSum(2, 3))
print(Solution().getSum(3, 4))
print(Solution().getSum(4, 5))
print(Solution().getSum(5, 6))
print(Solution().getSum(6, 7))
print(Solution().getSum(7, 8))
print(Solution().getSum(8, 9))
print(Solution().getSum(9, 10))
print(Solution().getSum(10, 11))