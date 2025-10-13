class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows == 1:
            return s

        res = ""
        for row in range(1, numRows + 1):
            idx, increment = row - 1, (numRows - 1) * 2
            while idx < len(s):
                res += s[idx]
                if row not in [1, numRows]:
                    nextidx = idx + (numRows - row) * 2
                    if nextidx < len(s):
                        res += s[nextidx]
                idx += increment
        return res

print(Solution().convert("PAYPALISHIRING", 3))
print(Solution().convert("PAYPALISHIRING", 4))
print(Solution().convert("A", 1))