from typing import List

class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []
        length = 2 * n
        for bit in range(1<<length):
            parenthesis = ""
            for i in range(length):
                parenthesis += "(" if bit & 1<<i else ")"
            if self.helper(parenthesis):
                res.append(parenthesis)
        return res

    def helper(self, parenthesis: str) -> bool:
        stack = []
        for p in parenthesis:
            if len(stack) and p == ")" and stack[-1] == "(":
                stack.pop()
            else:
                stack.append(p)
        return len(stack) == 0

print(Solution().generateParenthesis(3))
print(Solution().generateParenthesis(1))