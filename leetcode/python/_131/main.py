from typing import List

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res = []
        part = []

        def dfs(i: int):
            if i == len(s):
                res.append(part[:])
                return
            for j in range(i, len(s)):
                if self.palindrome(s, i, j):
                    part.append(s[i:j+1])
                    dfs(j+1)
                    part.pop()
        dfs(0)
        return res

    def palindrome(self, s: str, i, j: int) -> bool:
        while i < j:
            if s[i] != s[j]: return False
            i += 1
            j -= 1
        return True

print(Solution().partition("aab"))