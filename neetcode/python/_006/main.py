class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows == 1: return s
        
        res = ""
        for i in range(numRows):
            increment = (numRows - 1) * 2
            for j in range(i, len(s), increment):
                res += s[j]
                if 0 < i < numRows - 1 and j + increment - 2 * i < len(s):
                    res += s[j + increment - 2 * i]
        return res

print(Solution().convert("PAYPALISHIRING", 3))
print(Solution().convert("PAYPALISHIRING", 4))
print(Solution().convert("A", 1))