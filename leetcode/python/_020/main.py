class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        mp = {'}': '{', ']': '[', ')': '(', '(': None, '[': None, '{': None}
        for char in s:
            if stack and mp[char] == stack[-1]:
                stack.pop()
            else:
                stack.append(char)
        return len(stack) == 0

print(Solution().isValid("()"))
print(Solution().isValid("()[]{}"))
print(Solution().isValid("(]"))
print(Solution().isValid("([])"))