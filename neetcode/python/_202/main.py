class Solution:
    def isHappy(self, n: int) -> bool:
        memo = set()

        while n != 1:
            n = digitSquareSum(n)
            if n in memo:
                return False
            memo.add(n)

        return True


def digitSquareSum(n: int) -> int:
    res = 0

    while n != 0:
        res += (n%10)**2
        n //= 10

    return res    

print(Solution().isHappy(19))