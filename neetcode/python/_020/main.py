class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        mp = {'}': '{', ']': '[', ')': '(', '(': None, '[': None, '{': None}
        for char in s:
            n = len(stack)
            if n > 0 and mp[char] == stack[n-1]:
                stack = stack[:n-1]
            else:
                stack.append(char)
        return len(stack) == 0

print(Solution().isValid("()"))
print(Solution().isValid("()[]{}"))
print(Solution().isValid("(]"))
print(Solution().isValid("([])"))