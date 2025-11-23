from typing import List

class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []

        def dfs(opened, closed: int, cur: str):
            if opened == n and closed == n:
                res.append(cur)
                return
            if opened < n: dfs(opened + 1, closed, cur + "(")
            if closed < opened: dfs(opened, closed + 1, cur + ")")

        dfs(0, 0, "")
        return res


print(Solution().generateParenthesis(3))
print(Solution().generateParenthesis(1))