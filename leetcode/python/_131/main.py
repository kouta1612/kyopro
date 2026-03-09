from typing import List

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        n = len(s)
        res = []

        def dfs(start: int, path: List[int]):
            if start == n:
                res.append(path[:])
                return
            for i in range(start, n):
                if s[start:i+1] == s[start:i+1][::-1]:
                    path.append(s[start:i+1])
                    dfs(i+1, path)
                    path.pop()
        
        dfs(0, [])
        return res

print(Solution().partition("aab"))