class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        mp = {')': '(', '}': '{', ']': '['}
        for c in s:
            if c in mp:
                if stack and stack[-1] == mp[c]: stack = stack[:-1]
                else: return False
            else:
                stack.append(c)
        return not stack

print(Solution().isValid("()"))
print(Solution().isValid("()[]{}"))
print(Solution().isValid("(]"))
print(Solution().isValid("([])"))