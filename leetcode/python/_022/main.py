from typing import List

class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []
        def dfs(s: str, opened, closed: int):
            if opened == n and closed == n:
                res.append(s)
                return
            if opened < n: dfs(s + "(", opened + 1, closed)
            if closed < opened: dfs(s + ")", opened, closed + 1)
        dfs("", 0, 0)
        return res

print(Solution().generateParenthesis(3))
print(Solution().generateParenthesis(1))