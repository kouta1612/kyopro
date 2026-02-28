from typing import List

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        n = len(s)
        res = []

        def dfs(start: int, path: List[int]):
            if start == n:
                res.append(path[:])
                return
            for end in range(start, n):
                if s[start:end+1] != s[start:end+1][::-1]: continue
                path.append(s[start:end+1])
                dfs(end+1, path)
                path.pop()
        dfs(0, [])
        return res


print(Solution().partition("aab"))