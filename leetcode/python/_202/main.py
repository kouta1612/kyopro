class Solution:
    def isHappy(self, n: int) -> bool:
        memo = set()

        while n not in memo:
            memo.add(n)
            n = digitSquareSum(n)
            if n == 1:
                return True

        return False


def digitSquareSum(n: int) -> int:
    res = 0

    while n != 0:
        res += (n%10)**2
        n //= 10

    return res 

print(Solution().isHappy(19))