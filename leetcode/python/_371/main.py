class Solution:
    def getSum(self, a: int, b: int) -> int:
        MASK = 0xffffffff
        INTMAX = 0x7fffffff
        while b&MASK != 0:
            a, b = a^b, (a&b)<<1
        return a if b <= INTMAX else ~(a^MASK)

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