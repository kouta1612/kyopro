class Solution:
    def myAtoi(self, s: str) -> int:
        i = 0
        while i < len(s) and s[i] == " ":
            i += 1
        
        if i == len(s):
            return 0

        sign = 1
        if s[i] == "+":
            i += 1
        elif s[i] == "-":
            i += 1
            sign = -1

        res = 0
        while i < len(s) and s[i].isdigit():
            res = res * 10 + int(s[i])
            if sign * res < -2**31:
                return -2**31
            if sign * res > 2**31-1:
                return 2**31-1
            i += 1
        
        return res * sign

print(Solution().myAtoi("42"))
print(Solution().myAtoi("   -42"))
print(Solution().myAtoi("4193 with words"))
print(Solution().myAtoi("words and 987"))
print(Solution().myAtoi("-91283472332"))
print(Solution().myAtoi("3.14159"))
print(Solution().myAtoi("+-12"))
print(Solution().myAtoi("00000-42a1234"))
print(Solution().myAtoi("   +0 123"))