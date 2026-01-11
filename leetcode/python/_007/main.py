from math import fmod

class Solution:
    def reverse(self, x: int) -> int:
        MAX_VALUE = 2**31 - 1

        sign = 1 if x >= 0 else -1
        x = abs(x)
        res = 0
        while x != 0:
            digit = x % 10
            x //= 10
            if res > MAX_VALUE // 10 or (res == MAX_VALUE and digit > 7): return 0
            res = res * 10 + digit
        return res * sign

print(Solution().reverse(123))