from math import fmod

class Solution:
    def reverse(self, x: int) -> int:
        MIN, MAX = -1<<31, (1<<31) - 1
        res = 0
        while x:
            digit = int(fmod(x, 10))
            x = int(x / 10)

            if (res > MAX // 10 or 
                (res == MAX // 10 and digit > MAX % 10) or 
                res < int(MIN / 10) or 
                (res == int(MIN / 10) and digit < int(fmod(MIN, 10)))):
                return 0
            res = res * 10 + digit
        return res

print(Solution().reverse(123))