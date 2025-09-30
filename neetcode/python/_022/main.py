from typing import List

class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []

        def helper(open, close: int, s: str):
            if len(s) == n * 2:
                res.append(s)
                return
            if open < n:
                helper(open + 1, close, s + "(")
            if open > close:
                helper(open, close + 1, s + ")")
        
        helper(0, 0, "")
        return res

print(Solution().generateParenthesis(3))
print(Solution().generateParenthesis(1))