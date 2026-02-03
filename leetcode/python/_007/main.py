from math import fmod

class Solution:
    def reverse(self, x: int) -> int:
        MIN, MAX = -2**31, 2**31-1

        sign = 1 if x >= 0 else -1
        x = abs(x)

        cur = 0
        while x > 0:
            if sign > 0 and ((cur > MAX // 10) or ((cur == MAX // 10) and (x > 7))): return 0
            if sign < 0 and ((cur > MAX // 10) or ((cur == MAX // 10) and (x > 8))): return 0

            cur = cur * 10 + x % 10
            x //= 10
        return cur * sign

print(Solution().reverse(123))