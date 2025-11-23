from typing import List

class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []

        def dfs(i: int, cur: str):
            if i == n * 2:
                if self.isParenthes(cur): res.append(cur)
                return
            dfs(i + 1, cur + "(")
            dfs(i + 1, cur + ")")

        dfs(0, "")
        return res

    def isParenthes(self, word: str) -> bool:
        stack = []
        for c in word:
            if not stack and c == ")": return False
            if stack and stack[-1] == "(" and c == ")": stack.pop()
            else: stack.append(c)
        return len(stack) == 0

print(Solution().generateParenthesis(3))
print(Solution().generateParenthesis(1))