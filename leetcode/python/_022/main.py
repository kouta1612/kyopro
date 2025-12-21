from typing import List

class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []
        def dfs(cur: int, s: str, opened, closed: int):
            if opened < closed: return
            if cur == n * 2:
                if opened == closed: res.append(s)
                return
            dfs(cur + 1, s + "(", opened + 1, closed)
            dfs(cur + 1, s + ")", opened, closed + 1)
        dfs(0, "", 0, 0)
        return res


print(Solution().generateParenthesis(3))
print(Solution().generateParenthesis(1))