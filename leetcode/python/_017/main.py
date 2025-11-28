from typing import List

class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        mapDigitToAlphas = {
            '2': ['a', 'b', 'c'],
            '3': ['d', 'e', 'f'],
            '4': ['g', 'h', 'i'],
            '5': ['j', 'k', 'l'],
            '6': ['m', 'n', 'o'],
            '7': ['p', 'q', 'r', 's'],
            '8': ['t', 'u', 'v'],
            '9': ['w', 'x', 'y', 'z']
        }

        res = []

        def dfs(i: int, cur: List[str]):
            if i == len(digits):
                res.append("".join(cur))
                return
            for c in mapDigitToAlphas[digits[i]]:
                cur.append(c)
                dfs(i + 1, cur)
                cur.pop()
        
        dfs(0, [])
        return res

print(Solution().letterCombinations("23"))