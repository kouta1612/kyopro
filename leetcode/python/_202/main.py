class Solution:
    def isHappy(self, n: int) -> bool:
        numberMap = {}
        while n != 1:
            cur, total = n, 0
            while cur != 0:
                total += (cur % 10) ** 2
                cur //= 10
            n = total
            if n in numberMap: return False
            numberMap[n] = True
        return True

print(Solution().isHappy(19))