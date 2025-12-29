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
                substr = s[i:j+1]
                if substr == substr[::-1]:
                    part.append(substr)
                    dfs(j+1)
                    part.pop()
        dfs(0)
        return res

print(Solution().partition("aab"))